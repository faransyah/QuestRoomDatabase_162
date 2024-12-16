package com.example.myapplication.ui.viewmodel

import com.example.myapplication.data.entity.Mahasiswa
import com.example.myapplication.ui.theme.viewmodel.MahasiswaEvent

class DetailMhsViewModel (
savedSyaye
)

data class DetailUiState(
    val detailUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
){
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == MahasiswaEvent()

    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != MahasiswaEvent()
}

/*
Data Class untuk menampung data yang akan ditampilkan di UI
 */

// Memindahkan data dari entity ke ui
fun Mahasiswa.toDetailUiEvent(): MahasiswaEvent{
    return MahasiswaEvent(

    )
}