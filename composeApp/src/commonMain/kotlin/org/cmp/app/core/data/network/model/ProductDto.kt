package org.cmp.app.core.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    @SerialName("artistDisplayName")
    val artistDisplayName: String? = null,
    @SerialName("creditLine")
    val creditLine: String? = null,
    @SerialName("department")
    val department: String? = null,
    @SerialName("dimensions")
    val dimensions: String? = null,
    @SerialName("medium")
    val medium: String? = null,
    @SerialName("objectDate")
    val objectDate: String? = null,
    @SerialName("objectID")
    val objectID: Int? = null,
    @SerialName("objectURL")
    val objectURL: String? = null,
    @SerialName("primaryImage")
    val primaryImage: String? = null,
    @SerialName("primaryImageSmall")
    val primaryImageSmall: String? = null,
    @SerialName("repository")
    val repository: String? = null,
    @SerialName("title")
    val title: String? = null
)