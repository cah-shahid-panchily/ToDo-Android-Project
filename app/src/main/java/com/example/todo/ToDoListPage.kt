package com.example.todo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import  androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun ToDoListPage(viewModel: ToDoViewModel) {
    val todoList by viewModel.todoList.observeAsState()
    var inputText by remember {
        mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(value = inputText, onValueChange = { newText ->
                inputText = newText
            })
            Button(onClick = {
         viewModel.addToDo(inputText)
                inputText = ""
            }) {
                Text(text = "Add")
            }
        }
        todoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it) { _: Int, item: Todo ->
                        toDoItem(item = item, onDelete = {
                            viewModel.deleteToDo(item.id)
                        })
                    }
                }
            )
        }?: Text(
            text = "No item available"
        )
    }
}


@Composable
fun toDoItem(item: Todo,onDelete : () -> Unit) {
    val customColor1 = Color(0xFFD4D4D4)
    val customColor2 = Color(0xFF355E3B)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(customColor1)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) { // Row Space
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = SimpleDateFormat("HH:mm:aa, dd/mm", Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = customColor2
            )
            Text(
                text = item.titles,
                fontSize = 20.sp,
                color = customColor2
            )
        }
        IconButton(onClick = onDelete) {
            Icon(
                painter = painterResource(id = R.drawable.ic_delete_24),
                contentDescription = "Delete",
                tint = Color.Red
            )
        }
        }
    }
