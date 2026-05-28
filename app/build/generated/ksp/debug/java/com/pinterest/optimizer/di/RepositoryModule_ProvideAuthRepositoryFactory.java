package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.database.PinterestAccountDao;
import com.pinterest.optimizer.data.repository.AuthRepository;
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
public final class RepositoryModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<PinterestAccountDao> daoProvider;

  public RepositoryModule_ProvideAuthRepositoryFactory(Provider<PinterestAccountDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(daoProvider.get());
  }

  public static RepositoryModule_ProvideAuthRepositoryFactory create(
      Provider<PinterestAccountDao> daoProvider) {
    return new RepositoryModule_ProvideAuthRepositoryFactory(daoProvider);
  }

  public static AuthRepository provideAuthRepository(PinterestAccountDao dao) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideAuthRepository(dao));
  }
}
