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
    "KotlinInternalInJava",
    "cast"
})
public final class DatabaseModule_ProvideAnalyticsDaoFactory implements Factory<AnalyticsDao> {
  private final Provider<PinterestOptimizerDatabase> dbProvider;

  public DatabaseModule_ProvideAnalyticsDaoFactory(
      Provider<PinterestOptimizerDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public AnalyticsDao get() {
    return provideAnalyticsDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideAnalyticsDaoFactory create(
      Provider<PinterestOptimizerDatabase> dbProvider) {
    return new DatabaseModule_ProvideAnalyticsDaoFactory(dbProvider);
  }

  public static AnalyticsDao provideAnalyticsDao(PinterestOptimizerDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAnalyticsDao(db));
  }
}
