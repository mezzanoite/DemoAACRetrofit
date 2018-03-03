package br.com.mezzanotte.demoaacretrofit.api

import br.com.mezzanotte.demoaacretrofit.entities.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoAPI {

    @GET("/ws/{cep}/json")
    fun pesquisar(@Path("cep") cep: String): Call<Endereco>

}
