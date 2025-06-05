package com.codingshuttle.projects.airBnBApp.entity

import com.codingshuttle.projects.airBnBApp.enums.Gender
import jakarta.persistence.*

@Entity
data class Guest(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,

    @ManyToOne @JoinColumn(name = "user_id") val user: User,

    @Column(nullable = false) val name: String,

    @Enumerated(EnumType.STRING) val gender: Gender,

    val age: Int,
)
