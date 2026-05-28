package com.pinterest.optimizer.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001cJ\u001a\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u00a8\u0006!"}, d2 = {"Lcom/pinterest/optimizer/ui/viewmodel/PostCreationViewModel;", "Landroidx/lifecycle/ViewModel;", "contentGenRepository", "Lcom/pinterest/optimizer/data/repository/ContentGenerationRepository;", "postRepository", "Lcom/pinterest/optimizer/data/repository/PinterestPostRepository;", "nicheRepository", "Lcom/pinterest/optimizer/data/repository/NicheProfileRepository;", "<init>", "(Lcom/pinterest/optimizer/data/repository/ContentGenerationRepository;Lcom/pinterest/optimizer/data/repository/PinterestPostRepository;Lcom/pinterest/optimizer/data/repository/NicheProfileRepository;)V", "_captionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/pinterest/optimizer/ui/viewmodel/CaptionState;", "captionState", "Lkotlinx/coroutines/flow/StateFlow;", "getCaptionState", "()Lkotlinx/coroutines/flow/StateFlow;", "_hashtagState", "Lcom/pinterest/optimizer/ui/viewmodel/HashtagState;", "hashtagState", "getHashtagState", "_productState", "Lcom/pinterest/optimizer/ui/viewmodel/ProductState;", "productState", "getProductState", "generateCaptions", "", "description", "", "generateHashtags", "content", "findProducts", "imageUrl", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PostCreationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.repository.ContentGenerationRepository contentGenRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.repository.PinterestPostRepository postRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.repository.NicheProfileRepository nicheRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.pinterest.optimizer.ui.viewmodel.CaptionState> _captionState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.pinterest.optimizer.ui.viewmodel.CaptionState> captionState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.pinterest.optimizer.ui.viewmodel.HashtagState> _hashtagState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.pinterest.optimizer.ui.viewmodel.HashtagState> hashtagState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.pinterest.optimizer.ui.viewmodel.ProductState> _productState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.pinterest.optimizer.ui.viewmodel.ProductState> productState = null;
    
    @javax.inject.Inject()
    public PostCreationViewModel(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.repository.ContentGenerationRepository contentGenRepository, @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.repository.PinterestPostRepository postRepository, @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.repository.NicheProfileRepository nicheRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.pinterest.optimizer.ui.viewmodel.CaptionState> getCaptionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.pinterest.optimizer.ui.viewmodel.HashtagState> getHashtagState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.pinterest.optimizer.ui.viewmodel.ProductState> getProductState() {
        return null;
    }
    
    public final void generateCaptions(@org.jetbrains.annotations.NotNull()
    java.lang.String description) {
    }
    
    public final void generateHashtags(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void findProducts(@org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl) {
    }
}