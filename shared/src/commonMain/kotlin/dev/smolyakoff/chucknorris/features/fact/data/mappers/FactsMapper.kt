package dev.smolyakoff.chucknorris.features.fact.data.mappers

import dev.smolyakoff.chucknorris.database.room.FactDBO
import dev.smolyakoff.chucknorris.features.fact.data.dto.FactResponseDTO
import dev.smolyakoff.chucknorris.features.fact.domain.model.FactModel

internal fun FactResponseDTO.toModel() =
    FactModel(
        id = id,
        fact = value,
        imageUrl = iconURL
    )


internal fun FactResponseDTO.toDBO() =
    FactDBO(
        id = id,
        imageURL = iconURL,
        fact = value
    )


internal fun FactDBO.toModel() =
    FactModel(
        id = id,
        fact = fact,
        imageUrl = imageURL
    )