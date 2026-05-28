package com.pinterest.optimizer.di

import android.content.Context
import androidx.work.WorkManager
import com.pinterest.optimizer.data.api.PinterestApi
import com.pinterest.optimizer.data.api.PinterestOptimizerApi
import com.pinterest.optimizer.data.database.*
import com.pinterest.optimizer.data.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providePinterestOptimizerDatabase(@ApplicationContext context: Context): PinterestOptimizerDatabase {
        return PinterestOptimizerDatabase.getDatabase(context)
    }
    
    @Provides @Singleton fun providePinterestAccountDao(db: PinterestOptimizerDatabase): PinterestAccountDao = db.pinterestAccountDao()
    @Provides @Singleton fun provideNicheProfileDao(db: PinterestOptimizerDatabase): NicheProfileDao = db.nicheProfileDao()
    @Provides @Singleton fun providePinterestPostDao(db: PinterestOptimizerDatabase): PinterestPostDao = db.pinterestPostDao()
    @Provides @Singleton fun provideAnalyticsDao(db: PinterestOptimizerDatabase): AnalyticsDao = db.analyticsDao()
    @Provides @Singleton fun provideTrendDao(db: PinterestOptimizerDatabase): TrendDao = db.trendDao()
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }
    
    @Provides
    @Singleton
    fun providePinterestOptimizerApi(okHttpClient: OkHttpClient): PinterestOptimizerApi {
        return Retrofit.Builder()
            .baseUrl("https://api.pinterestoptimizer.com/") 
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PinterestOptimizerApi::class.java)
    }

    @Provides
    @Singleton
    fun providePinterestApi(okHttpClient: OkHttpClient): PinterestApi {
        return Retrofit.Builder()
            .baseUrl("https://api.pinterest.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PinterestApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides @Singleton fun provideAuthRepository(dao: PinterestAccountDao) = AuthRepository(dao)
    @Provides @Singleton fun provideNicheProfileRepository(dao: NicheProfileDao) = NicheProfileRepository(dao)
    @Provides @Singleton fun providePinterestPostRepository(
        dao: PinterestPostDao, 
        optimizerApi: PinterestOptimizerApi,
        pinterestApi: PinterestApi
    ) = PinterestPostRepository(dao, optimizerApi, pinterestApi)
    @Provides @Singleton fun provideContentGenerationRepository(api: PinterestOptimizerApi) = ContentGenerationRepository(api)
    @Provides @Singleton fun provideTrendRepository(dao: TrendDao, api: PinterestOptimizerApi) = TrendRepository(dao, api)
    @Provides @Singleton fun provideAnalyticsRepository(dao: AnalyticsDao) = AnalyticsRepository(dao)
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWorkManager(@ApplicationContext context: Context): WorkManager {
        return WorkManager.getInstance(context)
    }
}
