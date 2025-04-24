package nim234311046.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import nim234311046.viewmodel.UserViewModel
import nim234311046.ui.navigation.Screen

@Composable
fun UpdateProfileScreen(navController: NavController, viewModel: UserViewModel) {
    val user = viewModel.currentUser

    var newName by remember { mutableStateOf(user?.name ?: "") }
    var newEmail by remember { mutableStateOf(user?.email ?: "") }
    var newPassword by remember { mutableStateOf(user?.password ?: "") }
    var newNoHP by remember { mutableStateOf(user?.noHp ?: "") }
    var newAlamat by remember { mutableStateOf(user?.alamat ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Update Profile",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        OutlinedTextField(
            value = newName,
            onValueChange = { newName = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = newEmail,
            onValueChange = { newEmail = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = newNoHP,
            onValueChange = { newNoHP = it },
            label = { Text("No HP") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = newAlamat,
            onValueChange = { newAlamat = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.updateCurrentUser(newName, newEmail, newPassword, newNoHP, newAlamat)
                navController.navigate(Screen.Home.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simpan")
        }
    }
}


