package com.home.simpleexamplemvvm.domain

import com.home.simpleexamplemvvm.data.FrutasRepoLocal
import com.home.simpleexamplemvvm.ui.model.Fruta

class FrutasUseCase {

    private val frutasRepoLocal = FrutasRepoLocal()

    fun obtenerListaFrutas(): List<Fruta>{
        return frutasRepoLocal.crearListaDeFrutas()
    }
}