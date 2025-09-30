package br.com.fiap.challenge.interfece;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lbr/com/fiap/challenge/interfece/UsuarioApi;", "", "criaUsuario", "Lretrofit2/Response;", "Lbr/com/fiap/challenge/response/UsuarioResponseDTO;", "usuario", "Lbr/com/fiap/challenge/request/UsuarioRequestDTO;", "(Lbr/com/fiap/challenge/request/UsuarioRequestDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lbr/com/fiap/challenge/interfece/UsuarioApi$LoginResponseDTO;", "request", "Lbr/com/fiap/challenge/request/LoginRequestDTO;", "(Lbr/com/fiap/challenge/request/LoginRequestDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LoginResponseDTO", "app_debug"})
public abstract interface UsuarioApi {
    
    @retrofit2.http.POST(value = "user")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object criaUsuario(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    br.com.fiap.challenge.request.UsuarioRequestDTO usuario, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<br.com.fiap.challenge.response.UsuarioResponseDTO>> $completion);
    
    @retrofit2.http.POST(value = "user/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    br.com.fiap.challenge.request.LoginRequestDTO request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<br.com.fiap.challenge.interfece.UsuarioApi.LoginResponseDTO>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lbr/com/fiap/challenge/interfece/UsuarioApi$LoginResponseDTO;", "", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class LoginResponseDTO {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public LoginResponseDTO(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            super();
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
        public final br.com.fiap.challenge.interfece.UsuarioApi.LoginResponseDTO copy(@org.jetbrains.annotations.NotNull()
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
}