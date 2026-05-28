package com.pinterest.optimizer.data.repository;

import com.pinterest.optimizer.data.api.PinterestOptimizerApi;
import com.pinterest.optimizer.data.database.TrendDao;
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
public final class TrendRepository_Factory implements Factory<TrendRepository> {
  private final Provider<TrendDao> trendDaoProvider;

  private final Provider<PinterestOptimizerApi> apiProvider;

  public TrendRepository_Factory(Provider<TrendDao> trendDaoProvider,
      Provider<PinterestOptimizerApi> apiProvider) {
    this.trendDaoProvider = trendDaoProvider;
    this.apiProvider = apiProvider;
  }

  @Override
  public TrendRepository get() {
    return newInstance(trendDaoProvider.get(), apiProvider.get());
  }

  public static TrendRepository_Factory create(Provider<TrendDao> trendDaoProvider,
      Provider<PinterestOptimizerApi> apiProvider) {
    return new TrendRepository_Factory(trendDaoProvider, apiProvider);
  }

  public static TrendRepository newInstance(TrendDao trendDao, PinterestOptimizerApi api) {
    return new TrendRepository(trendDao, api);
  }
}
