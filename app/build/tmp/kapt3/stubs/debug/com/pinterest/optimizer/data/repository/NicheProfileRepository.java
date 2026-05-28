package com.pinterest.optimizer.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007J\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/pinterest/optimizer/data/repository/NicheProfileRepository;", "", "nicheProfileDao", "Lcom/pinterest/optimizer/data/database/NicheProfileDao;", "<init>", "(Lcom/pinterest/optimizer/data/database/NicheProfileDao;)V", "getCurrentProfile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/pinterest/optimizer/data/models/NicheProfile;", "getAllProfiles", "", "createProfile", "", "profile", "(Lcom/pinterest/optimizer/data/models/NicheProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProfile", "app_debug"})
public final class NicheProfileRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.pinterest.optimizer.data.database.NicheProfileDao nicheProfileDao = null;
    
    @javax.inject.Inject()
    public NicheProfileRepository(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.database.NicheProfileDao nicheProfileDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.pinterest.optimizer.data.models.NicheProfile> getCurrentProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pinterest.optimizer.data.models.NicheProfile>> getAllProfiles() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createProfile(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.NicheProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateProfile(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.NicheProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}