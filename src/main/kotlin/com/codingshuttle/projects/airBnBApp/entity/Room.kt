package com.codingshuttle.projects.airBnBApp.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "room")
data class Room(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,

    @ManyToOne @JoinColumn(name = "hotel_id", nullable = false) val hotel: Hotel,

    @Column(nullable = false) val type: String,

    @Column(nullable = false, precision = 10, scale = 2) val bestPrice: BigDecimal,

    @Column(columnDefinition = "TEXT[]") val photos: List<String>,

    @Column(columnDefinition = "TEXT[]") val amenities: List<String>,

    @Column(nullable = false) val totalCount: Int,

    @Column(nullable = false) val capacity: Int,

    @CreationTimestamp @Column(updatable = false) val createdAt: LocalDateTime,

    @UpdateTimestamp val updatedAt: LocalDateTime,
)
