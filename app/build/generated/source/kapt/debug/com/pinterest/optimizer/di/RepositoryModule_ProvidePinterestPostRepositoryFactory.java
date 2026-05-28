package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.api.PinterestOptimizerApi;
import com.pinterest.optimizer.data.database.PinterestPostDao;
import com.pinterest.optimizer.data.repository.PinterestPostRepository;
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
public final class RepositoryModule_ProvidePinterestPostRepositoryFactory implements Factory<PinterestPostRepository> {
  private final RepositoryModule module;

  private final Provider<PinterestPostDao> postDaoProvider;

  private final Provider<PinterestOptimizerApi> apiProvider;

  public RepositoryModule_ProvidePinterestPostRepositoryFactory(RepositoryModule module,
      Provider<PinterestPostDao> postDaoProvider, Provider<PinterestOptimizerApi> apiProvider) {
    this.module = module;
    this.postDaoProvider = postDaoProvider;
    this.apiProvider = apiProvider;
  }

  @Override
  public PinterestPostRepository get() {
    return providePinterestPostRepository(module, postDaoProvider.get(), apiProvider.get());
  }

  public static RepositoryModule_ProvidePinterestPostRepositoryFactory create(
      RepositoryModule module, Provider<PinterestPostDao> postDaoProvider,
      Provider<PinterestOptimizerApi> apiProvider) {
    return new RepositoryModule_ProvidePinterestPostRepositoryFactory(module, postDaoProvider, apiProvider);
  }

  public static PinterestPostRepository providePinterestPostRepository(RepositoryModule instance,
      PinterestPostDao postDao, PinterestOptimizerApi api) {
    return Preconditions.checkNotNullFromProvides(instance.providePinterestPostRepository(postDao, api));
  }
}
