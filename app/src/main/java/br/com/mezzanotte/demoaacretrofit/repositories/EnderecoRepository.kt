package br.com.mezzanotte.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import br.com.mezzanotte.demoaacretrofit.entities.EnderecoResponse

interface EnderecoRepository {

    fun buscarEndereco(cep: String) : LiveData<EnderecoResponse>


}