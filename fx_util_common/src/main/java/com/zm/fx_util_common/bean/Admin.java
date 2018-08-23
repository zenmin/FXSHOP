package com.zm.fx_util_common.bean;

import java.io.Serializable;

public class Admin implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String role;

    private String updated;

    private String created;

    public Admin(Long id, String username, String password, String role, String updated, String created) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.updated = updated;
        this.created = created;
    }

    public Admin() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}