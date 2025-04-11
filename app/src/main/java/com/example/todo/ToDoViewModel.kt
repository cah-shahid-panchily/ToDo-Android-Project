package com.example.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViewModel: ViewModel() {

    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList : LiveData<List<Todo>> = _todoList

    fun getAllTodo() {
        _todoList.value = ToDoListManager.getAllTodo().reversed()
    }

    fun addToDo(title: String) {
        ToDoListManager.addToDo(title)
        getAllTodo()
    }

    fun deleteToDo(id: Int) {
        ToDoListManager.deleteToDo(id)
        getAllTodo()
    }

}