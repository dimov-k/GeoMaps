package ru.mrroot.geomaps.model

data class MarkerObj(
    var title: String = "",
    var description: String = "",
    var lat: Double = 0.0,
    var long: Double = 0.0,
    var keyMarker: String = ""
)
