package br.com.fiap.myapplication.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lbr/com/fiap/myapplication/data/api/AvaliacaoRiscosApi;", "", "enviarAvaliacao", "Lretrofit2/Response;", "Lbr/com/fiap/myapplication/data/api/model/AvaliacaoResponse;", "request", "Lbr/com/fiap/myapplication/data/api/model/AvaliacaoRequest;", "(Lbr/com/fiap/myapplication/data/api/model/AvaliacaoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obterPerguntas", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AvaliacaoRiscosApi {
    
    @retrofit2.http.POST(value = "avaliacao")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object enviarAvaliacao(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    br.com.fiap.myapplication.data.api.model.AvaliacaoRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<br.com.fiap.myapplication.data.api.model.AvaliacaoResponse>> $completion);
    
    @retrofit2.http.GET(value = "perguntas")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object obterPerguntas(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<java.lang.String>>> $completion);
}