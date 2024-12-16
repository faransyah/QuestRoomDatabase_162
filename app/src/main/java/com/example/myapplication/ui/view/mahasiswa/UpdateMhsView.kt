package com.example.myapplication.ui.view.mahasiswa

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.viewmodel.PenyediaViewModel
import com.example.myapplication.ui.viewmodel.UpdateMhsViewModel
import kotlinx.coroutines.launch

@Composable
fun UpdateMhsView(
    onBack: () -> Unit,
    onNavigate: () ->,
    modifier: Modifier = Modifier,
    viewModel: UpdateMhsViewModel = viewModel(factory = PenyediaViewModel.Factory) // Inisialisasi ViewModel
){
    val uiState = viewModel.updateUIState // Ambil UI state dari viewmodel
    val snackbarHostState = remember { SnackbarHostState() } // Snackbar state
    val coroutineScope = rememberCoroutineScope()

    // Observasi perubahan snackbarMessage

    LaunchedEffect(uiState.snackBarMessage){
        println("LaunchedEffect trigerred")
        uiState.snackBarMessage?.let{ message ->
            println("Snackbar message received: $message")
            coroutineScope.launch {
                println("Launching coroutine fo snackbar")
                snackbarHostState.showSnackbar(
                    message = message,
                    duration = SnackbarDuration.Long
                )
                viewModel.resetSnackBarMessage()
            }
        }
    }

}