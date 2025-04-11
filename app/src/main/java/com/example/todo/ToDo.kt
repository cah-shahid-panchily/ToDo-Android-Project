package com.example.todo

import java.time.Instant
import java.util.Date
import java.util.Date.*


data class Todo(
    var id: Int,
    var titles: String,
    var createdAt: Date
)

fun getMockTodo(): List<Todo> {
    return listOf<Todo>(
        Todo(1, "FirstToDo", Date.from(Instant.now())),
        Todo(1, "FirstToDo", Date.from(Instant.now())),
        Todo(1, "FirstToDo", Date.from(Instant.now())),
        Todo(1, "FirstToDo", Date.from(Instant.now())),
        Todo(1, "FirstToDo", Date.from(Instant.now())),
    );
}
