package com.pinterest.optimizer.ui.viewmodel;

import com.pinterest.optimizer.data.repository.ContentGenerationRepository;
import com.pinterest.optimizer.data.repository.NicheProfileRepository;
import com.pinterest.optimizer.data.repository.PinterestPostRepository;
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
    "KotlinInternalInJava"
})
public final class PostCreationViewModel_Factory implements Factory<PostCreationViewModel> {
  private final Provider<ContentGenerationRepository> contentGenRepositoryProvider;

  private final Provider<PinterestPostRepository> postRepositoryProvider;

  private final Provider<NicheProfileRepository> nicheRepositoryProvider;

  public PostCreationViewModel_Factory(
      Provider<ContentGenerationRepository> contentGenRepositoryProvider,
      Provider<PinterestPostRepository> postRepositoryProvider,
      Provider<NicheProfileRepository> nicheRepositoryProvider) {
    this.contentGenRepositoryProvider = contentGenRepositoryProvider;
    this.postRepositoryProvider = postRepositoryProvider;
    this.nicheRepositoryProvider = nicheRepositoryProvider;
  }

  @Override
  public PostCreationViewModel get() {
    return newInstance(contentGenRepositoryProvider.get(), postRepositoryProvider.get(), nicheRepositoryProvider.get());
  }

  public static PostCreationViewModel_Factory create(
      Provider<ContentGenerationRepository> contentGenRepositoryProvider,
      Provider<PinterestPostRepository> postRepositoryProvider,
      Provider<NicheProfileRepository> nicheRepositoryProvider) {
    return new PostCreationViewModel_Factory(contentGenRepositoryProvider, postRepositoryProvider, nicheRepositoryProvider);
  }

  public static PostCreationViewModel newInstance(ContentGenerationRepository contentGenRepository,
      PinterestPostRepository postRepository, NicheProfileRepository nicheRepository) {
    return new PostCreationViewModel(contentGenRepository, postRepository, nicheRepository);
  }
}
