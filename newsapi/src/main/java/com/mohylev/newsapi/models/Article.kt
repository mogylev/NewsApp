package com.mohylev.newsapi.models

import com.mohylev.newsapi.utils.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 *
 * "source": {
 * "id": "techcrunch",
 * "name": "TechCrunch"
 * },
 * "author": "Jacquelyn Melinek",
 * "title": "OpenSea's partnership with Coachella is a sign that NFTs can be more than profile pictures | TechCrunch",
 * "description": "The NFT sector has not yet returned to the glory of its 2022 heydays but that hasn’t stopped the evolution of the tech. For instance, OpenSea has",
 * "url": "https://techcrunch.com/2024/03/05/openseas-partnership-with-coachella-is-a-sign-that-nfts-can-be-more-than-profile-pictures/",
 * "urlToImage": "https://techcrunch.com/wp-content/uploads/2024/03/Coachella_FeatureImage.png?w=1200",
 * "publishedAt": "2024-03-05T18:09:27Z",
 * "content": "The NFT sector has not yet returned to the glory of its 2022 heydays but that hasnt stopped the evolution of the tech.\r\nFor instance, OpenSea has partnered with the music and arts festival conglomera… [+4769 chars]"
 */

@Serializable
data class ArticleApiModel(
    @SerialName("source") val source: SourceApiModel,
    @SerialName("author") val author: String,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("url") val url: String,
    @SerialName("urlToImage") val imageUrl: String,
    @SerialName("publishedAt") @Serializable(with = InstantSerializer::class) val publishDate: Instant,
    @SerialName("content") val content: String,
)

@Serializable
data class SourceApiModel(
    @SerialName("id")  val id: String,
    @SerialName("name")  val name: String
)