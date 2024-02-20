package io.keede.travly.config.entity

import jakarta.persistence.*
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * @author keede
 * Created on 2024/02/20
 */
@MappedSuperclass
internal open class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0

    @Column(name = "created_at")
    lateinit var createdAt: ZonedDateTime

    @Column(name = "modified_at")
    lateinit var modifiedAt: ZonedDateTime

    @Convert(converter = DeletePropertyConverter::class)
    @Column(name = "is_delete")
    val isDelete: Boolean = false

    @PrePersist
    fun prePersist(): Unit {
        this.createdAt = ZonedDateTime.now(
            ZoneId.of("Asia/Seoul")
        )
    }

    @PreUpdate
    fun preUpdate(): Unit {
        this.modifiedAt = ZonedDateTime.now(
            ZoneId.of("Asia/Seoul")
        )
    }

}