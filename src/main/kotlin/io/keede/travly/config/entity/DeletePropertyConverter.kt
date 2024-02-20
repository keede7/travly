package io.keede.travly.config.entity

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter


/**
 * BaseEntity의 삭제상태 값 변환자
 * @author keeede
 * Created on 2024/02/20
 */
@Converter
class DeletePropertyConverter : AttributeConverter<Boolean, String> {

    override fun convertToDatabaseColumn(attribute: Boolean?): String = if (attribute!!) "Y" else "N"

    override fun convertToEntityAttribute(dbData: String?): Boolean = dbData!! == "Y"

}