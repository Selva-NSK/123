package com.dmdbrands.balancehealth.ui.screen.login

import android.util.Log
import android.util.Patterns
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :ViewModel() {
    // Text Field State
    private val _email:MutableStateFlow<String> = MutableStateFlow("")
    val email : StateFlow<String> get() = _email
    private val _password:MutableStateFlow<String> = MutableStateFlow("")
    val password : StateFlow<String> get() = _password

    //Validation States for Email Text-Field
    private val _isEmailVisited: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isEmailVisited : StateFlow<Boolean> get() = _isEmailVisited
    private var _isEmailEmpty  = MutableStateFlow(false)
    val isEmailEmpty : StateFlow<Boolean> get()  = _isEmailEmpty
    private var _isValidEmail  = MutableStateFlow(true)
    val isValidEmail : StateFlow<Boolean> get()  = _isValidEmail
    //Validation States For Password Text-Field
    private var _isPasswordEmpty  = MutableStateFlow(false)
    val isPasswordEmpty : StateFlow<Boolean> get()  = _isPasswordEmpty

    private val _isPasswordVisited: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isPasswordVisited : StateFlow<Boolean> get() = _isPasswordVisited

    //States for Button
    private val _buttonState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val buttonState : StateFlow<Boolean> get() = _buttonState

    private val _map : MutableStateFlow<Map<String,String>> = MutableStateFlow(
        mutableMapOf("Selva@gmail.com" to "12345"))
    val map : MutableStateFlow<Map<String,String>> = _map

    private val _dummy: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val dummy : StateFlow<Boolean> get() = _dummy

    fun checkcred(st1 : String,key : String) {
        _map.value.forEach {
        if (st1 == it.key && key == it.value)
            _dummy.value=true

    }
    }


    private fun checkButton(){
        if(_isEmailVisited.value && _isPasswordVisited.value){
            _buttonState.value = _isValidEmail.value && !(_isPasswordEmpty.value)
        }
    }

    //Function for Email Validation
    fun isEmailVisited(){
        _isEmailVisited.value=true
    }
    fun setEmail(email : String){
        _email.value = email
        checkEmail()
        checkButton()
    }
    fun checkEmail(){
        _isEmailEmpty.value = _email.value.isBlank()
        _isValidEmail.value = Patterns.EMAIL_ADDRESS.matcher(_email.value).matches()
    }
    //Function for Password vaidation
    fun isPasswordVisited(){
        _isPasswordVisited.value=true
    }
    fun setPassword(password : String){
        _password.value = password
        checkPassword()
        checkButton()
    }
    fun checkPassword(){
        _isPasswordEmpty.value = _password.value.isBlank()
    }

    val focus = MutableStateFlow(FocusRequester())
}
