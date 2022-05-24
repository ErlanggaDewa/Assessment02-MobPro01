package org.d3if1053.hitungzakatpenghasilan.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ZakatDao {
    @Insert
    fun insert(amoeba: ZakatEntity)

    @Query("SELECT * FROM zakat ORDER BY id")
    fun getLastBmi(): LiveData<List<ZakatEntity>>

    @Delete
    fun clearData(amoeba: ZakatEntity)

}