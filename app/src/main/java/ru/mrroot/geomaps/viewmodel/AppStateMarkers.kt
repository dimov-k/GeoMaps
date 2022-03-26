package ru.mrroot.geomaps.viewmodel

import ru.mrroot.geomaps.model.MarkerObj

sealed class AppStateMarkers {
    data class Success(val markers: List<MarkerObj>) : AppStateMarkers()
    data class Error(val error: Throwable) : AppStateMarkers()
    object Loading : AppStateMarkers()
}
