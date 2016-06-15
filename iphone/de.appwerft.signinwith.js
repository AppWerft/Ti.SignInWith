var providers = {
	"linkedin" : {
		title : "LinkedIn",
		REQUEST_AUTHORIZATION_URL : 'https://www.linkedin.com/oauth/v2/authorization',
		ACCESSTOKEN_URL : 'https://www.linkedin.com/oauth/v2/accessToken',
		PROFILE_URL : 'https://api.linkedin.com/v1/people/~:(id,first-name,last-name,num-connections,picture-url,maiden-name,headline,location,summary,email-address,positions)',
		BLANK_DUMMY_WEBPAGE : 'https://upload.wikimedia.org/wikipedia/en/b/b1/Portrait_placeholder.png',
		FAKE_USERAGENT : "Mozilla/5.0 (Macintosh; Intel Mac OS X x.y; rv:10.0) Gecko/20100101 Firefox/10.0",
		SCOPE : "r_basicprofile",
		version : 2
	},
	"amazone" : {
		title : "Amazone",
		REQUEST_AUTHORIZATION_URL : 'https://www.linkedin.com/oauth/v2/authorization',
		ACCESSTOKEN_URL : 'https://www.linkedin.com/oauth/v2/accessToken',
		PROFILE_URL : 'https://api.linkedin.com/v1/people/~:(id,first-name,last-name,num-connections,picture-url,maiden-name,headline,location,summary,email-address,positions)',
		BLANK_DUMMY_WEBPAGE : 'https://upload.wikimedia.org/wikipedia/en/b/b1/Portrait_placeholder.png',
		FAKE_USERAGENT : "Mozilla/5.0 (Macintosh; Intel Mac OS X x.y; rv:10.0) Gecko/20100101 Firefox/10.0",
		SCOPE : "r_basicprofile",
		version : 2
	},
	"slack" : {
		title : 'Slack',
		REQUEST_AUTHORIZATION_URL : 'https://slack.com/oauth/authorize',
		ACCESSTOKEN_URL : 'https://slack.com/api/oauth.access',
		PROFILE_URL : "https://slack.com/api/users.list",
		BLANK_DUMMY_WEBPAGE : 'https://upload.wikimedia.org/wikipedia/en/b/b1/Portrait_placeholder.png',
		FAKE_USERAGENT : "Mozilla/5.0 (Macintosh; Intel Mac OS X x.y; rv:10.0) Gecko/20100101 Firefox/10.0",
		SCOPE : "users:read",

		version : 2
	},
	"facebook" : {
		title : 'Facebook',
		REQUEST_AUTHORIZATION_URL : 'https://www.facebook.com/dialog/oauth',
		ACCESSTOKEN_URL : 'https://graph.facebook.com/v2.3/oauth/access_token',
		PROFILE_URL : "https://graph.facebook.com/v2.3/me",
		BLANK_DUMMY_WEBPAGE : 'https://upload.wikimedia.org/wikipedia/en/b/b1/Portrait_placeholder.png',
		FAKE_USERAGENT : "Mozilla/5.0 (Macintosh; Intel Mac OS X x.y; rv:10.0) Gecko/20100101 Firefox/10.0",
		SCOPE : "public_profile",
		version : 2
	},
	"gplus" : {
		title : 'Google+',
		REQUEST_AUTHORIZATION_URL : 'https://accounts.google.com/o/oauth2/auth',
		ACCESSTOKEN_URL : 'https://www.googleapis.com/oauth2/v3/token',
		PROFILE_URL : "https://www.googleapis.com/plus/v1/people/me",
		BLANK_DUMMY_WEBPAGE : 'https://upload.wikimedia.org/wikipedia/en/b/b1/Portrait_placeholder.png',
		FAKE_USERAGENT : "Mozilla/5.0 (Macintosh; Intel Mac OS X x.y; rv:10.0) Gecko/20100101 Firefox/10.0",
		SCOPE : "https://www.googleapis.com/auth/tasks",
		version : 2
	},
	"dropbox" : {
		title : 'Dropbox',
		REQUEST_AUTHORIZATION_URL : 'https://www.dropbox.com/1/oauth2/authorize',
		ACCESSTOKEN_URL : 'https://www.dropbox.com/1/oauth2/token',
		PROFILE_URL : "https://api.dropboxapi.com/2/users/get_current_account",
		BLANK_DUMMY_WEBPAGE : 'https://upload.wikimedia.org/wikipedia/en/b/b1/Portrait_placeholder.png',
		FAKE_USERAGENT : "Mozilla/5.0 (Macintosh; Intel Mac OS X x.y; rv:10.0) Gecko/20100101 Firefox/10.0",
		SCOPE : "",
		version : 2
	}/*,
	 "twitter" : {
	 title : 'Twitter',
	 REQUEST_AUTHORIZATION_URL : 'https://www.linkedin.com/oauth/v2/authorization',
	 ACCESSTOKEN_URL : 'https://api.twitter.com/oauth2/token',
	 PROFILE_URL : "https://api.linkedin.com/v1/",
	 BLANK_DUMMY_WEBPAGE : 'https://upload.wikimedia.org/wikipedia/en/b/b1/Portrait_placeholder.png',
	 FAKE_USERAGENT : "Mozilla/5.0 (Macintosh; Intel Mac OS X x.y; rv:10.0) Gecko/20100101 Firefox/10.0",
	 scope : "read",version :1
	 }*/
};

var _opt,
    _prop;

function encodeQueryData(data) {
	return Object.getOwnPropertyNames(data).map(function(item) {
		return encodeURIComponent(item) + "=" + encodeURIComponent(data[item]);
	}).join('&');

}

var init = function(_provider) {
	_opt = providers[_provider];
	if (!_opt) {
		console.log('Error: ' + _provider + ' is not yet supported');
		return false;
	}
	_opt.propertyName = _provider + 'Token';
	try {
		_opt.clientId = Ti.App.Properties.getString(_provider + "_clientId").replace(':', '.');
	} catch(E) {
	}
	_opt.clientSecret = Ti.App.Properties.getString(_provider + "_clientSecret");
	_opt.team = Ti.App.Properties.getString(_provider + "_team");

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
		"redirect_uri" : _opt.BLANK_DUMMY_WEBPAGE,
		"client_id" : _opt.clientId,
		"client_secret" : _opt.clientSecret,
	};
	xhr.open("POST", _opt.ACCESSTOKEN_URL);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.setRequestHeader('User-Agent', _opt.FAKE_USERAGENT);
	xhr.send(payload);
}

function _authorize(_callback) {

	var callback = _callback;
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
	var url = [_opt.REQUEST_AUTHORIZATION_URL, encodeQueryData({
		approval_prompt : "force",
		redirect_uri : _opt.BLANK_DUMMY_WEBPAGE,
		response_type : 'code',
		scope : [_opt.SCOPE],
		team : _opt.team,
		client_id : _opt.clientId,
		btmpl : "mobile"
	})].join('?');
	console.log(_opt);
	console.log("≠≠≠≠≠≠≠≠≠≠≠Start Authorization against≠≠≠≠≠≠≠≠≠≠≠≠≠≠\n" + url);

	var webview = Ti.UI.createWebView({
		borderWidth : 3,
		borderColor : "#1D87BD",
		borderRadius : 5,
		enableZoomControls : false,
		userAgent : _opt.FAKE_USERAGENT,
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

var getAccessToken = function(_provider) {

	return Ti.App.Properties.getString(_opt.propertyName + '.accessToken', null);
};

/* MAIN  function */
var getProfile = function(_provider, _callback) {
	console.log(_provider + "\n...................");
	init(_provider);
	var loopcounter = 0;
	var callback = _callback;
	function mGet() {
		loopcounter++;
		var url = _opt.PROFILE_URL;
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

function createSelectDialog() {
	var args = arguments[0] || {};
	var cb = arguments[1] ||
	function() {
	};
	var providerArray = Object.getOwnPropertyNames(providers);
	if (Ti.Android) {
		var container = Ti.UI.createView({
			layout : 'vertical',
			opacity : 0,
			top : 20,
			backgroundColor : 'white'
		});
		providerArray.forEach(function(p) {
			var url = 'https://raw.githubusercontent.com/AppWerft/Ti.SignInWith/master/documentation/' + p + '.png';
			container.add(Ti.UI.createImageView({
				image : url,
				height : 80,
				top : 0,
				provider : p,
				borderWidth : 5,
				borderColor : 'white',
				width : '100%'
			}));
		});
		var dialog = Ti.UI.createAlertDialog({
			androidView : container,
			title : "Connect with your social provider:"
		});
		dialog.show();
		container.animate({
			opacity : 1
		});
		container.addEventListener('click', function(_e) {
			console.log(_e.source.provider);
			cb && cb(_e.source.provider);
			dialog.hide();
			dialog = null;
		});
	} else {
		var dialog = Ti.UI.createOptionDialog({
			cancel : providerArray.length,
			title : args.title || '',
			options : providerArray.push('Cancel')
		});
		dialog.addEventListener('click', function(_e) {
			if (_e.cancel != _e.index && cb) {
				cb(providerArray[_e.index]);
				dialog.hide();
				dialog = null;
			}
		});
		dialog.show();
	}

}

module.exports = {
	getProfile : getProfile,
	getAccessToken : getAccessToken,
	createSelectDialog : createSelectDialog

};
