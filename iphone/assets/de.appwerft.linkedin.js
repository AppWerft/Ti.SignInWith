/*
 * LinkedIn account authentfication library / module
 * by Rainer Schleevoigt
 *
 *
 * Copyright 2016 Rainer Schleevoigt
 *
 * All code is open source and dual licensed under GPL and MIT. Check the individual licenses for more information.

 USAGE:
 ======
 var LinkedIn = new (require('lib/linkedinoauth'))();
 LinkedIn.get('people/~',function(_e) {
 if (_e.ok) {
 console.log(_e.data);
 }
 });

 * LinkedIn authentification for Titanium

 */
var ACCESSTOKEN_URL = 'https://www.linkedin.com/oauth/v2/accessToken',
    REQUEST_AUTHORIZATION_URL = 'https://www.linkedin.com/oauth/v2/authorization',
    RESTAPI_URL = "https://api.linkedin.com/v1/",
    BLANK_DUMMY_WEBPAGE = 'https://upload.wikimedia.org/wikipedia/en/b/b1/Portrait_placeholder.png',
    FAKE_USERAGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X x.y; rv:10.0) Gecko/20100101 Firefox/10.0";

var _opt,
    _prop;
var _initialized = false;

function encodeQueryData(data) {
	return Object.getOwnPropertyNames(data).map(function(item) {
		return encodeURIComponent(item) + "=" + encodeURIComponent(data[item]);
	}).join('&');

}

var init = function() {
	console.log('Info: init of LinkedIn started');
	var _version = '0.3.2';
	o = arguments[0] || {};
	var scope = o.scope || [];

	_opt = {
		clientId : (o.clientId) ? o.clientId : Ti.App.Properties.getString("linkedin_id"),
		clientSecret : (o.clientSecret) ? o.clientSecret : Ti.App.Properties.getString("linkedin_secret"),
		propertyName : 'LinkedInToken',
		scope : scope,
	};
	var win;
	_prop = {
		accessToken : null,
		expiresIn : 0
	};
	var prop = {
		accessToken : Ti.App.Properties.getString(_opt.propertyName + '.accessToken'),
		expiresIn : Ti.App.Properties.getString(_opt.propertyName + '.expiresIn')
	};

	if (prop.expiresIn >= (new Date()).getTime()) {
		_prop = prop;
	}
	console.log(_opt);
	_initialized = true;
};
/**
 * Get TOKEN
 */
function _getToken(code, callback) {
	callback = (callback) ? callback : function() {
	};
	console.log("Try to get access token:");
	var xhr = Ti.Network.createHTTPClient({
		// function called when the response data is available
		onload : function(e) {
			try {
				var resp = JSON.parse(this.responseText);
				resp.expires_in = parseFloat(resp.expires_in, 10) * 1000 + (new Date()).getTime();
				console.log(resp.expires_in);
				Ti.App.Properties.setString(_opt.propertyName + '.accessToken', resp.access_token);
				Ti.App.Properties.setString(_opt.propertyName + '.expiresIn', resp.expires_in);
				_prop.accessToken = resp.access_token;
				_prop.expiresIn = resp.expires_in;
			} catch(E) {
				console.log("Error: by parsing JSON answer from server");
				console.log(E);
			}
			//alert('success');
			win.close();
			//callback
			callback();
		},
		onerror : function(e) {
		}
	});
	// Prepare the connection.
	var payload = {
		"grant_type" : 'authorization_code',
		"code" : code,
		"redirect_uri" : BLANK_DUMMY_WEBPAGE,
		"client_id" : _opt.clientId,
		"client_secret" : _opt.clientSecret,
	};
	xhr.open("POST", ACCESSTOKEN_URL);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.setRequestHeader('User-Agent', FAKE_USERAGENT);
	xhr.send(payload);
}

function _authorize(_callback) {
	callback = (_callback) ? _callback : function() {
	};
	win = Ti.UI.createWindow({
		backgroundImage : '/karo.png',
		modal : true,
		theme : 'Theme.AppCompat.NoTitleBar',
	});
	var spinner = Ti.UI.createActivityIndicator({
		zIndex : 99,
		style : Ti.UI.ActivityIndicatorStyle.BIG_DARK
	});
	win.add(spinner);
	//	&scope=r_basicprofile&redirect_uri=" + BLANK_DUMMY_WEBPAGE + "&response_type=code&client_id=77981gf1tq1xfs&btmpl=mobile"
	var url = [REQUEST_AUTHORIZATION_URL, encodeQueryData({
		approval_prompt : "force",
		scope : _opt.scope.join(' '),
		redirect_uri : BLANK_DUMMY_WEBPAGE,
		response_type : 'code',
		client_id : _opt.clientId,
		btmpl : "mobile"
	})].join('?');
	console.log("≠≠≠≠≠≠≠≠≠≠≠Start Authorization against LinkedIn≠≠≠≠≠≠≠≠≠≠≠≠≠≠\n" + url);

	var webview = Ti.UI.createWebView({
		borderWidth : 3,
		borderColor : "#1D87BD",
		borderRadius : 5,
		userAgent : FAKE_USERAGENT,
		transform : Ti.UI.create2DMatrix({
			scale : 0.92
		})
	});
	var redirectCounter = 0;
	var code = null;
	webview.addEventListener('load', function(_e) {
		var res = null;
		redirectCounter++;
		var url = _e.source.url;
		var regex = /code=(.*)/gm;
		if ( res = regex.exec(url)) {
			code = res[1];
			win.close();
			if (code != null) {
				webview.hide();
				spinner.show();
				_getToken(code, callback);
			}
		}
		regex = /error=(.*)/gm;
		if ( res = regex.exec(url)) {
			code = res[1];
			win.close();
			if (code != null) {
				console.log('Error: ' + code);
			}
		}
	});
	webview.setUrl(url);
	//"https://www.linkedin.com/oauth/v2/authorization?approval_prompt=force&scope=r_basicprofile&redirect_uri=" + BLANK_DUMMY_WEBPAGE + "&response_type=code&client_id=77981gf1tq1xfs&btmpl=mobile");
	win.add(webview);
	win.open();
}

/* MAIN  function */
var _doGet = function(_query, _callback) {
	_initialized || init();
	console.log(_query);
	var loopcounter = 0;
	query = _query;
	var callback = _callback;
	function mGet() {
		loopcounter++;
		var url = RESTAPI_URL + query + '?format=json';
		var bearer = Ti.App.Properties.getString(_opt.propertyName + '.accessToken', null);
		if (bearer == null) {
			_authorize(mGet);
			return;
		}
		console.log("Info: doGet try this request: " + url);
		console.log("Info: doGet try this bearer: " + bearer);
		var $ = Ti.Network.createHTTPClient({
			onload : function() {
				if (this.status == 401) {
					console.log("Warning: 401 => open login dialog");
					_authorize(mGet);
				} else if (this.status == 200) {
					try {
						var payload = JSON.parse(this.responseText);
						callback({
							ok : true,
							data : payload
						});
					} catch(E) {
						console.log(E);
						callback({
							ok : false,
							error : E
						});
					}
				}
			},
			onerror : function(error) {
				try {
					var res = JSON.parse(this.responseText);
					console.log(res);
					_authorize(mGet);
				} catch (E) {
					callback({
						ok : false,
						data : E
					});
				}
			}
		});
		$.open('GET', url);
		$.setRequestHeader("Content-Type", "application/json");
		$.setRequestHeader("x-li-format", "json");
		$.setRequestHeader("Connection", "keep-alive");
		$.setRequestHeader("Authorization", "Bearer " + bearer);
		$.send();
	}

	mGet();
};

var _doPost = function(_query, _payload, _callback) {
	_initialized || init();
	console.log(_query);
	var loopcounter = 0;
	query = _query;
	var callback = _callback;
	function mPost() {
		loopcounter++;
		var url = RESTAPI_URL + query + '?format=json';
		var bearer = Ti.App.Properties.getString(_opt.propertyName + '.accessToken', null);
		if (bearer == null) {
			_authorize(mGet);
			return;
		}
		console.log("Info: doGet try this request: " + url);
		console.log("Info: doGet try this bearer: " + bearer);
		var $ = Ti.Network.createHTTPClient({
			onload : function() {
				if (this.status == 401) {
					console.log("Warning: 401 => open login dialog");
					_authorize(mPost);
				} else if (this.status == 200) {
					try {
						var payload = JSON.parse(this.responseText);
						callback({
							ok : true,
							data : payload
						});
					} catch(E) {
						console.log(E);
						callback({
							ok : false,
							error : E
						});
					}
				}
			},
			onerror : function(error) {
				try {
					var res = JSON.parse(this.responseText);
					console.log(res);
					_authorize(mPost);
				} catch (E) {
					callback({
						ok : false,
						data : E
					});
				}
			}
		});
		$.open('POST', url);
		$.setRequestHeader("Content-Type", "application/json");
		$.setRequestHeader("x-li-format", "json");
		$.setRequestHeader("Connection", "keep-alive");
		$.setRequestHeader("Authorization", "Bearer " + bearer);
		$.send(JSON.stringify(_payload));
	}

	mPost();
};

function getProfileWithContacts(_id, _callback) {
	// needs scope 'r_basicprofile','r_contactinfo','r_fullprofile'
	_doGet('people/~:(id,first-name,last-name,num-connections,picture-url,maiden-name,headline,location,summary,email-address,positions,phone-numbers,bound-account-types,im-accounts,main-address,twitter-accounts,primary-twitter-account)', _callback);
}

function getPositionById(_id, _callback) {
	// needs scope 'r_basicprofile','r_fullprofile'
	_doGet('position/~:(id,title,summary,start-date,end-date,is-current,company)', _callback);
}

function getCompanyById(_id, _callback) {
	_doGet('company/~:(id,name,type,industry)', _callback);
}

function postShare(_comment, _callback) {
	_doPost('people/~/shares?format=json', {
		comment : _comment,
		visibility : "everyone"
	}, _callback);
}

function getProfile(_id, _callback) {
	// needs scope 'r_basicprofile','r_fullprofile'
	_doGet('people/~:(id,first-name,last-name,num-connections,picture-url,maiden-name,headline,location,summary,email-address,positions)', _callback);
}

module.exports = {
	get : _doGet, // generic access
	getProfile : getProfile,
	getProfileWithContacts : getProfileWithContacts,
	getPositionById : getPositionById,
	getCompanyById : getCompanyById,
	postShare : postShare
};
