package com.pinterest.optimizer.ui.screens;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a.\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007\u001a$\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u00a8\u0006\u0015"}, d2 = {"PostCreationScreen", "", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/pinterest/optimizer/ui/viewmodel/PostCreationViewModel;", "CaptionOptionCard", "title", "", "caption", "isSelected", "", "onClick", "Lkotlin/Function0;", "HashtagDisplay", "hashtags", "", "trendingHashtags", "ProductCard", "product", "Lcom/pinterest/optimizer/data/models/ProductLink;", "app_debug"})
public final class PostCreationScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void PostCreationScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.ui.viewmodel.PostCreationViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CaptionOptionCard(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String caption, boolean isSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HashtagDisplay(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> hashtags, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> trendingHashtags) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ProductCard(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.ProductLink product) {
    }
}