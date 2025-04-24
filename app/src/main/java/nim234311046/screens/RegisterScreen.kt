package com.example.nim234311031.utsmobile2.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import nim234311046.data.User
import androidx.compose.ui.text.input.PasswordVisualTransformation
import nim234311046.viewmodel.UserViewModel

@Composable
fun RegisterScreen(
    userViewModel: UserViewModel = viewModel(),
    onRegisterSuccess: () -> Unit
) {
    val context = LocalContext.current

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(text = "Register", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = noHp,
            onValueChange = { noHp = it },
            label = { Text("No HP") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val user = User(
                    name = nama,
                    email = email,
                    password = password,
                    noHp = noHp,
                    alamat = alamat
                )
                userViewModel.register(user, onSuccess = {
                    Toast.makeText(context, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                    onRegisterSuccess()
                }, onError = {
                    Toast.makeText(context, "Email sudah digunakan", Toast.LENGTH_SHORT).show()
                })
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register")
        }
    }
}