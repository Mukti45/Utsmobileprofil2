package nim234311046.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import nim234311046.viewmodel.UserViewModel
import nim234311046.ui.navigation.Screen

@Composable
fun HomeScreen(navController: NavController, viewModel: UserViewModel) {
    val currentUser = viewModel.currentUser

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Spacer untuk menaikkan tampilan
        Spacer(modifier = Modifier.height(60.dp))

        Text("Home", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = currentUser?.name ?: "",
            onValueChange = {},
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = currentUser?.email ?: "",
            onValueChange = {},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = currentUser?.password ?: "",
            onValueChange = {},
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = currentUser?.noHp ?: "",
            onValueChange = {},
            label = { Text("No HP") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = currentUser?.alamat ?: "",
            onValueChange = {},
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            navController.navigate(Screen.UpdateProfile.route)
        }) {
            Text("Update Profile")
        }
    }
}


