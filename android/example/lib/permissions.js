		exports.requestPermissions = function(_permissions, _callback) {
		if (Ti.Platform.osname != 'android') {
			_callback(true);
			return;
		}
		var permissions = (Array.isArray(_permissions) ? _permissions : [_permissions]).map(function(perm) {
			return (perm.match(/^android\.permission\./)) ? perm : 'android.permission.' + perm;
		});
		var grantedpermissions = 0;
		var TiPermissions = require('ti.permissions');
		permissions.forEach(function(perm,i) {
			if (TiPermissions.hasPermission(perm)) 
				grantedpermissions++;
			
			if (grantedpermissions == permissions.length)
				_callback(true);
		});
		if (grantedpermissions < permissions.length) {
			TiPermissions.requestPermissions(permissions, function(_e) {
				console.log(_e);
				_callback(_e.success);
			});
		}
	};
