package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.api.PinterestOptimizerApi;
import com.pinterest.optimizer.data.database.TrendDao;
import com.pinterest.optimizer.data.repository.TrendRepository;
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
public final class RepositoryModule_ProvideTrendRepositoryFactory implements Factory<TrendRepository> {
  private final Provider<TrendDao> daoProvider;

  private final Provider<PinterestOptimizerApi> apiProvider;

  public RepositoryModule_ProvideTrendRepositoryFactory(Provider<TrendDao> daoProvider,
      Provider<PinterestOptimizerApi> apiProvider) {
    this.daoProvider = daoProvider;
    this.apiProvider = apiProvider;
  }

  @Override
  public TrendRepository get() {
    return provideTrendRepository(daoProvider.get(), apiProvider.get());
  }

  public static RepositoryModule_ProvideTrendRepositoryFactory create(
      Provider<TrendDao> daoProvider, Provider<PinterestOptimizerApi> apiProvider) {
    return new RepositoryModule_ProvideTrendRepositoryFactory(daoProvider, apiProvider);
  }

  public static TrendRepository provideTrendRepository(TrendDao dao, PinterestOptimizerApi api) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideTrendRepository(dao, api));
  }
}
