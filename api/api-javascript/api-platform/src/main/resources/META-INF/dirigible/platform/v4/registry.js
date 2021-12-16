/*
 * Copyright (c) 2010-2020 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   SAP - initial API and implementation
 */

const bytes = require("io/v4/bytes");

exports.getContent = function(path) {
	const nativeContent = org.eclipse.dirigible.api.v3.platform.RegistryFacade.getContent(path);
	return bytes.toJavaScriptBytes(nativeContent);
};

exports.getContentNative = function(path) {
	return org.eclipse.dirigible.api.v3.platform.RegistryFacade.getContent(path);
};

exports.getText = function(path) {
	return org.eclipse.dirigible.api.v3.platform.RegistryFacade.getText(path);
};

exports.find = function(path, pattern) {
	return JSON.parse(org.eclipse.dirigible.api.v3.platform.RegistryFacade.find(path, pattern));
};
