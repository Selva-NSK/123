package com.dmdbrands.balancehealth.ui.screen.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :ViewModel() {
    private val _isVisited: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isVisited : StateFlow<Boolean> get() = _isVisited
    fun isVisited(){
        _isVisited.value=true
    }




    private val _email:MutableStateFlow<String> = MutableStateFlow("")
    val email : StateFlow<String> get() = _email
    fun setEmail(email : String){
        _email.value = email
        checkEmail()
    }

    fun checkEmail(){
        _isEmailEmpty.value = _email.value.isBlank()
        _isValidEmail.value = Patterns.EMAIL_ADDRESS.matcher(_email.value).matches()
    }
    private var _isEmailEmpty  = MutableStateFlow(false)
    val isEmailEmpty : StateFlow<Boolean> get()  = _isEmailEmpty

    private var _isValidEmail  = MutableStateFlow(true)
    val isValidEmail : StateFlow<Boolean> get()  = _isValidEmail


    private val _password:MutableStateFlow<String> =
        MutableStateFlow("")
    val password : StateFlow<String> get() = _password
    fun setPassword(pasword : String){
        _password.value = pasword
    }
}
