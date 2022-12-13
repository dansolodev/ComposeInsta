package mx.com.dcc.composeinsta.login.data

import mx.com.dcc.composeinsta.login.data.network.LoginService

class LoginRepository {

    private val api = LoginService()

    suspend fun doLogin(user: String, password: String): Boolean {
        return api.doLogin(user, password)
    }

}