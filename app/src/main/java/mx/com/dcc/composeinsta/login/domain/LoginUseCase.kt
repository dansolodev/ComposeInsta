package mx.com.dcc.composeinsta.login.domain

import mx.com.dcc.composeinsta.login.data.LoginRepository

class LoginUseCase {

    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }

}