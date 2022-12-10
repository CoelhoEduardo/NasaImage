package com.example.nasaimage.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaimage.data.Network.ApodApi
import com.example.nasaimage.data.Repository.ApodRepository
import com.example.nasaimage.data.Repository.PictureRepository
import com.example.nasaimage.data.model.ApodData
import com.example.nasaimage.data.model.ApodResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PicturesViewModel(private val PictureRepository: PictureRepository = PictureRepository(ApodApi.instance)): ViewModel() {

        private val _pictures = MutableLiveData<ApodResponse>()
        val apod: MutableLiveData<ApodResponse>
            get() = _pictures

        private val _loading = MutableLiveData(false)
        val loading: LiveData<Boolean>
            get() = _loading

        private val _error = MutableLiveData(false)
        val error: LiveData<Boolean>
            get() = _error

        fun loadPictures(){
            viewModelScope.launch {
                PictureRepository.fetchPicture()
                    .onStart {_loading.value = true}
                    .catch {_error.value = true}
                    .onCompletion {_loading.value = false}
                    .collect {
                        _pictures.value = it
                    }

            }
        }

    }
