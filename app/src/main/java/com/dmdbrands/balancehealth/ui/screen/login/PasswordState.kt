package com.dmdbrands.balancehealth.ui.screen.login

data class PasswordState(
    var password: String ="",
    var isPasswordVisited : Boolean = false,
    var passwordErrorCode : Int = 0,
    var isButtonEnabled : Boolean = false
)
