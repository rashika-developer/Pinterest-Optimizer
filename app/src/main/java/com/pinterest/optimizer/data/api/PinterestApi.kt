package com.pinterest.optimizer.data.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.*

interface PinterestApi {

    @GET("v5/user_account")
    suspend fun getUserAccount(
        @Header("Authorization") token: String
    ): PinterestUserResponse

    @GET("v5/boards")
    suspend fun getBoards(
        @Header("Authorization") token: String,
        @Query("page_size") pageSize: Int = 100
    ): PinterestBoardsResponse

    @POST("v5/pins")
    suspend fun createPin(
        @Header("Authorization") token: String,
        @Body request: CreatePinRequest
    ): PinterestPinResponse

    @FormUrlEncoded
    @POST("v5/oauth/token")
    suspend fun exchangeToken(
        @Field("grant_type") grantType: String = "authorization_code",
        @Field("code") code: String,
        @Field("redirect_uri") redirectUri: String,
        @Header("Authorization") basicAuth: String // Base64(client_id:client_secret)
    ): PinterestTokenResponse
}

data class PinterestTokenResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String?,
    @SerializedName("expires_in") val expiresIn: Int,
    @SerializedName("refresh_token_expires_in") val refreshTokenExpiresIn: Int,
    val scope: String
)

data class PinterestBoardsResponse(
    val items: List<PinterestBoard>
)

data class PinterestBoard(
    val id: String,
    val name: String
)

data class CreatePinRequest(
    val title: String?,
    val description: String?,
    @SerializedName("board_id") val boardId: String,
    @SerializedName("media_source") val mediaSource: PinMediaSource
)

data class PinMediaSource(
    @SerializedName("source_type") val sourceType: String = "image_url",
    val url: String
)

data class PinterestPinResponse(
    val id: String,
    val link: String?
)

data class PinterestUserResponse(
    val username: String?,
    @SerializedName("profile_image") val profileImage: String?
)
