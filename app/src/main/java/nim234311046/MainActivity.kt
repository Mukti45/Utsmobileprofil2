package nim234311046

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nim234311046.screens.HomeScreen
import nim234311046.screens.LoginScreen
import com.example.nim234311031.utsmobile2.ui.screens.RegisterScreen
import nim234311046.screens.UpdateProfileScreen
import nim234311046.ui.navigation.Screen
import nim234311046.ui.theme.UtsMobile2Theme
import nim234311046.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UtsMobile2Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: UserViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.Register.route) {
            RegisterScreen(
                userViewModel = viewModel,
                onRegisterSuccess = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Register.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.UpdateProfile.route) {
            UpdateProfileScreen(navController = navController, viewModel = viewModel)
        }
    }
}