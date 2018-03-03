package br.com.mezzanotte.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import br.com.mezzanotte.demoaacretrofit.entities.EnderecoResponse
import br.com.mezzanotte.demoaacretrofit.repositories.EnderecoRepository
import br.com.mezzanotte.demoaacretrofit.repositories.EnderecoRepositoryImpl

class MainViewModel : ViewModel() {

    private val enderecoRepository: EnderecoRepository
    private val mEnderecoResponse: MediatorLiveData<EnderecoResponse> = MediatorLiveData()
    val enderecoResponse: LiveData<EnderecoResponse>
        get() = mEnderecoResponse

    init {
        enderecoRepository = EnderecoRepositoryImpl()
    }

    fun pesquisarEndereco(cep: String): LiveData<EnderecoResponse> {

        mEnderecoResponse.addSource(enderecoRepository.buscarEndereco(cep)) {
            enderecoResponse -> mEnderecoResponse.value = enderecoResponse
        }
        return mEnderecoResponse
    }

}
