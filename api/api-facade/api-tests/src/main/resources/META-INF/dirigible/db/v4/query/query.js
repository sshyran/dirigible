/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2021 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 * SPDX-License-Identifier: EPL-2.0
 */
var query = require('db/v4/query');
var update = require('db/v4/update');
var assertTrue = require('utils/assert').assertTrue;

update.execute("CREATE TABLE T (A INT, B VARCHAR(10))");
update.execute("INSERT INTO T VALUES (1, 'ABC')");
update.execute("INSERT INTO T VALUES (2, 'DEF')");

var sql = "SELECT * FROM T WHERE A = ?";
var resultset = query.execute(sql, [1]);

console.log(JSON.stringify(resultset));

update.execute("DROP TABLE T");

assertTrue((resultset !== null) && (resultset !== undefined));