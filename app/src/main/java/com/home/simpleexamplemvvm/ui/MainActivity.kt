package com.home.simpleexamplemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.home.simpleexamplemvvm.R
import com.home.simpleexamplemvvm.ui.model.Fruta
import com.home.simpleexamplemvvm.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.)Antes que nada vamos dividir por capas nuestros proyecto
        //data: Repositorio
        //viewmodel: tendremos ahí cada viewmodel de cada actividad
        //domain: Que tendrá los casos de uso que necesitara nuestro vm para traer info (casos de uso: hacer tal cosa, obtener tal otra)
        //ui: tendra todas las vistas (tontas) componentes gráficos
        //2.) Creamos nuetro viewmodel

        setupViewModel()

        btnCrearListaFrutas.setOnClickListener {
            myViewModel.getListaFruta()
        }

    }

    fun setupViewModel(){
        //Instanciamos el viewModel
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        val frutasObserver = Observer<List<Fruta>>{
            for(fruta in it){
                Log.d("fruta: ", fruta.nombre)
            }

            for((index, value) in it.withIndex()){
                Log.d("fruta $index: ", value.nombre)
            }
        }

        myViewModel.getListaFrutasLiveData().observe(this, frutasObserver)
    }
}
