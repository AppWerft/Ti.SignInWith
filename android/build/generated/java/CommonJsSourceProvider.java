/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
package de.appwerft.linkedin;

import org.appcelerator.kroll.common.KrollSourceCodeProvider;

public class CommonJsSourceProvider implements KrollSourceCodeProvider
{
	public String getSourceCode()
	{
		return getSourceCode("de.appwerft.linkedin");
	}

	public String getSourceCode(String module)
	{
		if (module.equals("de.appwerft.linkedin/de.appwerft.linkedin")) {
			module = "de.appwerft.linkedin";
		}

		AssetCryptImpl source = new AssetCryptImpl();
		return source.readAsset(module + ".js");
	}
}
