package com.home.simpleexamplemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.home.simpleexamplemvvm.domain.FrutasUseCase
import com.home.simpleexamplemvvm.ui.model.Fruta

class MyViewModel: ViewModel() {
    //livedata:
    //mutableLiveData: Es algo que cambia
    //Inmutable: no se puede reasignar
    private val listData = MutableLiveData<List<Fruta>>()
    val frutasUseCase = FrutasUseCase()

//    init {
//        getListaFruta()
//    }


    //metodo donde setearemos los data a la listData
    fun setListData(frutas: List<Fruta>){
        listData.value = frutas
    }

    //buscara en el repo la lista de frutas
    //podemos usar courutines para pedir info  que sea asincrona
    fun getListaFruta(){
        setListData(frutasUseCase.obtenerListaFrutas())
    }


    //LiveData: Este componente escucha por el valor de MutableLiveData si cambió o no
    //Si cambio: Hara algo ene ste caso, retorna la lista
    //si no cambio, no hara nada.
    fun getListaFrutasLiveData():LiveData<List<Fruta>>{
        return listData

    }


}