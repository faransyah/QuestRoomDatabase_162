package com.example.myapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.dao.MahasiswaDao
import com.example.myapplication.data.entity.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase(){

    //mendefinisikan fungsi untuk mengakses data mahasiswa
    abstract fun mahasiswa(): MahasiswaDao

    companion object{
        @Volatile // Memastikan bahwa nilai variable Instance selalu sama di
        private  var  Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java, // Class database
                    "KrsDatabase" // Nama Database
                )
                    .build().also{ Instance = it }
            })
        }
    }
}