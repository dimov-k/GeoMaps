package ru.mrroot.geomaps.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ru.mrroot.geomaps.model.MarkerDB
import ru.mrroot.geomaps.model.MarkerDBImpl
import ru.mrroot.geomaps.model.MarkerObj

class MapsViewModel(
    private val liveDataToObserve: MutableLiveData<AppStateMaps> = MutableLiveData(),
    private val repository: MarkerDB = MarkerDBImpl()
) : ViewModel(), CoroutineScope by MainScope() {
    fun getLiveData() = liveDataToObserve
    fun saveMarker(marker: MarkerObj) {
        liveDataToObserve.value = AppStateMaps.Loading
        launch(Dispatchers.IO) {
            try {
                if (repository.saveMarker(marker) != null)
                    liveDataToObserve.postValue(
                        AppStateMaps.Success
                    )
            } catch (e: Exception) {
                liveDataToObserve.postValue(AppStateMaps.Error(e))
            }
        }
    }
}