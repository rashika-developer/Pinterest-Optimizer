package com.pinterest.optimizer.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0002\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/pinterest/optimizer/data/repository/TrendRepository;", "", "trendDao", "Lcom/pinterest/optimizer/data/database/TrendDao;", "api", "Lcom/pinterest/optimizer/data/api/PinterestOptimizerApi;", "<init>", "(Lcom/pinterest/optimizer/data/database/TrendDao;Lcom/pinterest/optimizer/data/api/PinterestOptimizerApi;)V", "getTopTrends", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pinterest/optimizer/data/models/Trend;", "limit", "", "fetchAndStoreTrends", "", "niche", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TrendRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.database.TrendDao trendDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.api.PinterestOptimizerApi api = null;
    
    @javax.inject.Inject()
    public TrendRepository(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.TrendDao trendDao, @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.PinterestOptimizerApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pinterest.optimizer.data.models.Trend>> getTopTrends(int limit) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchAndStoreTrends(@org.jetbrains.annotations.NotNull()
    java.lang.String niche, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}