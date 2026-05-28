package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.database.NicheProfileDao;
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
public final class DatabaseModule_ProvideNicheProfileDaoFactory implements Factory<NicheProfileDao> {
  private final Provider<PinterestOptimizerDatabase> dbProvider;

  public DatabaseModule_ProvideNicheProfileDaoFactory(
      Provider<PinterestOptimizerDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public NicheProfileDao get() {
    return provideNicheProfileDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideNicheProfileDaoFactory create(
      Provider<PinterestOptimizerDatabase> dbProvider) {
    return new DatabaseModule_ProvideNicheProfileDaoFactory(dbProvider);
  }

  public static NicheProfileDao provideNicheProfileDao(PinterestOptimizerDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideNicheProfileDao(db));
  }
}
