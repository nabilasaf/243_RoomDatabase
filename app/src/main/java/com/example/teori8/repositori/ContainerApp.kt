package com.example.teori8.repositori

import android.app.Application
import android.content.Context
import com.example.teori8.room.DatabaseSiswa

interface ContainerApp{
    val repositorySiswa : RepositorySiswa
}

class ContainerDataApp(private val context: Context):
        ContainerApp {
    override val repositorySiswa: RepositorySiswa by lazy {
        OfflineRepositorySiswa(
            DatabaseSiswa.getDatabase(context).siswaDao())
    }
}

class AplikasiSiswa : Application(){
    /**
     * AppContainer instance digunakan oleh kelas-kelas lainya untuk mendapatkan depedensi
     */
    lateinit var container: ContainerApp
    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}
