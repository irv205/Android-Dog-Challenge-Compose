package com.kk.dogchallengecompose.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.dogchallengecompose.core.utils.ResponseHandler
import com.kk.dogchallengecompose.data.repository.RepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RepositoryImp) : ViewModel() {

    private val _state = mutableStateOf<MainViewState?>(MainViewState.Idle)
    val state : State<MainViewState?> get() = _state

    init {
        getDog()
    }

    fun getDog(){
        viewModelScope.launch(Dispatchers.IO) {
            when(val result = repository.getDog()){
                is ResponseHandler.Error -> {
                    _state.value = MainViewState.Error(result.message)
                }
                is ResponseHandler.Success -> {
                    _state.value = MainViewState.Success(result.data.message)
                }
            }
        }
    }
}