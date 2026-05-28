package com.pinterest.optimizer.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/pinterest/optimizer/ui/viewmodel/NicheProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "nicheRepository", "Lcom/pinterest/optimizer/data/repository/NicheProfileRepository;", "<init>", "(Lcom/pinterest/optimizer/data/repository/NicheProfileRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/pinterest/optimizer/ui/viewmodel/NicheProfileUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadProfile", "", "saveProfile", "niche", "", "description", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NicheProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.repository.NicheProfileRepository nicheRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.pinterest.optimizer.ui.viewmodel.NicheProfileUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.pinterest.optimizer.ui.viewmodel.NicheProfileUiState> uiState = null;
    
    @javax.inject.Inject()
    public NicheProfileViewModel(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.repository.NicheProfileRepository nicheRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.pinterest.optimizer.ui.viewmodel.NicheProfileUiState> getUiState() {
        return null;
    }
    
    public final void loadProfile() {
    }
    
    public final void saveProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String niche, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
    }
}