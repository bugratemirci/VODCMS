package com.projects.vodcms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_username")
    private String username;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_is_admin")
    private Boolean isAdmin;

    @Column(name = "user_password")
    private String password;

}
