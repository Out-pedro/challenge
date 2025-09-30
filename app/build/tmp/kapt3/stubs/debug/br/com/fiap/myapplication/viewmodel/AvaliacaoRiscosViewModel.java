package br.com.fiap.myapplication.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020,J\u0006\u0010.\u001a\u00020,J\u0006\u0010/\u001a\u00020,J\u0016\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020$J\b\u00103\u001a\u00020,H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R+\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\n0(\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u00a8\u00065"}, d2 = {"Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lbr/com/fiap/myapplication/data/repository/AvaliacaoRepository;", "(Lbr/com/fiap/myapplication/data/repository/AvaliacaoRepository;)V", "_perguntas", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lbr/com/fiap/challenge/model/Pergunta;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState;", "<set-?>", "", "formValido", "getFormValido", "()Z", "setFormValido", "(Z)V", "formValido$delegate", "Landroidx/compose/runtime/MutableState;", "formularioEnviado", "getFormularioEnviado", "setFormularioEnviado", "formularioEnviado$delegate", "mostrarConfirmacao", "getMostrarConfirmacao", "setMostrarConfirmacao", "mostrarConfirmacao$delegate", "opcoes", "", "", "getOpcoes", "()Ljava/util/List;", "perguntas", "getPerguntas", "respostas", "", "getRespostas", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "carregarPerguntas", "", "enviarFormulario", "recarregarPerguntas", "resetarFormulario", "selecionarOpcao", "perguntaIndex", "opcaoIndex", "verificarFormulario", "UiState", "app_debug"})
public final class AvaliacaoRiscosViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final br.com.fiap.myapplication.data.repository.AvaliacaoRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel.UiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel.UiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.snapshots.SnapshotStateList<br.com.fiap.challenge.model.Pergunta> _perguntas = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.Integer> respostas = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState mostrarConfirmacao$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState formularioEnviado$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState formValido$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> opcoes = null;
    
    public AvaliacaoRiscosViewModel(@org.jetbrains.annotations.NotNull()
    br.com.fiap.myapplication.data.repository.AvaliacaoRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel.UiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<br.com.fiap.challenge.model.Pergunta> getPerguntas() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.Integer> getRespostas() {
        return null;
    }
    
    public final boolean getMostrarConfirmacao() {
        return false;
    }
    
    private final void setMostrarConfirmacao(boolean p0) {
    }
    
    public final boolean getFormularioEnviado() {
        return false;
    }
    
    private final void setFormularioEnviado(boolean p0) {
    }
    
    public final boolean getFormValido() {
        return false;
    }
    
    private final void setFormValido(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getOpcoes() {
        return null;
    }
    
    private final void carregarPerguntas() {
    }
    
    public final void selecionarOpcao(int perguntaIndex, int opcaoIndex) {
    }
    
    public final void enviarFormulario() {
    }
    
    public final void resetarFormulario() {
    }
    
    public final void recarregarPerguntas() {
    }
    
    private final void verificarFormulario() {
    }
    
    public AvaliacaoRiscosViewModel() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState;", "", "()V", "Error", "Loading", "Success", "Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState$Error;", "Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState$Loading;", "Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState$Success;", "app_debug"})
    public static abstract class UiState {
        
        private UiState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState$Error;", "Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel.UiState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            public Error(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel.UiState.Error copy(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState$Loading;", "Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState;", "()V", "app_debug"})
        public static final class Loading extends br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel.UiState {
            @org.jetbrains.annotations.NotNull()
            public static final br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel.UiState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState$Success;", "Lbr/com/fiap/myapplication/viewmodel/AvaliacaoRiscosViewModel$UiState;", "()V", "app_debug"})
        public static final class Success extends br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel.UiState {
            @org.jetbrains.annotations.NotNull()
            public static final br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel.UiState.Success INSTANCE = null;
            
            private Success() {
            }
        }
    }
}