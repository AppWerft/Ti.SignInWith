Ti.SignInWith
=============

This is a generic module for signin and retreiving profile informations.
Oauth is included. You need appId and appSecret. Both must be added to tiapp.xml as String property


![](https://raw.githubusercontent.com/AppWerft/Ti.SignInWith/master/documentation/Screenshot.png)

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

Currently the module supports linkedin, googleplus, facebook, slack, dropbox
In your tiapp.xml you need entries like:
~~~
<property name="linkedin_clientId" type="string">77981g**1xfs</property>
<property name="linkedin_clientSecret" type="string">wqApSZ**</property>
<property name="slack_clientId" type="string">3437706020:508**6</property>
<property name="slack_clientSecret" type="string">01f887a1****0c8128f966492f</property>
~~~
For slack you must replace '.' wuth ':' (workaround)

