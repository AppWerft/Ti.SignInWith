/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
package de.appwerft.signinwith;

import org.appcelerator.kroll.common.KrollSourceCodeProvider;

public class CommonJsSourceProvider implements KrollSourceCodeProvider
{
	public String getSourceCode()
	{
		return getSourceCode("de.appwerft.signinwith");
	}

	public String getSourceCode(String module)
	{
		if (module.equals("de.appwerft.signinwith/de.appwerft.signinwith")) {
			module = "de.appwerft.signinwith";
		}

		AssetCryptImpl source = new AssetCryptImpl();
		return source.readAsset(module + ".js");
	}
}
