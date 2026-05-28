package com.pinterest.optimizer.data.api;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0004\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u00162\b\b\u0003\u0010\u0017\u001a\u00020\u0018H\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u0004\u001a\u00020\u001cH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010\u0004\u001a\u00020 H\u00a7@\u00a2\u0006\u0002\u0010!\u00a8\u0006\"\u00c0\u0006\u0003"}, d2 = {"Lcom/pinterest/optimizer/data/api/PinterestOptimizerApi;", "", "generateCaptions", "Lcom/pinterest/optimizer/data/models/CaptionResponse;", "request", "Lcom/pinterest/optimizer/data/api/CaptionRequest;", "(Lcom/pinterest/optimizer/data/api/CaptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateHashtags", "Lcom/pinterest/optimizer/data/models/HashtagResponse;", "Lcom/pinterest/optimizer/data/api/HashtagRequest;", "(Lcom/pinterest/optimizer/data/api/HashtagRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findProducts", "Lcom/pinterest/optimizer/data/api/ProductLinksResponse;", "Lcom/pinterest/optimizer/data/api/ProductRequest;", "(Lcom/pinterest/optimizer/data/api/ProductRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suggestBoard", "Lcom/pinterest/optimizer/data/api/BoardResponse;", "Lcom/pinterest/optimizer/data/api/BoardRequest;", "(Lcom/pinterest/optimizer/data/api/BoardRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrends", "Lcom/pinterest/optimizer/data/api/TrendsResponse;", "niche", "", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBestPostingTime", "Lcom/pinterest/optimizer/data/api/PostingTimeResponse;", "Lcom/pinterest/optimizer/data/api/PostingTimeRequest;", "(Lcom/pinterest/optimizer/data/api/PostingTimeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyzeImage", "Lcom/pinterest/optimizer/data/api/ImageAnalysisResponse;", "Lcom/pinterest/optimizer/data/api/ImageAnalysisRequest;", "(Lcom/pinterest/optimizer/data/api/ImageAnalysisRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PinterestOptimizerApi {
    
    @retrofit2.http.POST(value = "/api/generate-captions")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object generateCaptions(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.CaptionRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pinterest.optimizer.data.models.CaptionResponse> $completion);
    
    @retrofit2.http.POST(value = "/api/generate-hashtags")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object generateHashtags(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.HashtagRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pinterest.optimizer.data.models.HashtagResponse> $completion);
    
    @retrofit2.http.POST(value = "/api/find-products")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findProducts(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.ProductRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pinterest.optimizer.data.api.ProductLinksResponse> $completion);
    
    @retrofit2.http.POST(value = "/api/suggest-board")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object suggestBoard(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.BoardRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pinterest.optimizer.data.api.BoardResponse> $completion);
    
    @retrofit2.http.GET(value = "/api/trends/{niche}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTrends(@retrofit2.http.Path(value = "niche")
    @org.jetbrains.annotations.NotNull()
    java.lang.String niche, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pinterest.optimizer.data.api.TrendsResponse> $completion);
    
    @retrofit2.http.POST(value = "/api/best-posting-time")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBestPostingTime(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.PostingTimeRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pinterest.optimizer.data.api.PostingTimeResponse> $completion);
    
    @retrofit2.http.POST(value = "/api/analyze-image")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object analyzeImage(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.api.ImageAnalysisRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pinterest.optimizer.data.api.ImageAnalysisResponse> $completion);
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}