package com.pinterest.optimizer.data.database;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013\u00c0\u0006\u0003"}, d2 = {"Lcom/pinterest/optimizer/data/database/PinterestPostDao;", "", "insertPost", "", "post", "Lcom/pinterest/optimizer/data/models/PinterestPost;", "(Lcom/pinterest/optimizer/data/models/PinterestPost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPosts", "Lkotlinx/coroutines/flow/Flow;", "", "getPostById", "postId", "", "getScheduledPosts", "updatePost", "", "deletePost", "deletePostById", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface PinterestPostDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertPost(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.PinterestPost post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM pinterest_posts ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pinterest.optimizer.data.models.PinterestPost>> getAllPosts();
    
    @androidx.room.Query(value = "SELECT * FROM pinterest_posts WHERE id = :postId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.pinterest.optimizer.data.models.PinterestPost> getPostById(int postId);
    
    @androidx.room.Query(value = "SELECT * FROM pinterest_posts WHERE isPosted = 0 ORDER BY scheduledTime ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pinterest.optimizer.data.models.PinterestPost>> getScheduledPosts();
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePost(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.PinterestPost post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deletePost(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.PinterestPost post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM pinterest_posts WHERE id = :postId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deletePostById(int postId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}