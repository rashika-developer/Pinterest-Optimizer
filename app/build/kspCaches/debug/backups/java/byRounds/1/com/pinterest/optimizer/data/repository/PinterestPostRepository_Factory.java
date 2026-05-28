package com.pinterest.optimizer.data.repository;

import com.pinterest.optimizer.data.api.PinterestOptimizerApi;
import com.pinterest.optimizer.data.database.PinterestPostDao;
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
    "KotlinInternalInJava",
    "cast"
})
public final class PinterestPostRepository_Factory implements Factory<PinterestPostRepository> {
  private final Provider<PinterestPostDao> postDaoProvider;

  private final Provider<PinterestOptimizerApi> apiProvider;

  public PinterestPostRepository_Factory(Provider<PinterestPostDao> postDaoProvider,
      Provider<PinterestOptimizerApi> apiProvider) {
    this.postDaoProvider = postDaoProvider;
    this.apiProvider = apiProvider;
  }

  @Override
  public PinterestPostRepository get() {
    return newInstance(postDaoProvider.get(), apiProvider.get());
  }

  public static PinterestPostRepository_Factory create(Provider<PinterestPostDao> postDaoProvider,
      Provider<PinterestOptimizerApi> apiProvider) {
    return new PinterestPostRepository_Factory(postDaoProvider, apiProvider);
  }

  public static PinterestPostRepository newInstance(PinterestPostDao postDao,
      PinterestOptimizerApi api) {
    return new PinterestPostRepository(postDao, api);
  }
}
