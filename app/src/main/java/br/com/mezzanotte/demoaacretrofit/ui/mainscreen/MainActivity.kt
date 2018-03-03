package br.com.mezzanotte.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import br.com.mezzanotte.demoaacretrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        btPesquisar.setOnClickListener {
            mainViewModel.pesquisarEndereco(etCEP.text.toString())
        }

        mainViewModel.enderecoResponse.observe(this, Observer {
            enderecoResponse ->
            if (enderecoResponse?.erro == null) {
                val end = enderecoResponse?.endereco
                tvResultado.text = "Logradouro: ${end?.logradouro}\n" +
                        "Complemento: ${end?.complemento}\n" +
                        "Bairro: ${end?.bairro}\n" +
                        "Localidade: ${end?.localidade}\n" +
                        "UF: ${end?.uf}"
                Log.i("TAG", "SUCESSO")
            } else {
                Log.i("TAG", "ERRO: ${enderecoResponse.erro} ...")
            }
        })

        mainViewModel.isLoading.observe(this, Observer {
            isLoading ->
            if (isLoading!!) {
                loading.visibility = View.VISIBLE
            } else {
                loading.visibility = View.GONE
            }
        })

    }
}
