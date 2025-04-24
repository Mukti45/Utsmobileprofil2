package nim234311046.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nim234311046.viewmodel.UserViewModel
import nim234311046.screens.LoginScreen
import nim234311046.screens.HomeScreen
import nim234311046.screens.UpdateProfileScreen
import com.example.nim234311031.utsmobile2.ui.screens.RegisterScreen

sealed class Screen(val route: String) {
    object Register : Screen("register")
    object Login : Screen("login")
    object Home : Screen("home")
    object UpdateProfile : Screen("update_profile")
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    userViewModel: UserViewModel
) {
    NavHost(navController = navController, startDestination = Screen.Register.route) {
        composable(Screen.Register.route) {
            RegisterScreen(
                userViewModel = userViewModel,
                onRegisterSuccess = {
                    // Navigasi ke halaman Login setelah registrasi berhasil
                    navController.navigate(Screen.Login.route)
                }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(navController, userViewModel)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController, userViewModel)
        }
        composable(Screen.UpdateProfile.route) {
            UpdateProfileScreen(navController, userViewModel)
        }
    }
}