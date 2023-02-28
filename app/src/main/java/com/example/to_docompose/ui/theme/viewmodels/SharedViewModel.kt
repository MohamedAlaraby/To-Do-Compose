package com.example.to_docompose.ui.theme.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_docompose.data.model.ToDoTask
import com.example.to_docompose.data.repositories.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SharedViewModel @Inject constructor(private val toDoRepo:ToDoRepository):ViewModel() {
    private var _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    private var allTasks :StateFlow<List<ToDoTask>> = _allTasks
fun getAllTasks(){
    viewModelScope.launch {
        toDoRepo.getAllTasks.collect {
        _allTasks.value=it



        }

    }
}


}