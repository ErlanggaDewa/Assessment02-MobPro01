package org.d3if1053.hitungzakatpenghasilan.ui.hitung

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import org.d3if1053.hitungzakatpenghasilan.db.ZakatDao
import org.d3if1053.hitungzakatpenghasilan.model.ZakatModel

class HitungViewModel(val database: ZakatDao, application: Application) :
    AndroidViewModel(application) {
    var zakatModel: ZakatModel = ZakatModel()

    init {
        Log.i("HitungViewModel", "HitungViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("HitungViewModel", "HitungViewModel destroyed!")
    }

    fun isPayZakat(hargaEmas: String, penghasilan: String, bonus: String): Boolean {
        val nisab = (hargaEmas.toFloat() * 85) / 12;
        if (penghasilan.toFloat() + bonus.toDouble() >= nisab) {
            zakatModel.totalZakat = ((penghasilan.toDouble() + bonus.toDouble()) * 0.025).toLong()
            return true
        }
        return false
    }

    fun isNumeric(toCheck: String): Boolean {
        val regex = "[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }
}