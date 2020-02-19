package com.example.facebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;
    private String email;
    private String password;

    @OneToMany
    @JoinColumn(name="user_id", referencedColumnName = "id")
    Set<UserFriend> friends;

    @OneToMany
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @JsonIgnore
    Set<Post> posts;

    @OneToMany
    @JoinColumn(name="user_id", referencedColumnName = "id")
    Set<Image> photos;

    @OneToMany
    @JoinColumn(name="user_id", referencedColumnName = "id")
    Set<FacebookLike> likes;

    @OneToMany
    @JoinColumn(name="user_id", referencedColumnName = "id")
    Set<Comment> comments;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User() {
    }

    public User(UUID id, String name, String email, String password, Set<UserFriend> friends, Set<Post> posts, Set<Image> photos, Set<FacebookLike> likes, Set<Comment> comments, List<String> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.friends = friends;
        this.posts = posts;
        this.photos = photos;
        this.likes = likes;
        this.comments = comments;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<UserFriend> getFriends() {
        return friends;
    }

    public void setFriends(Set<UserFriend> friends) {
        this.friends = friends;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Image> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Image> photos) {
        this.photos = photos;
    }

    public Set<FacebookLike> getLikes() {
        return likes;
    }

    public void setLikes(Set<FacebookLike> likes) {
        this.likes = likes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
