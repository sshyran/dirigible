/*
 * Copyright (c) 2010-2021 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2010-2021 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.dirigible.api.redis;

import org.eclipse.dirigible.commons.api.scripting.IScriptingFacade;

import org.eclipse.dirigible.commons.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

public class RedisFacade implements IScriptingFacade {
	private static final String DIRIGIBLE_REDIS_CLIENT_URI = "DIRIGIBLE_REDIS_CLIENT_URI";
	private static final String CLIENT_URI = "localhost";
	private static final Logger logger = LoggerFactory.getLogger(RedisFacade.class);
	
	public static Jedis getClient() {
		
		String clientUri = Configuration.get(DIRIGIBLE_REDIS_CLIENT_URI, CLIENT_URI);
		
		Jedis redisClient = new Jedis(clientUri);
		
		return redisClient;
	}
}
