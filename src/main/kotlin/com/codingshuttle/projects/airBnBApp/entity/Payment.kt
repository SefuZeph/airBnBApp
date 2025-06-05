package com.codingshuttle.projects.airBnBApp.entity

import com.codingshuttle.projects.airBnBApp.enums.PaymentStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Payment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,

    @Column(unique = true) val transactionId: String,

    @Enumerated(EnumType.STRING) @Column(nullable = false) val paymentStatus: PaymentStatus,

    @Column(nullable = false, precision = 10, scale = 2) val amount: BigDecimal,


    )
