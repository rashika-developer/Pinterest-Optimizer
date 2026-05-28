package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.database.PinterestAccountDao;
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
public final class DatabaseModule_ProvidePinterestAccountDaoFactory implements Factory<PinterestAccountDao> {
  private final Provider<PinterestOptimizerDatabase> dbProvider;

  public DatabaseModule_ProvidePinterestAccountDaoFactory(
      Provider<PinterestOptimizerDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public PinterestAccountDao get() {
    return providePinterestAccountDao(dbProvider.get());
  }

  public static DatabaseModule_ProvidePinterestAccountDaoFactory create(
      Provider<PinterestOptimizerDatabase> dbProvider) {
    return new DatabaseModule_ProvidePinterestAccountDaoFactory(dbProvider);
  }

  public static PinterestAccountDao providePinterestAccountDao(PinterestOptimizerDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePinterestAccountDao(db));
  }
}
