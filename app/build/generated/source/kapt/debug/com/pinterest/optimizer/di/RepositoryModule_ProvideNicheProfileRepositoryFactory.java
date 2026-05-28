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
    "KotlinInternalInJava"
})
public final class RepositoryModule_ProvideNicheProfileRepositoryFactory implements Factory<NicheProfileRepository> {
  private final RepositoryModule module;

  private final Provider<NicheProfileDao> nicheProfileDaoProvider;

  public RepositoryModule_ProvideNicheProfileRepositoryFactory(RepositoryModule module,
      Provider<NicheProfileDao> nicheProfileDaoProvider) {
    this.module = module;
    this.nicheProfileDaoProvider = nicheProfileDaoProvider;
  }

  @Override
  public NicheProfileRepository get() {
    return provideNicheProfileRepository(module, nicheProfileDaoProvider.get());
  }

  public static RepositoryModule_ProvideNicheProfileRepositoryFactory create(
      RepositoryModule module, Provider<NicheProfileDao> nicheProfileDaoProvider) {
    return new RepositoryModule_ProvideNicheProfileRepositoryFactory(module, nicheProfileDaoProvider);
  }

  public static NicheProfileRepository provideNicheProfileRepository(RepositoryModule instance,
      NicheProfileDao nicheProfileDao) {
    return Preconditions.checkNotNullFromProvides(instance.provideNicheProfileRepository(nicheProfileDao));
  }
}
