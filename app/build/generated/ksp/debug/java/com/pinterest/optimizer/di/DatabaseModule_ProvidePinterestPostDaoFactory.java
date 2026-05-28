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
    "KotlinInternalInJava",
    "cast"
})
public final class DatabaseModule_ProvidePinterestPostDaoFactory implements Factory<PinterestPostDao> {
  private final Provider<PinterestOptimizerDatabase> dbProvider;

  public DatabaseModule_ProvidePinterestPostDaoFactory(
      Provider<PinterestOptimizerDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public PinterestPostDao get() {
    return providePinterestPostDao(dbProvider.get());
  }

  public static DatabaseModule_ProvidePinterestPostDaoFactory create(
      Provider<PinterestOptimizerDatabase> dbProvider) {
    return new DatabaseModule_ProvidePinterestPostDaoFactory(dbProvider);
  }

  public static PinterestPostDao providePinterestPostDao(PinterestOptimizerDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePinterestPostDao(db));
  }
}
