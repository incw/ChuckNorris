package dev.smolyakoff.chucknorris.features.fact.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FactResponseDTO(
    @SerialName("icon_url")
    val iconURL: String,
    val id: String,
    val url: String,
    val value: String
)
