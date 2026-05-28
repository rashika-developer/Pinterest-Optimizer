package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.database.AnalyticsDao;
import com.pinterest.optimizer.data.repository.AnalyticsRepository;
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
public final class RepositoryModule_ProvideAnalyticsRepositoryFactory implements Factory<AnalyticsRepository> {
  private final RepositoryModule module;

  private final Provider<AnalyticsDao> analyticsDaoProvider;

  public RepositoryModule_ProvideAnalyticsRepositoryFactory(RepositoryModule module,
      Provider<AnalyticsDao> analyticsDaoProvider) {
    this.module = module;
    this.analyticsDaoProvider = analyticsDaoProvider;
  }

  @Override
  public AnalyticsRepository get() {
    return provideAnalyticsRepository(module, analyticsDaoProvider.get());
  }

  public static RepositoryModule_ProvideAnalyticsRepositoryFactory create(RepositoryModule module,
      Provider<AnalyticsDao> analyticsDaoProvider) {
    return new RepositoryModule_ProvideAnalyticsRepositoryFactory(module, analyticsDaoProvider);
  }

  public static AnalyticsRepository provideAnalyticsRepository(RepositoryModule instance,
      AnalyticsDao analyticsDao) {
    return Preconditions.checkNotNullFromProvides(instance.provideAnalyticsRepository(analyticsDao));
  }
}
