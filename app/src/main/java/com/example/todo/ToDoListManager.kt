package com.example.todo

import android.os.Build
import java.time.Instant
import java.util.Date

object ToDoListManager {

    private val todoList = mutableListOf<Todo>()

    fun getAllTodo(): List<Todo> {
        return todoList
    }

    fun addToDo(title: String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            todoList.add(Todo(System.currentTimeMillis().toInt(), title, Date.from(Instant.now())))
        }
    }

    fun deleteToDo(id: Int) {
        todoList.removeIf { it.id == id }
    }

}