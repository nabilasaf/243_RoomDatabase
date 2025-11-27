package com.example.teori8.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.teori8.repositori.RepositorySiswa

class EntryViewModel(private val repositoriSiswa: RepositorySiswa): ViewModel() {
    /**
     * Berisi status Siswa saat ini
     */
    var uiStateSiswa by mutableStateOf(value = UiStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa ): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UiStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(uiState = detailSiswa))
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun saveSiswa() {
        if (validasiInput()) {
            repositoriSiswa.insertSiswa(siswa = uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}
/**
 * Mewakili Status UI untuk Siswa.
 */
data class UiStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)
