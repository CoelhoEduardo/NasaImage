package com.example.nasaimage.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaimage.data.Repository.ApodRepository
import com.example.nasaimage.data.model.ApodData
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ApodViewModel(private val apodRepository: ApodRepository = ApodRepository.instances): ViewModel() {
    
    private val _apod = MutableLiveData<ApodData>()
    val apod: MutableLiveData<ApodData>
        get() = _apod
    
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading
    
    private val _error = MutableLiveData(false)
    val error: LiveData<Boolean>
        get() = _error
    
    fun loadApod(){
        viewModelScope.launch {
            apodRepository.fetchApod()
                .onStart {_loading.value = true}
                .catch {_error.value = true}
                .onCompletion {_loading.value = false}
                .collect {
                    _apod.value = it
                }

        }
    }
    
}
