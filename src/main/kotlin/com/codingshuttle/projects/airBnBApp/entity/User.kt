package com.codingshuttle.projects.airBnBApp.entity

import com.codingshuttle.projects.airBnBApp.enums.Role
import jakarta.persistence.*

@Entity
@Table(name = "app_user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,

    @Column(unique = true, nullable = false) val email: String,

    @Column(nullable = false) val password: String,

    val name: String,

    @ElementCollection(fetch = FetchType.EAGER) @Enumerated(EnumType.STRING) val roles: Set<Role>,

    )
