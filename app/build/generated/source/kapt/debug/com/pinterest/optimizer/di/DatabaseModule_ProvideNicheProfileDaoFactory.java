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
    "KotlinInternalInJava"
})
public final class DatabaseModule_ProvideNicheProfileDaoFactory implements Factory<NicheProfileDao> {
  private final DatabaseModule module;

  private final Provider<PinterestOptimizerDatabase> databaseProvider;

  public DatabaseModule_ProvideNicheProfileDaoFactory(DatabaseModule module,
      Provider<PinterestOptimizerDatabase> databaseProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public NicheProfileDao get() {
    return provideNicheProfileDao(module, databaseProvider.get());
  }

  public static DatabaseModule_ProvideNicheProfileDaoFactory create(DatabaseModule module,
      Provider<PinterestOptimizerDatabase> databaseProvider) {
    return new DatabaseModule_ProvideNicheProfileDaoFactory(module, databaseProvider);
  }

  public static NicheProfileDao provideNicheProfileDao(DatabaseModule instance,
      PinterestOptimizerDatabase database) {
    return Preconditions.checkNotNullFromProvides(instance.provideNicheProfileDao(database));
  }
}
