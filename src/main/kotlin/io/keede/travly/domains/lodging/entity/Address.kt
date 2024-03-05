package io.keede.travly.domains.lodging.entity

import jakarta.persistence.Embeddable

/**
 * @author keede
 * Created on 2024/03/05
 */
@Embeddable
class Address(
    val zipCode: String,
    val prefix: String,
    val suffix: String,
)