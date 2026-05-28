package com.pinterest.optimizer.data.database;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bH\'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\bH\'J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\r\u00c0\u0006\u0003"}, d2 = {"Lcom/pinterest/optimizer/data/database/NicheProfileDao;", "", "insertProfile", "", "profile", "Lcom/pinterest/optimizer/data/models/NicheProfile;", "(Lcom/pinterest/optimizer/data/models/NicheProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentProfile", "Lkotlinx/coroutines/flow/Flow;", "getAllProfiles", "", "updateProfile", "deleteProfile", "app_debug"})
@androidx.room.Dao()
public abstract interface NicheProfileDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertProfile(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.NicheProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM niche_profiles ORDER BY updatedAt DESC LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.pinterest.optimizer.data.models.NicheProfile> getCurrentProfile();
    
    @androidx.room.Query(value = "SELECT * FROM niche_profiles")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pinterest.optimizer.data.models.NicheProfile>> getAllProfiles();
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateProfile(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.NicheProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteProfile(@org.jetbrains.annotations.NotNull()
    com.pinterest.optimizer.data.models.NicheProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}