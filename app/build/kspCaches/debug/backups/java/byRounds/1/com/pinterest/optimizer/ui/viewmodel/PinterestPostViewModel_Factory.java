package com.pinterest.optimizer.ui.viewmodel;

import com.pinterest.optimizer.data.repository.PinterestPostRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class PinterestPostViewModel_Factory implements Factory<PinterestPostViewModel> {
  private final Provider<PinterestPostRepository> repositoryProvider;

  public PinterestPostViewModel_Factory(Provider<PinterestPostRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PinterestPostViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static PinterestPostViewModel_Factory create(
      Provider<PinterestPostRepository> repositoryProvider) {
    return new PinterestPostViewModel_Factory(repositoryProvider);
  }

  public static PinterestPostViewModel newInstance(PinterestPostRepository repository) {
    return new PinterestPostViewModel(repository);
  }
}
