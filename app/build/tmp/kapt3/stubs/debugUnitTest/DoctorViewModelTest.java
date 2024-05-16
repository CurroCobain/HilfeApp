
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0007J\b\u0010\u0013\u001a\u00020\u0011H\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"LDoctorViewModelTest;", "", "()V", "mockAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mockFirestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "testDispatcher", "Lkotlinx/coroutines/test/TestCoroutineDispatcher;", "viewModel", "Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DoctorViewModel;", "mockTask", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/auth/AuthResult;", "isSuccessful", "", "setUp", "", "test sesionInit with failed login", "test sesionInit with successful login", "app_debugUnitTest"})
@kotlinx.coroutines.ExperimentalCoroutinesApi()
public final class DoctorViewModelTest {
    private com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel viewModel;
    @org.mockito.Mock()
    private com.google.firebase.auth.FirebaseAuth mockAuth;
    @org.mockito.Mock()
    private com.google.firebase.firestore.FirebaseFirestore mockFirestore;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.test.TestCoroutineDispatcher testDispatcher = null;
    
    public DoctorViewModelTest() {
        super();
    }
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    private final com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> mockTask(boolean isSuccessful) {
        return null;
    }
}