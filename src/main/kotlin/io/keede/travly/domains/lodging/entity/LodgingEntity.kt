package io.keede.travly.domains.lodging.entity

import io.keede.travly.config.entity.BaseEntity
import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(
    name = "lodging_t"
)
@AttributeOverride(
    name = "id",
    column = Column(name = "lodging_id")
)
class LodgingEntity() : BaseEntity() {

    var lodgingName : String = ""
    var maxUserCount: Int = 0
    var address: String = "" // 객체타입으로 변경
    var start: LocalDateTime = LocalDateTime.now()
    var end: LocalDateTime = LocalDateTime.now()

    constructor(
        lodgingName: String,
        maxUserCount: Int,
        address: String,
        start: LocalDateTime,
        end: LocalDateTime,
    ) : this() {
        this.lodgingName = lodgingName
        this.maxUserCount = maxUserCount
        this.address = address
        this.start = start
        this.end = end
    }

}