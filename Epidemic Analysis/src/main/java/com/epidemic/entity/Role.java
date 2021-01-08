package com.epidemic.entity;

import lombok.Data;

@Data
public class Role {
    Integer id;
    String role_name;
    String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
