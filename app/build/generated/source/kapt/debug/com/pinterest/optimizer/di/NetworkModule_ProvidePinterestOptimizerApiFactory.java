package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.api.PinterestOptimizerApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NetworkModule_ProvidePinterestOptimizerApiFactory implements Factory<PinterestOptimizerApi> {
  private final NetworkModule module;

  public NetworkModule_ProvidePinterestOptimizerApiFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public PinterestOptimizerApi get() {
    return providePinterestOptimizerApi(module);
  }

  public static NetworkModule_ProvidePinterestOptimizerApiFactory create(NetworkModule module) {
    return new NetworkModule_ProvidePinterestOptimizerApiFactory(module);
  }

  public static PinterestOptimizerApi providePinterestOptimizerApi(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providePinterestOptimizerApi());
  }
}
