package com.pinterest.optimizer.di;

import com.pinterest.optimizer.data.database.NicheProfileDao;
import com.pinterest.optimizer.data.repository.NicheProfileRepository;
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
public final class RepositoryModule_ProvideNicheProfileRepositoryFactory implements Factory<NicheProfileRepository> {
  private final Provider<NicheProfileDao> daoProvider;

  public RepositoryModule_ProvideNicheProfileRepositoryFactory(
      Provider<NicheProfileDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public NicheProfileRepository get() {
    return provideNicheProfileRepository(daoProvider.get());
  }

  public static RepositoryModule_ProvideNicheProfileRepositoryFactory create(
      Provider<NicheProfileDao> daoProvider) {
    return new RepositoryModule_ProvideNicheProfileRepositoryFactory(daoProvider);
  }

  public static NicheProfileRepository provideNicheProfileRepository(NicheProfileDao dao) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideNicheProfileRepository(dao));
  }
}
