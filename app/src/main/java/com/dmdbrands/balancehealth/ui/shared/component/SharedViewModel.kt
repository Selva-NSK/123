package com.dmdbrands.balancehealth.ui.shared.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SharedViewModel  @Inject constructor() : ViewModel() {

    private val _isHelpVisible : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isHelpVisible : StateFlow<Boolean> get() = _isHelpVisible

    fun openHelp(){
        _isHelpVisible.value=true
    }
    fun closeHelp(){
        _isHelpVisible.value=false
    }


}