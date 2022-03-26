package ru.mrroot.geomaps.viewmodel

sealed class AppStateMaps {
    object Success : AppStateMaps()
    data class Error(val error: Throwable) : AppStateMaps()
    object Loading : AppStateMaps()
}