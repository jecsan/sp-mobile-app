package com.sourcepad.sourcepadsuite.presentation


import com.sourcepad.sourcepadsuite.data.api.User

sealed class DataState {
    abstract val state: State

}

data class LoginState(override val state: State, val user: User? = null, val source: Source? = null) : DataState()

enum class State {
    DEFAULT, LOADING, SUCCESS, FAILED,
}


enum class Source {
    DB, REMOTE
}
