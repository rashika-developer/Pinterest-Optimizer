package com.pinterest.optimizer;

import androidx.hilt.work.HiltWorkerFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class PinterestOptimizerApp_MembersInjector implements MembersInjector<PinterestOptimizerApp> {
  private final Provider<HiltWorkerFactory> workerFactoryProvider;

  public PinterestOptimizerApp_MembersInjector(Provider<HiltWorkerFactory> workerFactoryProvider) {
    this.workerFactoryProvider = workerFactoryProvider;
  }

  public static MembersInjector<PinterestOptimizerApp> create(
      Provider<HiltWorkerFactory> workerFactoryProvider) {
    return new PinterestOptimizerApp_MembersInjector(workerFactoryProvider);
  }

  @Override
  public void injectMembers(PinterestOptimizerApp instance) {
    injectWorkerFactory(instance, workerFactoryProvider.get());
  }

  @InjectedFieldSignature("com.pinterest.optimizer.PinterestOptimizerApp.workerFactory")
  public static void injectWorkerFactory(PinterestOptimizerApp instance,
      HiltWorkerFactory workerFactory) {
    instance.workerFactory = workerFactory;
  }
}
