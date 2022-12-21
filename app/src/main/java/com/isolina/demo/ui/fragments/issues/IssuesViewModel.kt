package com.isolina.demo.ui.fragments.issues

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isolina.demo.domain.base.Output
import com.isolina.demo.domain.models.Issue
import com.isolina.demo.usecases.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IssuesViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {
    private val _items = MutableLiveData<List<Issue>>()
    val items: LiveData<List<Issue>> = _items

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progress

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun issues(id: String) {
        viewModelScope.launch {
            _progress.value = true
            val res = useCase.executeIssues(id)
            if (res.status == Output.Status.SUCCESS) {
                _progress.value = false
                res.data?.items?.let {
                    _items.value = it
                }
            } else {
                _progress.value = false
                _error.value = res.message ?: "Error"
            }
        }
    }
}