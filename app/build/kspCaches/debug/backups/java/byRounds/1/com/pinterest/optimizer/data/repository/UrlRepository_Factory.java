package com.pinterest.optimizer.data.repository;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
    "KotlinInternalInJava",
    "cast"
})
public final class UrlRepository_Factory implements Factory<UrlRepository> {
  private final Provider<Context> contextProvider;

  public UrlRepository_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public UrlRepository get() {
    return newInstance(contextProvider.get());
  }

  public static UrlRepository_Factory create(Provider<Context> contextProvider) {
    return new UrlRepository_Factory(contextProvider);
  }

  public static UrlRepository newInstance(Context context) {
    return new UrlRepository(context);
  }
}
