package com.pinterest.optimizer.data.repository;

import com.pinterest.optimizer.data.database.PinterestAccountDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AuthRepository_Factory implements Factory<AuthRepository> {
  private final Provider<PinterestAccountDao> accountDaoProvider;

  public AuthRepository_Factory(Provider<PinterestAccountDao> accountDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
  }

  @Override
  public AuthRepository get() {
    return newInstance(accountDaoProvider.get());
  }

  public static AuthRepository_Factory create(Provider<PinterestAccountDao> accountDaoProvider) {
    return new AuthRepository_Factory(accountDaoProvider);
  }

  public static AuthRepository newInstance(PinterestAccountDao accountDao) {
    return new AuthRepository(accountDao);
  }
}
