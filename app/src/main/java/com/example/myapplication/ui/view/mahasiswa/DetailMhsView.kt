package com.example.myapplication.ui.view.mahasiswa

import android.app.AlertDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.entity.Mahasiswa

@Composable
fun ItemDetailMhs(
    modifier: Modifier = Modifier,
    mahasiswa: Mahasiswa
){
Card(
    modifier = modifier
        .fillMaxWidth(),
    colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    )
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        ComponentDetailMhs(judul = "NIM", isinya = mahasiswa.nim)
        Spacer(modifier = Modifier.padding(4.dp))

    }
}
}
@Composable
fun ComponentDetailMhs(
    modifier: Modifier = Modifier,
    judul: String,
    isinya: String
){
Column(
    modifier = modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.Start
) {
    Text(
        text = "$judul : ",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Gray
    )
    Text(
        text = isinya, fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
}
}
@Composable
private fun DeleteConFirmationDialog(
    onDeleteConfirm: () -> Unit, onDeleteCancel: () -> Unit, modifier: Modifier = Modifier
){
    AlertDialog(onDismissRequest = { /* Do nothing */},
        title = { Text("Delete Data")},
        text = { Text("Apakah anda yakin ingin menghapus data?")},
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = "Cancel")
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirm) {
                Text(text = "Yes")
            }
        })
}