package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.api.PinterestOptimizerApi;
import com.pinterest.optimizer.data.repository.ContentGenerationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
    "KotlinInternalInJava"
})
public final class RepositoryModule_ProvideContentGenerationRepositoryFactory implements Factory<ContentGenerationRepository> {
  private final RepositoryModule module;

  private final Provider<PinterestOptimizerApi> apiProvider;

  public RepositoryModule_ProvideContentGenerationRepositoryFactory(RepositoryModule module,
      Provider<PinterestOptimizerApi> apiProvider) {
    this.module = module;
    this.apiProvider = apiProvider;
  }

  @Override
  public ContentGenerationRepository get() {
    return provideContentGenerationRepository(module, apiProvider.get());
  }

  public static RepositoryModule_ProvideContentGenerationRepositoryFactory create(
      RepositoryModule module, Provider<PinterestOptimizerApi> apiProvider) {
    return new RepositoryModule_ProvideContentGenerationRepositoryFactory(module, apiProvider);
  }

  public static ContentGenerationRepository provideContentGenerationRepository(
      RepositoryModule instance, PinterestOptimizerApi api) {
    return Preconditions.checkNotNullFromProvides(instance.provideContentGenerationRepository(api));
  }
}
