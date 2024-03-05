package io.keede.travly.domains.lodging.entity

import io.keede.travly.config.entity.BaseEntity
import jakarta.persistence.*
import java.time.ZonedDateTime

/**
 * @author keede
 * Created on 2024/03/05
 */
@Entity
@Table(
    name = "lodging_t"
)
@AttributeOverride(
    name = "id",
    column = Column(name = "lodging_id")
)
class LodgingEntity(
    val lodgingName : String,
    val maxUserCount: Int,
    @AttributeOverrides(
        value = [
            AttributeOverride(
                name = "zipCode", column = Column(name = "zip_code")
            ),
            AttributeOverride(
                name = "prefix", column = Column(name = "road_address")
            ),
            AttributeOverride(
                name = "suffix", column = Column(name = "detail_address")
            ),
        ]
    )
    val address: Address,
    val start: ZonedDateTime,
    val end: ZonedDateTime,
) : BaseEntity()