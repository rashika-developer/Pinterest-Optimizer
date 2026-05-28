package com.pinterest.optimizer.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.ListenableWorker
import com.pinterest.optimizer.data.repository.NicheProfileRepository
import com.pinterest.optimizer.data.repository.TrendRepository
import com.pinterest.optimizer.data.repository.PinterestPostRepository
import com.pinterest.optimizer.data.repository.AuthRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.firstOrNull

@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val trendRepository: TrendRepository,
    private val nicheRepository: NicheProfileRepository,
    private val postRepository: PinterestPostRepository,
    private val authRepository: AuthRepository
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): ListenableWorker.Result {
        return try {
            val account = authRepository.currentAccount.firstOrNull() ?: return ListenableWorker.Result.failure()
            
            // 1. Sync Trends for the niche
            val profile = nicheRepository.getCurrentProfile().firstOrNull()
            if (profile != null) {
                trendRepository.fetchAndStoreTrends(profile.niche)
            }

            // 2. Upload scheduled posts
            val scheduledPosts = postRepository.getScheduledPosts().firstOrNull() ?: emptyList()
            val currentTime = System.currentTimeMillis()
            
            scheduledPosts.forEach { post ->
                if (post.scheduledTime <= currentTime) {
                    // Actual production upload to Pinterest API
                    val success = postRepository.uploadPinToPinterest(
                        post = post,
                        accessToken = account.accessToken,
                        boardId = post.boardName // In actual app, this is the board ID
                    )
                    if (success) {
                        postRepository.updatePost(post.copy(isPosted = true))
                    }
                }
            }

            ListenableWorker.Result.success()
        } catch (e: Exception) {
            if (runAttemptCount < 3) {
                ListenableWorker.Result.retry()
            } else {
                ListenableWorker.Result.failure()
            }
        }
    }
}
