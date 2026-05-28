package com.pinterest.optimizer;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.hilt.work.WorkerAssistedFactory;
import androidx.hilt.work.WorkerFactoryModule_ProvideFactoryFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.pinterest.optimizer.data.api.PinterestOptimizerApi;
import com.pinterest.optimizer.data.database.AnalyticsDao;
import com.pinterest.optimizer.data.database.NicheProfileDao;
import com.pinterest.optimizer.data.database.PinterestAccountDao;
import com.pinterest.optimizer.data.database.PinterestOptimizerDatabase;
import com.pinterest.optimizer.data.database.PinterestPostDao;
import com.pinterest.optimizer.data.database.TrendDao;
import com.pinterest.optimizer.data.repository.AnalyticsRepository;
import com.pinterest.optimizer.data.repository.AuthRepository;
import com.pinterest.optimizer.data.repository.ContentGenerationRepository;
import com.pinterest.optimizer.data.repository.NicheProfileRepository;
import com.pinterest.optimizer.data.repository.PinterestPostRepository;
import com.pinterest.optimizer.data.repository.TrendRepository;
import com.pinterest.optimizer.data.worker.SyncWorker;
import com.pinterest.optimizer.data.worker.SyncWorker_AssistedFactory;
import com.pinterest.optimizer.di.DatabaseModule_ProvideAnalyticsDaoFactory;
import com.pinterest.optimizer.di.DatabaseModule_ProvideNicheProfileDaoFactory;
import com.pinterest.optimizer.di.DatabaseModule_ProvidePinterestAccountDaoFactory;
import com.pinterest.optimizer.di.DatabaseModule_ProvidePinterestOptimizerDatabaseFactory;
import com.pinterest.optimizer.di.DatabaseModule_ProvidePinterestPostDaoFactory;
import com.pinterest.optimizer.di.DatabaseModule_ProvideTrendDaoFactory;
import com.pinterest.optimizer.di.NetworkModule_ProvideOkHttpClientFactory;
import com.pinterest.optimizer.di.NetworkModule_ProvidePinterestOptimizerApiFactory;
import com.pinterest.optimizer.di.RepositoryModule_ProvideAnalyticsRepositoryFactory;
import com.pinterest.optimizer.di.RepositoryModule_ProvideAuthRepositoryFactory;
import com.pinterest.optimizer.di.RepositoryModule_ProvideContentGenerationRepositoryFactory;
import com.pinterest.optimizer.di.RepositoryModule_ProvideNicheProfileRepositoryFactory;
import com.pinterest.optimizer.di.RepositoryModule_ProvidePinterestPostRepositoryFactory;
import com.pinterest.optimizer.di.RepositoryModule_ProvideTrendRepositoryFactory;
import com.pinterest.optimizer.ui.viewmodel.AnalyticsViewModel;
import com.pinterest.optimizer.ui.viewmodel.AnalyticsViewModel_HiltModules;
import com.pinterest.optimizer.ui.viewmodel.AuthViewModel;
import com.pinterest.optimizer.ui.viewmodel.AuthViewModel_HiltModules;
import com.pinterest.optimizer.ui.viewmodel.NicheProfileViewModel;
import com.pinterest.optimizer.ui.viewmodel.NicheProfileViewModel_HiltModules;
import com.pinterest.optimizer.ui.viewmodel.PinterestPostViewModel;
import com.pinterest.optimizer.ui.viewmodel.PinterestPostViewModel_HiltModules;
import com.pinterest.optimizer.ui.viewmodel.PostCreationViewModel;
import com.pinterest.optimizer.ui.viewmodel.PostCreationViewModel_HiltModules;
import com.pinterest.optimizer.ui.viewmodel.SettingsViewModel;
import com.pinterest.optimizer.ui.viewmodel.SettingsViewModel_HiltModules;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SingleCheck;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;

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
public final class DaggerPinterestOptimizerApp_HiltComponents_SingletonC {
  private DaggerPinterestOptimizerApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public PinterestOptimizerApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements PinterestOptimizerApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public PinterestOptimizerApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements PinterestOptimizerApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public PinterestOptimizerApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements PinterestOptimizerApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public PinterestOptimizerApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements PinterestOptimizerApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public PinterestOptimizerApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements PinterestOptimizerApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public PinterestOptimizerApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements PinterestOptimizerApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public PinterestOptimizerApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements PinterestOptimizerApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public PinterestOptimizerApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends PinterestOptimizerApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends PinterestOptimizerApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends PinterestOptimizerApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends PinterestOptimizerApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(6).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_AnalyticsViewModel, AnalyticsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_AuthViewModel, AuthViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_NicheProfileViewModel, NicheProfileViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_PinterestPostViewModel, PinterestPostViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_PostCreationViewModel, PostCreationViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_SettingsViewModel, SettingsViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_pinterest_optimizer_ui_viewmodel_AuthViewModel = "com.pinterest.optimizer.ui.viewmodel.AuthViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_SettingsViewModel = "com.pinterest.optimizer.ui.viewmodel.SettingsViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_PostCreationViewModel = "com.pinterest.optimizer.ui.viewmodel.PostCreationViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_AnalyticsViewModel = "com.pinterest.optimizer.ui.viewmodel.AnalyticsViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_NicheProfileViewModel = "com.pinterest.optimizer.ui.viewmodel.NicheProfileViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_PinterestPostViewModel = "com.pinterest.optimizer.ui.viewmodel.PinterestPostViewModel";

      @KeepFieldType
      AuthViewModel com_pinterest_optimizer_ui_viewmodel_AuthViewModel2;

      @KeepFieldType
      SettingsViewModel com_pinterest_optimizer_ui_viewmodel_SettingsViewModel2;

      @KeepFieldType
      PostCreationViewModel com_pinterest_optimizer_ui_viewmodel_PostCreationViewModel2;

      @KeepFieldType
      AnalyticsViewModel com_pinterest_optimizer_ui_viewmodel_AnalyticsViewModel2;

      @KeepFieldType
      NicheProfileViewModel com_pinterest_optimizer_ui_viewmodel_NicheProfileViewModel2;

      @KeepFieldType
      PinterestPostViewModel com_pinterest_optimizer_ui_viewmodel_PinterestPostViewModel2;
    }
  }

  private static final class ViewModelCImpl extends PinterestOptimizerApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AnalyticsViewModel> analyticsViewModelProvider;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<NicheProfileViewModel> nicheProfileViewModelProvider;

    private Provider<PinterestPostViewModel> pinterestPostViewModelProvider;

    private Provider<PostCreationViewModel> postCreationViewModelProvider;

    private Provider<SettingsViewModel> settingsViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.analyticsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.nicheProfileViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.pinterestPostViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.postCreationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(6).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_AnalyticsViewModel, ((Provider) analyticsViewModelProvider)).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_AuthViewModel, ((Provider) authViewModelProvider)).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_NicheProfileViewModel, ((Provider) nicheProfileViewModelProvider)).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_PinterestPostViewModel, ((Provider) pinterestPostViewModelProvider)).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_PostCreationViewModel, ((Provider) postCreationViewModelProvider)).put(LazyClassKeyProvider.com_pinterest_optimizer_ui_viewmodel_SettingsViewModel, ((Provider) settingsViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_pinterest_optimizer_ui_viewmodel_AuthViewModel = "com.pinterest.optimizer.ui.viewmodel.AuthViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_PostCreationViewModel = "com.pinterest.optimizer.ui.viewmodel.PostCreationViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_SettingsViewModel = "com.pinterest.optimizer.ui.viewmodel.SettingsViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_NicheProfileViewModel = "com.pinterest.optimizer.ui.viewmodel.NicheProfileViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_AnalyticsViewModel = "com.pinterest.optimizer.ui.viewmodel.AnalyticsViewModel";

      static String com_pinterest_optimizer_ui_viewmodel_PinterestPostViewModel = "com.pinterest.optimizer.ui.viewmodel.PinterestPostViewModel";

      @KeepFieldType
      AuthViewModel com_pinterest_optimizer_ui_viewmodel_AuthViewModel2;

      @KeepFieldType
      PostCreationViewModel com_pinterest_optimizer_ui_viewmodel_PostCreationViewModel2;

      @KeepFieldType
      SettingsViewModel com_pinterest_optimizer_ui_viewmodel_SettingsViewModel2;

      @KeepFieldType
      NicheProfileViewModel com_pinterest_optimizer_ui_viewmodel_NicheProfileViewModel2;

      @KeepFieldType
      AnalyticsViewModel com_pinterest_optimizer_ui_viewmodel_AnalyticsViewModel2;

      @KeepFieldType
      PinterestPostViewModel com_pinterest_optimizer_ui_viewmodel_PinterestPostViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.pinterest.optimizer.ui.viewmodel.AnalyticsViewModel 
          return (T) new AnalyticsViewModel(singletonCImpl.provideAnalyticsRepositoryProvider.get());

          case 1: // com.pinterest.optimizer.ui.viewmodel.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.provideAuthRepositoryProvider.get());

          case 2: // com.pinterest.optimizer.ui.viewmodel.NicheProfileViewModel 
          return (T) new NicheProfileViewModel(singletonCImpl.provideNicheProfileRepositoryProvider.get());

          case 3: // com.pinterest.optimizer.ui.viewmodel.PinterestPostViewModel 
          return (T) new PinterestPostViewModel(singletonCImpl.providePinterestPostRepositoryProvider.get());

          case 4: // com.pinterest.optimizer.ui.viewmodel.PostCreationViewModel 
          return (T) new PostCreationViewModel(singletonCImpl.provideContentGenerationRepositoryProvider.get(), singletonCImpl.providePinterestPostRepositoryProvider.get(), singletonCImpl.provideNicheProfileRepositoryProvider.get(), singletonCImpl.providePinterestOptimizerApiProvider.get());

          case 5: // com.pinterest.optimizer.ui.viewmodel.SettingsViewModel 
          return (T) new SettingsViewModel();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends PinterestOptimizerApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends PinterestOptimizerApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends PinterestOptimizerApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<PinterestOptimizerDatabase> providePinterestOptimizerDatabaseProvider;

    private Provider<TrendDao> provideTrendDaoProvider;

    private Provider<OkHttpClient> provideOkHttpClientProvider;

    private Provider<PinterestOptimizerApi> providePinterestOptimizerApiProvider;

    private Provider<TrendRepository> provideTrendRepositoryProvider;

    private Provider<NicheProfileDao> provideNicheProfileDaoProvider;

    private Provider<NicheProfileRepository> provideNicheProfileRepositoryProvider;

    private Provider<PinterestPostDao> providePinterestPostDaoProvider;

    private Provider<PinterestPostRepository> providePinterestPostRepositoryProvider;

    private Provider<SyncWorker_AssistedFactory> syncWorker_AssistedFactoryProvider;

    private Provider<AnalyticsDao> provideAnalyticsDaoProvider;

    private Provider<AnalyticsRepository> provideAnalyticsRepositoryProvider;

    private Provider<PinterestAccountDao> providePinterestAccountDaoProvider;

    private Provider<AuthRepository> provideAuthRepositoryProvider;

    private Provider<ContentGenerationRepository> provideContentGenerationRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private Map<String, javax.inject.Provider<WorkerAssistedFactory<? extends ListenableWorker>>> mapOfStringAndProviderOfWorkerAssistedFactoryOf(
        ) {
      return Collections.<String, javax.inject.Provider<WorkerAssistedFactory<? extends ListenableWorker>>>singletonMap("com.pinterest.optimizer.data.worker.SyncWorker", ((Provider) syncWorker_AssistedFactoryProvider));
    }

    private HiltWorkerFactory hiltWorkerFactory() {
      return WorkerFactoryModule_ProvideFactoryFactory.provideFactory(mapOfStringAndProviderOfWorkerAssistedFactoryOf());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.providePinterestOptimizerDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<PinterestOptimizerDatabase>(singletonCImpl, 3));
      this.provideTrendDaoProvider = DoubleCheck.provider(new SwitchingProvider<TrendDao>(singletonCImpl, 2));
      this.provideOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 5));
      this.providePinterestOptimizerApiProvider = DoubleCheck.provider(new SwitchingProvider<PinterestOptimizerApi>(singletonCImpl, 4));
      this.provideTrendRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<TrendRepository>(singletonCImpl, 1));
      this.provideNicheProfileDaoProvider = DoubleCheck.provider(new SwitchingProvider<NicheProfileDao>(singletonCImpl, 7));
      this.provideNicheProfileRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<NicheProfileRepository>(singletonCImpl, 6));
      this.providePinterestPostDaoProvider = DoubleCheck.provider(new SwitchingProvider<PinterestPostDao>(singletonCImpl, 9));
      this.providePinterestPostRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<PinterestPostRepository>(singletonCImpl, 8));
      this.syncWorker_AssistedFactoryProvider = SingleCheck.provider(new SwitchingProvider<SyncWorker_AssistedFactory>(singletonCImpl, 0));
      this.provideAnalyticsDaoProvider = DoubleCheck.provider(new SwitchingProvider<AnalyticsDao>(singletonCImpl, 11));
      this.provideAnalyticsRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<AnalyticsRepository>(singletonCImpl, 10));
      this.providePinterestAccountDaoProvider = DoubleCheck.provider(new SwitchingProvider<PinterestAccountDao>(singletonCImpl, 13));
      this.provideAuthRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<AuthRepository>(singletonCImpl, 12));
      this.provideContentGenerationRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ContentGenerationRepository>(singletonCImpl, 14));
    }

    @Override
    public void injectPinterestOptimizerApp(PinterestOptimizerApp pinterestOptimizerApp) {
      injectPinterestOptimizerApp2(pinterestOptimizerApp);
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @CanIgnoreReturnValue
    private PinterestOptimizerApp injectPinterestOptimizerApp2(PinterestOptimizerApp instance) {
      PinterestOptimizerApp_MembersInjector.injectWorkerFactory(instance, hiltWorkerFactory());
      return instance;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.pinterest.optimizer.data.worker.SyncWorker_AssistedFactory 
          return (T) new SyncWorker_AssistedFactory() {
            @Override
            public SyncWorker create(Context context, WorkerParameters params) {
              return new SyncWorker(context, params, singletonCImpl.provideTrendRepositoryProvider.get(), singletonCImpl.provideNicheProfileRepositoryProvider.get(), singletonCImpl.providePinterestPostRepositoryProvider.get());
            }
          };

          case 1: // com.pinterest.optimizer.data.repository.TrendRepository 
          return (T) RepositoryModule_ProvideTrendRepositoryFactory.provideTrendRepository(singletonCImpl.provideTrendDaoProvider.get(), singletonCImpl.providePinterestOptimizerApiProvider.get());

          case 2: // com.pinterest.optimizer.data.database.TrendDao 
          return (T) DatabaseModule_ProvideTrendDaoFactory.provideTrendDao(singletonCImpl.providePinterestOptimizerDatabaseProvider.get());

          case 3: // com.pinterest.optimizer.data.database.PinterestOptimizerDatabase 
          return (T) DatabaseModule_ProvidePinterestOptimizerDatabaseFactory.providePinterestOptimizerDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.pinterest.optimizer.data.api.PinterestOptimizerApi 
          return (T) NetworkModule_ProvidePinterestOptimizerApiFactory.providePinterestOptimizerApi(singletonCImpl.provideOkHttpClientProvider.get());

          case 5: // okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient();

          case 6: // com.pinterest.optimizer.data.repository.NicheProfileRepository 
          return (T) RepositoryModule_ProvideNicheProfileRepositoryFactory.provideNicheProfileRepository(singletonCImpl.provideNicheProfileDaoProvider.get());

          case 7: // com.pinterest.optimizer.data.database.NicheProfileDao 
          return (T) DatabaseModule_ProvideNicheProfileDaoFactory.provideNicheProfileDao(singletonCImpl.providePinterestOptimizerDatabaseProvider.get());

          case 8: // com.pinterest.optimizer.data.repository.PinterestPostRepository 
          return (T) RepositoryModule_ProvidePinterestPostRepositoryFactory.providePinterestPostRepository(singletonCImpl.providePinterestPostDaoProvider.get(), singletonCImpl.providePinterestOptimizerApiProvider.get());

          case 9: // com.pinterest.optimizer.data.database.PinterestPostDao 
          return (T) DatabaseModule_ProvidePinterestPostDaoFactory.providePinterestPostDao(singletonCImpl.providePinterestOptimizerDatabaseProvider.get());

          case 10: // com.pinterest.optimizer.data.repository.AnalyticsRepository 
          return (T) RepositoryModule_ProvideAnalyticsRepositoryFactory.provideAnalyticsRepository(singletonCImpl.provideAnalyticsDaoProvider.get());

          case 11: // com.pinterest.optimizer.data.database.AnalyticsDao 
          return (T) DatabaseModule_ProvideAnalyticsDaoFactory.provideAnalyticsDao(singletonCImpl.providePinterestOptimizerDatabaseProvider.get());

          case 12: // com.pinterest.optimizer.data.repository.AuthRepository 
          return (T) RepositoryModule_ProvideAuthRepositoryFactory.provideAuthRepository(singletonCImpl.providePinterestAccountDaoProvider.get());

          case 13: // com.pinterest.optimizer.data.database.PinterestAccountDao 
          return (T) DatabaseModule_ProvidePinterestAccountDaoFactory.providePinterestAccountDao(singletonCImpl.providePinterestOptimizerDatabaseProvider.get());

          case 14: // com.pinterest.optimizer.data.repository.ContentGenerationRepository 
          return (T) RepositoryModule_ProvideContentGenerationRepositoryFactory.provideContentGenerationRepository(singletonCImpl.providePinterestOptimizerApiProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
