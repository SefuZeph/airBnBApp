package com.codingshuttle.projects.airBnBApp.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "hotel")
data class Hotel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,

    @Column(nullable = false) val name: String,

    val city: String,

    @Column(columnDefinition = "TEXT[]") val photos: List<String>,

    @Column(columnDefinition = "TEXT[]") val amenities: List<String>,

    @CreationTimestamp val createdAt: LocalDateTime,

    @UpdateTimestamp @Column(updatable = false) val updatedAt: LocalDateTime,

    @Embedded val hotelContactInfo: HotelContactInfo,

    @Column(nullable = false) val active: Boolean,

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY) val rooms: List<Room>,
)