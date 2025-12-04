package com.example.teori8.viewmodel.provider

import DetailViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.teori8.repositori.AplikasiSiswa
import com.example.teori8.viewmodel.EntryViewModel
import com.example.teori8.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositorySiswa)
        }
        initializer {
            EntryViewModel(repositoriSiswa = aplikasiSiswa().container.repositorySiswa)
        }

        initializer {
            DetailViewModel(this.createSavedStateHandle(),aplikasiSiswa().container.repositorySiswa)
        }

//        initializer {
//            EditViewModel(this.createSavedStateHandle(),aplikasiSiswa().container.repositorySiswa)
//        }
    }

    /**
     * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
     * [AplikasiSiswa].
     */
    fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
}