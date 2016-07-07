! function() {
	var $ = Titanium.UI.createWindow({
		title : 'SignIn API Test',
		backgroundImage : '/karo.png'
	});
	var button = Ti.UI.createButton({
		height : 80,
		width : '80%',
		title : 'Login with …'
	});
	$.add(button);
	$.addEventListener('open', function() {
		var SI = require('de.appwerft.signinwith');
		require('lib/permissions').requestPermissions('WRITE_EXTERNAL_STORAGE', function(success) {
			if (success) {
				button.addEventListener('click', function() {
					var dialog = SI.createSelectDialog({
						title : ''
					}, function(provider) {
						SI.getProfile(provider, function(_e) {
							alert(_e.data);
						});
					});
				});
			}
		});

	});
	$.open();
}();
