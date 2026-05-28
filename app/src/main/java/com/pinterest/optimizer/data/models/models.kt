package com.pinterest.optimizer.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

// Pinterest Account / Auth
@Entity(tableName = "pinterest_accounts")
data class PinterestAccount(
    @PrimaryKey val userId: String,
    val username: String,
    val accessToken: String,
    val refreshToken: String?,
    val tokenExpiresAt: Long,
    val profileImage: String? = null
)

// Niche Profile
@Entity(tableName = "niche_profiles")
data class NicheProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val niche: String,
    val description: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

// Pinterest Post
@Entity(tableName = "pinterest_posts")
data class PinterestPost(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val imageUri: String,
    val description: String,
    val captionMinimal: String,
    val captionEngaging: String,
    val captionSales: String,
    val hashtags: String, // comma-separated
    val productLinks: String, // JSON array
    val boardName: String,
    val scheduledTime: Long,
    val isPosted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

// Analytics
@Entity(tableName = "analytics")
data class PostAnalytics(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val postId: Int,
    val views: Int = 0,
    val saves: Int = 0,
    val clicks: Int = 0,
    val impressions: Int = 0,
    val engagementRate: Float = 0f,
    val updatedAt: Long = System.currentTimeMillis()
)

// Product Link
data class ProductLink(
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("source")
    val source: String // "amazon", "etsy", "affiliate_network"
)

// Trend
@Entity(tableName = "trends")
data class Trend(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val category: String,
    val trendScore: Float,
    val discoveredAt: Long = System.currentTimeMillis()
)

// API Related Models
data class CaptionResponse(
    @SerializedName("minimal")
    val minimal: String,
    @SerializedName("engaging")
    val engaging: String,
    @SerializedName("sales")
    val sales: String
)

data class HashtagResponse(
    @SerializedName("hashtags")
    val hashtags: List<String>,
    @SerializedName("trending")
    val trending: List<String>
)

data class ProductLinksResponse(
    @SerializedName("products")
    val products: List<ProductLink>
)

data class BoardResponse(
    val boardName: String,
    val description: String,
    val confidence: Float
)

data class TrendsResponse(
    val trends: List<TrendData>
)

data class TrendData(
    val title: String,
    val description: String,
    val score: Float,
    val ideas: List<String>
)

data class PostingTimeResponse(
    val bestTime: String,
    val timezone: String,
    val hour: Int,
    val minute: Int
)

data class ImageAnalysisResponse(
    val objects: List<String>,
    val colors: List<String>,
    val style: String,
    val suggestedNiches: List<String>
)
