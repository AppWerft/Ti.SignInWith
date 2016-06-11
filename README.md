Ti.SignInWith
=============

This is a generic module for signin and retreiving profile informations.
Oauth is included. You need appId and appSecret. Both must be added to tiapp.xml as String property

![](https://content.linkedin.com/content/dam/developer/global/en_US/site/img/signin-button.png) 
![](https://api.slack.com/img/sign_in_with_slack.png)


The actual module will be visible next days. ;-)

General usage
-------------

It is a very simple API:

~~~

var SignIn = require('de.appwerft.signinwith');

// we have two methods:
// first getting profile, if not signed in a login screen is generated:
SignIn.getProfile(PROVIDER, function(_e) {
    alert(_e.data);
});

// second, a simple helper function for other purpose:
var bearer = SignIn.getAccessToken(PROVIDER);
~~~

Currently the module supports slack, meetup, linkedin, facebook, twitter, google+, xing
