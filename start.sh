#!/bin/bash

APPID=de.appwerft.linkedin
VERSION=1.0.0

cd android;ant ;  unzip -uo  dist/$APPID-android-$VERSION.zip  -d  ~/Library/Application\ Support/Titanium/;cd ..
cd iphone/; python build.py;  unzip -uo  $APPID-iphone-$VERSION.zip  -d  ~/Library/Application\ Support/Titanium/;cd ..
cp android/dist/$APPID-android-$VERSION.zip .
cp iphone/$APPID-iphone-$VERSION.zip .
