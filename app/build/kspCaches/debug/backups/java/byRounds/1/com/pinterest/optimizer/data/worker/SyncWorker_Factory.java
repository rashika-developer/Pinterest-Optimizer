package com.pinterest.optimizer.data.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.pinterest.optimizer.data.repository.NicheProfileRepository;
import com.pinterest.optimizer.data.repository.PinterestPostRepository;
import com.pinterest.optimizer.data.repository.TrendRepository;
import dagger.internal.DaggerGenerated;
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
public final class SyncWorker_Factory {
  private final Provider<TrendRepository> trendRepositoryProvider;

  private final Provider<NicheProfileRepository> nicheRepositoryProvider;

  private final Provider<PinterestPostRepository> postRepositoryProvider;

  public SyncWorker_Factory(Provider<TrendRepository> trendRepositoryProvider,
      Provider<NicheProfileRepository> nicheRepositoryProvider,
      Provider<PinterestPostRepository> postRepositoryProvider) {
    this.trendRepositoryProvider = trendRepositoryProvider;
    this.nicheRepositoryProvider = nicheRepositoryProvider;
    this.postRepositoryProvider = postRepositoryProvider;
  }

  public SyncWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, trendRepositoryProvider.get(), nicheRepositoryProvider.get(), postRepositoryProvider.get());
  }

  public static SyncWorker_Factory create(Provider<TrendRepository> trendRepositoryProvider,
      Provider<NicheProfileRepository> nicheRepositoryProvider,
      Provider<PinterestPostRepository> postRepositoryProvider) {
    return new SyncWorker_Factory(trendRepositoryProvider, nicheRepositoryProvider, postRepositoryProvider);
  }

  public static SyncWorker newInstance(Context context, WorkerParameters params,
      TrendRepository trendRepository, NicheProfileRepository nicheRepository,
      PinterestPostRepository postRepository) {
    return new SyncWorker(context, params, trendRepository, nicheRepository, postRepository);
  }
}
