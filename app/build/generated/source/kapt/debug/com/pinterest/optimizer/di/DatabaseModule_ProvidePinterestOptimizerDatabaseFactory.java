package com.pinterest.optimizer.di;

import android.content.Context;
import com.pinterest.optimizer.data.database.PinterestOptimizerDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvidePinterestOptimizerDatabaseFactory implements Factory<PinterestOptimizerDatabase> {
  private final DatabaseModule module;

  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvidePinterestOptimizerDatabaseFactory(DatabaseModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public PinterestOptimizerDatabase get() {
    return providePinterestOptimizerDatabase(module, contextProvider.get());
  }

  public static DatabaseModule_ProvidePinterestOptimizerDatabaseFactory create(
      DatabaseModule module, Provider<Context> contextProvider) {
    return new DatabaseModule_ProvidePinterestOptimizerDatabaseFactory(module, contextProvider);
  }

  public static PinterestOptimizerDatabase providePinterestOptimizerDatabase(
      DatabaseModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.providePinterestOptimizerDatabase(context));
  }
}
