package com.example.fakestore.feature.main.category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.core.network.Resource
import com.example.fakestore.feature.main.category.domain.usecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val categoryUseCase: CategoryUseCase) :
    ViewModel() {

    var state by mutableStateOf(CategoryState())
        private set

    init {
        getCategory()
    }

    private var categoryJob: Job? = null
    private fun getCategory() {
        categoryJob?.cancel()
        categoryJob = categoryUseCase().onEach {
            state = when (it) {
                is Resource.Loading -> state.copy(isLoading = true, categories = null, error = null)
                is Resource.Success -> state.copy(
                    isLoading = false,
                    categories = it.data,
                    error = null
                )

                is Resource.Error -> state.copy(
                    isLoading = false,
                    categories = null,
                    error = it.exception?.message
                )
            }
        }.launchIn(viewModelScope)
    }

    override fun onCleared() {
        super.onCleared()
        categoryJob?.cancel()
    }
}