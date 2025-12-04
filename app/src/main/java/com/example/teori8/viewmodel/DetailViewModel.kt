package com.example.teori8.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.teori8.repositori.RepositorySiswa
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositorySiswa: RepositorySiswa) : ViewModel() {
        private val idSiswa: Int =
            checkNotNull(savedStateHandle[DestinasiDetailSiswa.itemIdArg])
    val uiDetailState: StateFlow<DetailSiswaUiState> =
        repositorySiswa.getSiswaStream(idSiswa)
            .filterNotNull()
            .map {
                DetailSiswaUiState(detailSiswa = it.toDetailSiswa())
                }.stateIn
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = DetailSiswaUiState()
        )
    suspend fun deleteSiswa() {
        repositorySiswa.deleteSiswa(uiDetailState.value.detailSiswa.toSiswa()))
    }
    companion object{
    private const val TIMEOUT_MILLIS = 5_000L
    }
}