package com.zeraki.languagelearning.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "first_name", nullable = true, length = 255)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    private String lastName;
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;
    @Basic
    @JsonIgnore
    @Column(name = "password", nullable = true, length = 255)
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(dateCreated, user.dateCreated) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, dateCreated, password);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.email;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;

    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;

    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;

    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;

    }
}
