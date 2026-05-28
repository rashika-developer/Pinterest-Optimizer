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
    "KotlinInternalInJava",
    "cast"
})
public final class RepositoryModule_ProvidePinterestPostRepositoryFactory implements Factory<PinterestPostRepository> {
  private final Provider<PinterestPostDao> daoProvider;

  private final Provider<PinterestOptimizerApi> apiProvider;

  public RepositoryModule_ProvidePinterestPostRepositoryFactory(
      Provider<PinterestPostDao> daoProvider, Provider<PinterestOptimizerApi> apiProvider) {
    this.daoProvider = daoProvider;
    this.apiProvider = apiProvider;
  }

  @Override
  public PinterestPostRepository get() {
    return providePinterestPostRepository(daoProvider.get(), apiProvider.get());
  }

  public static RepositoryModule_ProvidePinterestPostRepositoryFactory create(
      Provider<PinterestPostDao> daoProvider, Provider<PinterestOptimizerApi> apiProvider) {
    return new RepositoryModule_ProvidePinterestPostRepositoryFactory(daoProvider, apiProvider);
  }

  public static PinterestPostRepository providePinterestPostRepository(PinterestPostDao dao,
      PinterestOptimizerApi api) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.providePinterestPostRepository(dao, api));
  }
}
