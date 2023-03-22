/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.dirigible.components.data.structures.service;

import java.util.List;
import java.util.Optional;

import org.eclipse.dirigible.components.base.artefact.ArtefactService;
import org.eclipse.dirigible.components.data.structures.domain.Table;
import org.eclipse.dirigible.components.data.structures.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Processing the Tables Service incoming requests.
 */
@Service
@Transactional
public class TableService implements ArtefactService<Table> {
	
	@Autowired 
	private TableRepository tableRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Table> getAll() {
		return tableRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Table> findAll(Pageable pageable) {
		return tableRepository.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Table findById(Long id) {
		Optional<Table> table = tableRepository.findById(id);
		if (table.isPresent()) {
			return table.get();
		} else {
			throw new IllegalArgumentException("Table with id does not exist: " + id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Table findByName(String name) {
		Table filter = new Table();
		filter.setName(name);
		Example<Table> example = Example.of(filter);
		Optional<Table> table = tableRepository.findOne(example);
		if (table.isPresent()) {
			return table.get();
		} else {
			throw new IllegalArgumentException("Table with name does not exist: " + name);
		}
	}
	
	/**
     * Find by key.
     *
     * @param key the key
     * @return the table
     */
    @Override
    @Transactional(readOnly = true)
    public Table findByKey(String key) {
    	Table filter = new Table();
        filter.setKey(key);
        Example<Table> example = Example.of(filter);
        Optional<Table> table = tableRepository.findOne(example);
        if (table.isPresent()) {
            return table.get();
        }
        return null;
    }
	
	@Override
	public Table save(Table table) {
		return tableRepository.saveAndFlush(table);
	}
	
	@Override
	public void delete(Table table) {
		tableRepository.delete(table);
	}

}