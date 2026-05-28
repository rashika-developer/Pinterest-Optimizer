package com.pinterest.optimizer.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0005H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/pinterest/optimizer/di/DatabaseModule;", "", "<init>", "()V", "providePinterestOptimizerDatabase", "Lcom/pinterest/optimizer/data/database/PinterestOptimizerDatabase;", "context", "Landroid/content/Context;", "provideNicheProfileDao", "Lcom/pinterest/optimizer/data/database/NicheProfileDao;", "database", "providePinterestPostDao", "Lcom/pinterest/optimizer/data/database/PinterestPostDao;", "provideAnalyticsDao", "Lcom/pinterest/optimizer/data/database/AnalyticsDao;", "provideTrendDao", "Lcom/pinterest/optimizer/data/database/TrendDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.pinterest.optimizer.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.database.PinterestOptimizerDatabase providePinterestOptimizerDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.database.NicheProfileDao provideNicheProfileDao(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.PinterestOptimizerDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.database.PinterestPostDao providePinterestPostDao(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.PinterestOptimizerDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.database.AnalyticsDao provideAnalyticsDao(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.PinterestOptimizerDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.pinterest.optimizer.data.database.TrendDao provideTrendDao(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.PinterestOptimizerDatabase database) {
        return null;
    }
}