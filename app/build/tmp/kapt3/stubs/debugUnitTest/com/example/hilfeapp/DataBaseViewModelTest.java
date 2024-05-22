package com.example.hilfeapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u001b\u001a\u00060\u0012j\u0002`\u001cH\u0007J\f\u0010\u001d\u001a\u00060\u0012j\u0002`\u001cH\u0007J\b\u0010\u001e\u001a\u00020\u0012H\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u00020\r8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00180\b8\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/hilfeapp/DataBaseViewModelTest;", "", "()V", "collectionReference", "Lcom/google/firebase/firestore/CollectionReference;", "documentSnapshot", "Lcom/google/firebase/firestore/DocumentSnapshot;", "failureCaptor", "Lorg/mockito/ArgumentCaptor;", "Lcom/google/android/gms/tasks/OnFailureListener;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "instantTaskExecutorRule", "Landroidx/arch/core/executor/testing/InstantTaskExecutorRule;", "getInstantTaskExecutorRule", "()Landroidx/arch/core/executor/testing/InstantTaskExecutorRule;", "onSuccess", "Lkotlin/Function0;", "", "query", "Lcom/google/firebase/firestore/Query;", "querySnapshot", "Lcom/google/firebase/firestore/QuerySnapshot;", "successCaptor", "Lcom/google/android/gms/tasks/OnSuccessListener;", "viewModel", "Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DataBaseViewModel;", "getHosp_failure", "Lkotlinx/coroutines/test/TestResult;", "getHosp_success", "setUp", "app_debugUnitTest"})
@kotlinx.coroutines.ExperimentalCoroutinesApi()
public final class DataBaseViewModelTest {
    @org.jetbrains.annotations.NotNull()
    private final androidx.arch.core.executor.testing.InstantTaskExecutorRule instantTaskExecutorRule = null;
    @org.mockito.Mock()
    private com.google.firebase.firestore.FirebaseFirestore firestore;
    @org.mockito.Mock()
    private com.google.firebase.firestore.CollectionReference collectionReference;
    @org.mockito.Mock()
    private com.google.firebase.firestore.Query query;
    @org.mockito.Mock()
    private com.google.firebase.firestore.QuerySnapshot querySnapshot;
    @org.mockito.Mock()
    private com.google.firebase.firestore.DocumentSnapshot documentSnapshot;
    @org.mockito.Captor()
    private org.mockito.ArgumentCaptor<com.google.android.gms.tasks.OnSuccessListener<com.google.firebase.firestore.QuerySnapshot>> successCaptor;
    @org.mockito.Captor()
    private org.mockito.ArgumentCaptor<com.google.android.gms.tasks.OnFailureListener> failureCaptor;
    @org.mockito.Mock()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess;
    private com.example.hilfeapp.krankenwagen.ui.viewModels.DataBaseViewModel viewModel;
    
    public DataBaseViewModelTest() {
        super();
    }
    
    @org.junit.Rule()
    @org.jetbrains.annotations.NotNull()
    public final androidx.arch.core.executor.testing.InstantTaskExecutorRule getInstantTaskExecutorRule() {
        return null;
    }
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    @org.junit.Test()
    public final void getHosp_success() {
    }
    
    @org.junit.Test()
    public final void getHosp_failure() {
    }
}