package nim234311046.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nim234311046.data.User
import nim234311046.data.UserDatabase

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = UserDatabase.getDatabase(application).userDao()

    var currentUser: User? = null
        private set

    fun register(user: User, onSuccess: () -> Unit, onError: () -> Unit) = viewModelScope.launch {
        val existingUser = userDao.getUserByEmail(user.email)
        if (existingUser == null) {
            userDao.insertUser(user)
            onSuccess()
        } else {
            onError()
        }
    }

    fun login(email: String, password: String, onSuccess: () -> Unit, onError: () -> Unit) = viewModelScope.launch {
        val user = userDao.login(email, password)
        if (user != null) {
            currentUser = user
            onSuccess()
        } else {
            onError()
        }
    }

    fun updateCurrentUser(
        name: String,
        email: String,
        password: String,
        newNoHP: String,
        newAlamat: String
    ) {
        currentUser?.let {
            val updatedUser = it.copy(
                name = name,
                email = email,
                password = password,
                noHp = newNoHP,
                alamat = newAlamat
            )
            currentUser = updatedUser
            viewModelScope.launch {
                userDao.updateUser(updatedUser)
            }
        }
    }
}
