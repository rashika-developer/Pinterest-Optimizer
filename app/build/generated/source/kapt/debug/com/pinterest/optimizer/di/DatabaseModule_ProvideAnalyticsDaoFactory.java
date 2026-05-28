package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.database.AnalyticsDao;
import com.pinterest.optimizer.data.database.PinterestOptimizerDatabase;
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
public final class DatabaseModule_ProvideAnalyticsDaoFactory implements Factory<AnalyticsDao> {
  private final DatabaseModule module;

  private final Provider<PinterestOptimizerDatabase> databaseProvider;

  public DatabaseModule_ProvideAnalyticsDaoFactory(DatabaseModule module,
      Provider<PinterestOptimizerDatabase> databaseProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public AnalyticsDao get() {
    return provideAnalyticsDao(module, databaseProvider.get());
  }

  public static DatabaseModule_ProvideAnalyticsDaoFactory create(DatabaseModule module,
      Provider<PinterestOptimizerDatabase> databaseProvider) {
    return new DatabaseModule_ProvideAnalyticsDaoFactory(module, databaseProvider);
  }

  public static AnalyticsDao provideAnalyticsDao(DatabaseModule instance,
      PinterestOptimizerDatabase database) {
    return Preconditions.checkNotNullFromProvides(instance.provideAnalyticsDao(database));
  }
}
