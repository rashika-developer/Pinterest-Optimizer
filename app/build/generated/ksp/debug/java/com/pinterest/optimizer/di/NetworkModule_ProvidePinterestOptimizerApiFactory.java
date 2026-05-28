package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.api.PinterestOptimizerApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class NetworkModule_ProvidePinterestOptimizerApiFactory implements Factory<PinterestOptimizerApi> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  public NetworkModule_ProvidePinterestOptimizerApiFactory(
      Provider<OkHttpClient> okHttpClientProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public PinterestOptimizerApi get() {
    return providePinterestOptimizerApi(okHttpClientProvider.get());
  }

  public static NetworkModule_ProvidePinterestOptimizerApiFactory create(
      Provider<OkHttpClient> okHttpClientProvider) {
    return new NetworkModule_ProvidePinterestOptimizerApiFactory(okHttpClientProvider);
  }

  public static PinterestOptimizerApi providePinterestOptimizerApi(OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.providePinterestOptimizerApi(okHttpClient));
  }
}
