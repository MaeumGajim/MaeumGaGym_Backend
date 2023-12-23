package com.info.maeumgagym.domain.base

import javax.persistence.*

@MappedSuperclass
abstract class BaseLongIdEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long?
)
