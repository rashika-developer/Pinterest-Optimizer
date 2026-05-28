package com.pinterest.optimizer.data.repository;

import com.pinterest.optimizer.data.database.NicheProfileDao;
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
    "KotlinInternalInJava"
})
public final class NicheProfileRepository_Factory implements Factory<NicheProfileRepository> {
  private final Provider<NicheProfileDao> nicheProfileDaoProvider;

  public NicheProfileRepository_Factory(Provider<NicheProfileDao> nicheProfileDaoProvider) {
    this.nicheProfileDaoProvider = nicheProfileDaoProvider;
  }

  @Override
  public NicheProfileRepository get() {
    return newInstance(nicheProfileDaoProvider.get());
  }

  public static NicheProfileRepository_Factory create(
      Provider<NicheProfileDao> nicheProfileDaoProvider) {
    return new NicheProfileRepository_Factory(nicheProfileDaoProvider);
  }

  public static NicheProfileRepository newInstance(NicheProfileDao nicheProfileDao) {
    return new NicheProfileRepository(nicheProfileDao);
  }
}
