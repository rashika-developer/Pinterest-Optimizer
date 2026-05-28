package com.pinterest.optimizer.data.database;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\'J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0010\u00c0\u0006\u0003"}, d2 = {"Lcom/pinterest/optimizer/data/database/TrendDao;", "", "insertTrend", "", "trend", "Lcom/pinterest/optimizer/data/models/Trend;", "(Lcom/pinterest/optimizer/data/models/Trend;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopTrends", "Lkotlinx/coroutines/flow/Flow;", "", "limit", "", "getTrendsByCategory", "category", "", "deleteTrend", "app_debug"})
@androidx.room.Dao()
public abstract interface TrendDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTrend(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.Trend trend, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM trends ORDER BY trendScore DESC LIMIT :limit")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pinterest.optimizer.data.models.Trend>> getTopTrends(int limit);
    
    @androidx.room.Query(value = "SELECT * FROM trends WHERE category = :category ORDER BY trendScore DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pinterest.optimizer.data.models.Trend>> getTrendsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTrend(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.Trend trend, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}