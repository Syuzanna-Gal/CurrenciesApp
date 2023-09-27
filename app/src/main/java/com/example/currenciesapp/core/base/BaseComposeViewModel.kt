package com.example.currenciesapp.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currenciesapp.core.navigation.Command
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseComposeViewModel : ViewModel() {

    private val _command by lazy { Channel<Command>(Channel.BUFFERED) }
    val command = _command.receiveAsFlow()

    protected fun sendCommand(command: Command) {
        viewModelScope.launch { _command.send(command) }
    }

    fun navigateUp() = sendCommand(Command.NavigateUpCommand)
}