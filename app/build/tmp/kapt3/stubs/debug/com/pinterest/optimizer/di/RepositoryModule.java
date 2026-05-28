package com.pinterest.optimizer.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/pinterest/optimizer/di/RepositoryModule;", "", "<init>", "()V", "provideNicheProfileRepository", "Lcom/pinterest/optimizer/data/repository/NicheProfileRepository;", "nicheProfileDao", "Lcom/pinterest/optimizer/data/database/NicheProfileDao;", "providePinterestPostRepository", "Lcom/pinterest/optimizer/data/repository/PinterestPostRepository;", "postDao", "Lcom/pinterest/optimizer/data/database/PinterestPostDao;", "api", "Lcom/pinterest/optimizer/data/api/PinterestOptimizerApi;", "provideContentGenerationRepository", "Lcom/pinterest/optimizer/data/repository/ContentGenerationRepository;", "provideTrendRepository", "Lcom/pinterest/optimizer/data/repository/TrendRepository;", "trendDao", "Lcom/pinterest/optimizer/data/database/TrendDao;", "provideAnalyticsRepository", "Lcom/pinterest/optimizer/data/repository/AnalyticsRepository;", "analyticsDao", "Lcom/pinterest/optimizer/data/database/AnalyticsDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RepositoryModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.pinterest.optimizer.di.RepositoryModule INSTANCE = null;
    
    private RepositoryModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.repository.NicheProfileRepository provideNicheProfileRepository(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.NicheProfileDao nicheProfileDao) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.repository.PinterestPostRepository providePinterestPostRepository(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.PinterestPostDao postDao, @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.PinterestOptimizerApi api) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.repository.ContentGenerationRepository provideContentGenerationRepository(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.PinterestOptimizerApi api) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.repository.TrendRepository provideTrendRepository(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.TrendDao trendDao, @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.PinterestOptimizerApi api) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.repository.AnalyticsRepository provideAnalyticsRepository(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.AnalyticsDao analyticsDao) {
        return null;
    }
}