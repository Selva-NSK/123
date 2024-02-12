package com.dmdbrands.balancehealth.ui.screen.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :ViewModel() {

    private val _emailState = MutableStateFlow(EmailState())
    val emailState : MutableStateFlow<EmailState> get() = _emailState


    private fun checkButton(){
        if(_emailState.value.emailErrorCode ==0)
            _emailState.value = _emailState.value.copy(isButtonEnabled = true)
        else
            _emailState.value = _emailState.value.copy(isButtonEnabled = false)

    }
    fun setEmail(email : String){
        _emailState.value= _emailState.value.copy(email = email)
        checkEmail()
        checkButton()
    }
    fun isEmailVisited(){
        _emailState.value=_emailState.value.copy(isEmailVisited=true)
    }
    fun checkEmail(){
        if(_emailState.value.email.isBlank())
            _emailState.value=_emailState.value.copy(emailErrorCode = 1)
        else
            if (!Patterns.EMAIL_ADDRESS.matcher(_emailState.value.email).matches() )
                _emailState.value=_emailState.value.copy(emailErrorCode = 2)
            else
                _emailState.value=_emailState.value.copy(emailErrorCode = 0)

    }

    private val _passwordState = MutableStateFlow(PasswordState())
    val passwordState : MutableStateFlow<PasswordState> get() = _passwordState

    private fun checkButtonPassword(){
        if(_passwordState.value.passwordErrorCode ==0)
            _passwordState.value = _passwordState.value.copy(isButtonEnabled = true)
        else
            _passwordState.value = _passwordState.value.copy(isButtonEnabled = false)

    }
    fun setPassword(password : String){
       _passwordState.value= _passwordState.value.copy(password=password)
        checkPassword()
        checkButtonPassword()
    }
    fun isPasswordVisited(){
        _passwordState.value=_passwordState.value.copy(isPasswordVisited=true)
    }
    fun checkPassword(){
        if(_passwordState.value.password.isBlank())
            _passwordState.value=_passwordState.value.copy(passwordErrorCode = 1)
        else
            _passwordState.value=_passwordState.value.copy(passwordErrorCode = 0)

    }






}
