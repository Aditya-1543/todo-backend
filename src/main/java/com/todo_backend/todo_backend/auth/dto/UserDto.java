package com.todo_backend.todo_backend.auth.dto;

import com.todo_backend.todo_backend.auth.entities.Provider;
import com.todo_backend.todo_backend.auth.entities.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String imageUrl;
    private Provider provider = Provider.LOCAL;
    private Set<RoleDto> roles = new HashSet<>();
    private boolean active;

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
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", provider=" + provider +
                ", roles=" + roles.toString() +
                ", active=" + active +
                '}';
    }
}
