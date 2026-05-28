package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.database.PinterestOptimizerDatabase;
import com.pinterest.optimizer.data.database.TrendDao;
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
public final class DatabaseModule_ProvideTrendDaoFactory implements Factory<TrendDao> {
  private final Provider<PinterestOptimizerDatabase> dbProvider;

  public DatabaseModule_ProvideTrendDaoFactory(Provider<PinterestOptimizerDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public TrendDao get() {
    return provideTrendDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideTrendDaoFactory create(
      Provider<PinterestOptimizerDatabase> dbProvider) {
    return new DatabaseModule_ProvideTrendDaoFactory(dbProvider);
  }

  public static TrendDao provideTrendDao(PinterestOptimizerDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTrendDao(db));
  }
}
