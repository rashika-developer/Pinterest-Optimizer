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
    "KotlinInternalInJava"
})
public final class DatabaseModule_ProvideTrendDaoFactory implements Factory<TrendDao> {
  private final DatabaseModule module;

  private final Provider<PinterestOptimizerDatabase> databaseProvider;

  public DatabaseModule_ProvideTrendDaoFactory(DatabaseModule module,
      Provider<PinterestOptimizerDatabase> databaseProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TrendDao get() {
    return provideTrendDao(module, databaseProvider.get());
  }

  public static DatabaseModule_ProvideTrendDaoFactory create(DatabaseModule module,
      Provider<PinterestOptimizerDatabase> databaseProvider) {
    return new DatabaseModule_ProvideTrendDaoFactory(module, databaseProvider);
  }

  public static TrendDao provideTrendDao(DatabaseModule instance,
      PinterestOptimizerDatabase database) {
    return Preconditions.checkNotNullFromProvides(instance.provideTrendDao(database));
  }
}
