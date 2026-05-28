package com.pinterest.optimizer.ui.viewmodel;

import com.pinterest.optimizer.data.repository.NicheProfileRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class NicheProfileViewModel_Factory implements Factory<NicheProfileViewModel> {
  private final Provider<NicheProfileRepository> nicheRepositoryProvider;

  public NicheProfileViewModel_Factory(Provider<NicheProfileRepository> nicheRepositoryProvider) {
    this.nicheRepositoryProvider = nicheRepositoryProvider;
  }

  @Override
  public NicheProfileViewModel get() {
    return newInstance(nicheRepositoryProvider.get());
  }

  public static NicheProfileViewModel_Factory create(
      Provider<NicheProfileRepository> nicheRepositoryProvider) {
    return new NicheProfileViewModel_Factory(nicheRepositoryProvider);
  }

  public static NicheProfileViewModel newInstance(NicheProfileRepository nicheRepository) {
    return new NicheProfileViewModel(nicheRepository);
  }
}
