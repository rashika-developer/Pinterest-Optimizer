package com.pinterest.optimizer.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/pinterest/optimizer/data/repository/PinterestPostRepository;", "", "postDao", "Lcom/pinterest/optimizer/data/database/PinterestPostDao;", "api", "Lcom/pinterest/optimizer/data/api/PinterestOptimizerApi;", "<init>", "(Lcom/pinterest/optimizer/data/database/PinterestPostDao;Lcom/pinterest/optimizer/data/api/PinterestOptimizerApi;)V", "getAllPosts", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pinterest/optimizer/data/models/PinterestPost;", "getScheduledPosts", "createPost", "", "post", "(Lcom/pinterest/optimizer/data/models/PinterestPost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePost", "", "deletePost", "postId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPostById", "app_debug"})
public final class PinterestPostRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.database.PinterestPostDao postDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.api.PinterestOptimizerApi api = null;
    
    @javax.inject.Inject()
    public PinterestPostRepository(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.PinterestPostDao postDao, @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.PinterestOptimizerApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pinterest.optimizer.data.models.PinterestPost>> getAllPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pinterest.optimizer.data.models.PinterestPost>> getScheduledPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createPost(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.PinterestPost post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePost(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.PinterestPost post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deletePost(int postId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.pinterest.optimizer.data.models.PinterestPost> getPostById(int postId) {
        return null;
    }
}