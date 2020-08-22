package com.home.simpleexamplemvvm.data

import com.home.simpleexamplemvvm.ui.model.Fruta

class FrutasRepoLocal {

    fun crearListaDeFrutas(): List<Fruta> {
        return listOf(
            Fruta("Manzana", "Rojo", 4.5f, 200.3f),
            Fruta("Banana", "Amarillo", 5.60f, 200f),
            Fruta("Uvas", "Verde", 10.50f, 100.5f)
        )
    }
}