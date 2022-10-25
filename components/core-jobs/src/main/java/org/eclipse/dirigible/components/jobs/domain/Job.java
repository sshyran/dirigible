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
package org.eclipse.dirigible.components.jobs.domain;

import org.eclipse.dirigible.components.base.artefact.Artefact;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * The Class Job.
 */
@Entity
@Table(name = "DIRIGIBLE_JOBS")
public class Job extends Artefact {

    /** The Constant ARTEFACT_TYPE. */
    public static final String ARTEFACT_TYPE = "job";

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_ID", nullable = false)
    private Long id;

    /**
     * The group.
     */
    @Column(name = "JOB_GROUP", columnDefinition = "VARCHAR", nullable = false, length = 255)
    private String group;

    /**
     * The clazz.
     */
    @Column(name = "JOB_CLASS", columnDefinition = "VARCHAR", nullable = false, length = 255)
    private String clazz = "";

    /**
     * The expression.
     */
    @Column(name = "JOB_EXPRESSION", columnDefinition = "VARCHAR", nullable = false, length = 255)
    private String expression;

    /**
     * The handler.
     */
    @Column(name = "JOB_HANDLER", columnDefinition = "VARCHAR", nullable = true, length = 255)
    private String handler;

    /**
     * The engine.
     */
    @Column(name = "JOB_ENGINE", columnDefinition = "VARCHAR", nullable = true, length = 100)
    private String engine;

    /**
     * The singleton.
     */
    @Column(name = "JOB_SINGLETON", columnDefinition = "BOOLEAN", nullable = false)
    private boolean singleton = false;

    /**
     * The enabled.
     */
    @Column(name = "JOB_ENABLED", columnDefinition = "BOOLEAN", nullable = false)
    private boolean enabled = true;

    /**
     * The parameters.
     */
//    @Transient
//    private List<JobParameter> parameters = new ArrayList<>();

    /** The status. */
    @Column(name = "JOB_STATUS", columnDefinition = "SMALLINT", nullable = true)
    private short status = 99;

    /**
     * The message.
     */
    @Column(name = "JOB_MESSAGE", columnDefinition = "VARCHAR", nullable = true, length = 2000)
    private String message;

    /**
     * The executed at.
     */
    @Column(name = "JOB_EXECUTED_AT", columnDefinition = "TIMESTAMP", nullable = true)
    private Timestamp executedAt;

    /**
     * Instantiates a new job.
     *
     * @param location the location
     * @param name the name
     * @param type the type
     * @param description the description
     * @param dependencies the dependencies
     * @param id the id
     * @param group the group
     * @param clazz the clazz
     * @param expression the expression
     * @param handler the handler
     * @param engine the engine
     * @param singleton the singleton
     * @param enabled the enabled
     * @param status the status
     * @param message the message
     * @param executedAt the executed at
     */
    public Job(String location, String name, String type, String description, String dependencies, Long id, String group, String clazz, String expression, String handler, String engine, boolean singleton, boolean enabled, short status, String message, Timestamp executedAt) {
        super(location, name, type, description, dependencies);
        this.id = id;
        this.group = group;
        this.clazz = clazz;
        this.expression = expression;
        this.handler = handler;
        this.engine = engine;
        this.singleton = singleton;
        this.enabled = enabled;
        this.status = status;
        this.message = message;
        this.executedAt = executedAt;
    }

    /**
     * Instantiates a new job.
     */
    public Job() {
        super();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the group.
     *
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the group.
     *
     * @param group the new group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Gets the clazz.
     *
     * @return the clazz
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the clazz.
     *
     * @param clazz the new clazz
     */
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    /**
     * Gets the expression.
     *
     * @return the expression
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Sets the expression.
     *
     * @param expression the new expression
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * Gets the handler.
     *
     * @return the handler
     */
    public String getHandler() {
        return handler;
    }

    /**
     * Sets the handler.
     *
     * @param handler the new handler
     */
    public void setHandler(String handler) {
        this.handler = handler;
    }

    /**
     * Gets the engine.
     *
     * @return the engine
     */
    public String getEngine() {
        return engine;
    }

    /**
     * Sets the engine.
     *
     * @param engine the new engine
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }

    /**
     * Checks if is singleton.
     *
     * @return true, if is singleton
     */
    public boolean isSingleton() {
        return singleton;
    }

    /**
     * Sets the singleton.
     *
     * @param singleton the new singleton
     */
    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    /**
     * Checks if is enabled.
     *
     * @return true, if is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the enabled.
     *
     * @param enabled the new enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public short getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(short status) {
        this.status = status;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the executed at.
     *
     * @return the executed at
     */
    public Timestamp getExecutedAt() {
        return executedAt;
    }

    /**
     * Sets the executed at.
     *
     * @param executedAt the new executed at
     */
    public void setExecutedAt(Timestamp executedAt) {
        this.executedAt = executedAt;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", group='" + group + '\'' + ", clazz='" + clazz + '\'' + ", expression='"
                + expression + '\'' + ", handler='" + handler + '\'' + ", engine='" + engine + '\'' + ", singleton="
                + singleton + ", enabled=" + enabled + ", status=" + status + ", message='" + message + '\'' + ", executedAt="
                + executedAt + ", location='" + location + '\'' + ", name='" + name + '\'' + ", type='" + type + '\'' + ", description='"
                + description + '\'' + ", key='" + key + '\'' + ", dependencies='" + dependencies + '\'' + ", createdBy="
                + createdBy + ", createdAt=" + createdAt + ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt + '}';
    }
}
