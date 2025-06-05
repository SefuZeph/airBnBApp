package com.codingshuttle.projects.airBnBApp.entity

import com.codingshuttle.projects.airBnBApp.enums.BookingStatus
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Booking(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,

    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "hotel_id", nullable = false) val hotel: Hotel,

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "room_id", nullable = false) val room: Room,

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) val user: User,

    @Column(nullable = false) val roomsCount: Int,

    @Column(nullable = false) val checkInDate: LocalDate,

    @Column(nullable = false) val checkInOut: LocalDate,

    @CreationTimestamp val createdAt: LocalDateTime,

    @UpdateTimestamp @Column(updatable = false) val updatedAt: LocalDateTime,

    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "payment_id") val payment: Payment,

    @Enumerated(EnumType.STRING) @Column(nullable = false) val bookingStatus: BookingStatus,

    @ManyToMany @JoinTable(
        name = "booking_guest",
        joinColumns = [JoinColumn(name = "booking_id")],
        inverseJoinColumns = [JoinColumn(name = "guest_id")]
    ) val guests: Set<Guest>,

    )
