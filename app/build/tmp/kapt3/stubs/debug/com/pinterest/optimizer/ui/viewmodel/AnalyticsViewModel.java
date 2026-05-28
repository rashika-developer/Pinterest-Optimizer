package com.pinterest.optimizer.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/pinterest/optimizer/ui/viewmodel/AnalyticsViewModel;", "Landroidx/lifecycle/ViewModel;", "analyticsRepository", "Lcom/pinterest/optimizer/data/repository/AnalyticsRepository;", "<init>", "(Lcom/pinterest/optimizer/data/repository/AnalyticsRepository;)V", "_analyticsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/pinterest/optimizer/data/models/PostAnalytics;", "analyticsState", "Lkotlinx/coroutines/flow/StateFlow;", "getAnalyticsState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadAnalytics", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AnalyticsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.repository.AnalyticsRepository analyticsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.pinterest.optimizer.data.models.PostAnalytics>> _analyticsState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.pinterest.optimizer.data.models.PostAnalytics>> analyticsState = null;
    
    @javax.inject.Inject()
    public AnalyticsViewModel(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.repository.AnalyticsRepository analyticsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.pinterest.optimizer.data.models.PostAnalytics>> getAnalyticsState() {
        return null;
    }
    
    public final void loadAnalytics() {
    }
}