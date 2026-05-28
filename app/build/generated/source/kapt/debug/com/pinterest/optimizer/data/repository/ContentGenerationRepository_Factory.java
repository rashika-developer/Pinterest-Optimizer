package com.pinterest.optimizer.data.repository;

import com.pinterest.optimizer.data.api.PinterestOptimizerApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class ContentGenerationRepository_Factory implements Factory<ContentGenerationRepository> {
  private final Provider<PinterestOptimizerApi> apiProvider;

  public ContentGenerationRepository_Factory(Provider<PinterestOptimizerApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public ContentGenerationRepository get() {
    return newInstance(apiProvider.get());
  }

  public static ContentGenerationRepository_Factory create(
      Provider<PinterestOptimizerApi> apiProvider) {
    return new ContentGenerationRepository_Factory(apiProvider);
  }

  public static ContentGenerationRepository newInstance(PinterestOptimizerApi api) {
    return new ContentGenerationRepository(api);
  }
}
