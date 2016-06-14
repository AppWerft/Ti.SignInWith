Ti.SignInWith
=============

This is a generic module for signin and retreiving profile informations.
Oauth is included. You need appId and appSecret. Both must be added to tiapp.xml as String property


General usage
-------------

It is a very simple API:

~~~

var SignIn = require('de.appwerft.signinwith');

// we have three methods:

SignIn.createSelectDialog({title:"Select what you want:"},function(_provider){
    console.log("Selected provider: " + _provider);
    // second getting profile, if not signed in a login screen is generated:
    SignIn.getProfile(_provider, function(_e) {
        alert(_e.data);
    });
    // third, a simple helper function for other purpose:
    var bearer = SignIn.getAccessToken(_provider);

});

~~~

Currently the module supports slack, meetup, linkedin, facebook, twitter, google+, xing
