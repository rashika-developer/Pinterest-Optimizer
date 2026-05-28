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
    "KotlinInternalInJava"
})
public final class RepositoryModule_ProvideTrendRepositoryFactory implements Factory<TrendRepository> {
  private final RepositoryModule module;

  private final Provider<TrendDao> trendDaoProvider;

  private final Provider<PinterestOptimizerApi> apiProvider;

  public RepositoryModule_ProvideTrendRepositoryFactory(RepositoryModule module,
      Provider<TrendDao> trendDaoProvider, Provider<PinterestOptimizerApi> apiProvider) {
    this.module = module;
    this.trendDaoProvider = trendDaoProvider;
    this.apiProvider = apiProvider;
  }

  @Override
  public TrendRepository get() {
    return provideTrendRepository(module, trendDaoProvider.get(), apiProvider.get());
  }

  public static RepositoryModule_ProvideTrendRepositoryFactory create(RepositoryModule module,
      Provider<TrendDao> trendDaoProvider, Provider<PinterestOptimizerApi> apiProvider) {
    return new RepositoryModule_ProvideTrendRepositoryFactory(module, trendDaoProvider, apiProvider);
  }

  public static TrendRepository provideTrendRepository(RepositoryModule instance, TrendDao trendDao,
      PinterestOptimizerApi api) {
    return Preconditions.checkNotNullFromProvides(instance.provideTrendRepository(trendDao, api));
  }
}
