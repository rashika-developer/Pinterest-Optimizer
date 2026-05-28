package com.pinterest.optimizer.data.api

import com.pinterest.optimizer.data.models.*
import retrofit2.http.*

interface PinterestOptimizerApi {
    
    // Caption generation
    @POST("/api/generate-captions")
    suspend fun generateCaptions(
        @Body request: CaptionRequest
    ): CaptionResponse
    
    // Hashtag generation
    @POST("/api/generate-hashtags")
    suspend fun generateHashtags(
        @Body request: HashtagRequest
    ): HashtagResponse
    
    // Product link finder
    @POST("/api/find-products")
    suspend fun findProducts(
        @Body request: ProductRequest
    ): ProductLinksResponse
    
    // Board suggestion
    @POST("/api/suggest-board")
    suspend fun suggestBoard(
        @Body request: BoardRequest
    ): BoardResponse
    
    // Trend detection
    @GET("/api/trends/{niche}")
    suspend fun getTrends(
        @Path("niche") niche: String,
        @Query("limit") limit: Int = 5
    ): TrendsResponse
    
    // Best posting time
    @POST("/api/best-posting-time")
    suspend fun getBestPostingTime(
        @Body request: PostingTimeRequest
    ): PostingTimeResponse
    
    // Image analysis
    @POST("/api/analyze-image")
    suspend fun analyzeImage(
        @Body request: ImageAnalysisRequest
    ): ImageAnalysisResponse
}

// Request Models (Response models are defined in data/models/models.kt)
data class CaptionRequest(
    val description: String,
    val niche: String,
    val tone: String = "engaging"
)

data class HashtagRequest(
    val content: String,
    val niche: String,
    val count: Int = 15
)

data class ProductRequest(
    val description: String,
    val imageUrl: String?,
    val niche: String
)

data class BoardRequest(
    val content: String,
    val niche: String,
    val existingBoards: List<String> = emptyList()
)

data class PostingTimeRequest(
    val niche: String,
    val dayOfWeek: Int
)

data class ImageAnalysisRequest(
    val imageUrl: String,
    val niche: String
)
