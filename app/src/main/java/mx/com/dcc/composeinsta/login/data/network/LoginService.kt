package mx.com.dcc.composeinsta.login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.com.dcc.composeinsta.core.network.RetrofitHelper

class LoginService {

    private val mRetrofit by lazy { RetrofitHelper.getRetrofit() }

    suspend fun doLogin(user: String, password: String): Boolean {
        return  withContext(Dispatchers.IO) {
            val response = mRetrofit.create(LoginClient::class.java).doLogin()
            response.body()?.success ?: false
        }
    }

}