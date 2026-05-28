package com.pinterest.optimizer.data.database;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/pinterest/optimizer/data/database/PinterestOptimizerDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "nicheProfileDao", "Lcom/pinterest/optimizer/data/database/NicheProfileDao;", "pinterestPostDao", "Lcom/pinterest/optimizer/data/database/PinterestPostDao;", "analyticsDao", "Lcom/pinterest/optimizer/data/database/AnalyticsDao;", "trendDao", "Lcom/pinterest/optimizer/data/database/TrendDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.pinterest.optimizer.data.models.NicheProfile.class, com.pinterest.optimizer.data.models.PinterestPost.class, com.pinterest.optimizer.data.models.PostAnalytics.class, com.pinterest.optimizer.data.models.Trend.class}, version = 1, exportSchema = false)
public abstract class PinterestOptimizerDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.pinterest.optimizer.data.database.PinterestOptimizerDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.pinterest.optimizer.data.database.PinterestOptimizerDatabase.Companion Companion = null;
    
    public PinterestOptimizerDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pinterest.optimizer.data.database.NicheProfileDao nicheProfileDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pinterest.optimizer.data.database.PinterestPostDao pinterestPostDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pinterest.optimizer.data.database.AnalyticsDao analyticsDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pinterest.optimizer.data.database.TrendDao trendDao();
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/pinterest/optimizer/data/database/PinterestOptimizerDatabase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/pinterest/optimizer/data/database/PinterestOptimizerDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.pinterest.optimizer.data.database.PinterestOptimizerDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}