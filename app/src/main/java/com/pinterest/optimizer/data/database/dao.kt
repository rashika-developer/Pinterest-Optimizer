package com.pinterest.optimizer.data.database

import androidx.room.*
import com.pinterest.optimizer.data.models.*
import kotlinx.coroutines.flow.Flow

// Pinterest Account DAO
@Dao
interface PinterestAccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: PinterestAccount)
    
    @Query("SELECT * FROM pinterest_accounts LIMIT 1")
    fun getAccount(): Flow<PinterestAccount?>
    
    @Query("DELETE FROM pinterest_accounts")
    suspend fun deleteAccount()
}

// Niche Profile DAO
@Dao
interface NicheProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: NicheProfile)
    
    @Query("SELECT * FROM niche_profiles ORDER BY updatedAt DESC LIMIT 1")
    fun getCurrentProfile(): Flow<NicheProfile?>
    
    @Query("SELECT * FROM niche_profiles")
    fun getAllProfiles(): Flow<List<NicheProfile>>
    
    @Update
    suspend fun updateProfile(profile: NicheProfile)
    
    @Delete
    suspend fun deleteProfile(profile: NicheProfile)
}

// Pinterest Post DAO
@Dao
interface PinterestPostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PinterestPost): Long
    
    @Query("SELECT * FROM pinterest_posts ORDER BY createdAt DESC")
    fun getAllPosts(): Flow<List<PinterestPost>>
    
    @Query("SELECT * FROM pinterest_posts WHERE id = :postId")
    fun getPostById(postId: Int): Flow<PinterestPost?>
    
    @Query("SELECT * FROM pinterest_posts WHERE isPosted = 0 ORDER BY scheduledTime ASC")
    fun getScheduledPosts(): Flow<List<PinterestPost>>
    
    @Update
    suspend fun updatePost(post: PinterestPost)
    
    @Delete
    suspend fun deletePost(post: PinterestPost)
    
    @Query("DELETE FROM pinterest_posts WHERE id = :postId")
    suspend fun deletePostById(postId: Int)
}

// Analytics DAO
@Dao
interface AnalyticsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnalytics(analytics: PostAnalytics)
    
    @Query("SELECT * FROM analytics WHERE postId = :postId")
    fun getAnalyticsByPostId(postId: Int): Flow<PostAnalytics?>
    
    @Query("SELECT * FROM analytics ORDER BY updatedAt DESC LIMIT 10")
    fun getRecentAnalytics(): Flow<List<PostAnalytics>>
    
    @Update
    suspend fun updateAnalytics(analytics: PostAnalytics)
}

// Trend DAO
@Dao
interface TrendDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrend(trend: Trend)
    
    @Query("SELECT * FROM trends ORDER BY trendScore DESC LIMIT :limit")
    fun getTopTrends(limit: Int): Flow<List<Trend>>
    
    @Query("SELECT * FROM trends WHERE category = :category ORDER BY trendScore DESC")
    fun getTrendsByCategory(category: String): Flow<List<Trend>>
    
    @Delete
    suspend fun deleteTrend(trend: Trend)
}
