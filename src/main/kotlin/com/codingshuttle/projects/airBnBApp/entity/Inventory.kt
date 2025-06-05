package com.codingshuttle.projects.airBnBApp.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(
    name = "inventory", uniqueConstraints = [UniqueConstraint(
        name = "unique_hotel_room_date", columnNames = ["hotel_id", "room_id", "date"]
    )]
)
data class Inventory(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,

    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hotel_id", nullable = false) val hotel: Hotel,

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "room_id", nullable = false) val room: Room,

    @Column(nullable = false) val date: LocalDate,

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0") val bookedCount: Int,

    @Column(nullable = false) val totalCount: Int,

    @Column(nullable = false, precision = 2, scale = 2) val surgeFactor: BigDecimal,

    @Column(nullable = false, precision = 10, scale = 2) val price: BigDecimal,

    @Column(nullable = false) val city: String,

    @Column(nullable = false) val closed: Boolean,

    @CreationTimestamp @Column(updatable = false) val createdAt: LocalDateTime,

    @UpdateTimestamp val updatedAt: LocalDateTime,
)
