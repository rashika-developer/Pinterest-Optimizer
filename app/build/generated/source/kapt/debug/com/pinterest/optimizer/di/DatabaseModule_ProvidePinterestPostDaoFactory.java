package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.database.PinterestOptimizerDatabase;
import com.pinterest.optimizer.data.database.PinterestPostDao;
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
public final class DatabaseModule_ProvidePinterestPostDaoFactory implements Factory<PinterestPostDao> {
  private final DatabaseModule module;

  private final Provider<PinterestOptimizerDatabase> databaseProvider;

  public DatabaseModule_ProvidePinterestPostDaoFactory(DatabaseModule module,
      Provider<PinterestOptimizerDatabase> databaseProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public PinterestPostDao get() {
    return providePinterestPostDao(module, databaseProvider.get());
  }

  public static DatabaseModule_ProvidePinterestPostDaoFactory create(DatabaseModule module,
      Provider<PinterestOptimizerDatabase> databaseProvider) {
    return new DatabaseModule_ProvidePinterestPostDaoFactory(module, databaseProvider);
  }

  public static PinterestPostDao providePinterestPostDao(DatabaseModule instance,
      PinterestOptimizerDatabase database) {
    return Preconditions.checkNotNullFromProvides(instance.providePinterestPostDao(database));
  }
}
