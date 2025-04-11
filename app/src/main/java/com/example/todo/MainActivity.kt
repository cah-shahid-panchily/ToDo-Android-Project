package com.example.todo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.todo.ui.theme.ToDoTheme
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            ToDoTheme {
                // Use Surface inside `setContent`
                Surface (
                    modifier = Modifier.fillMaxSize(), // Adjust size as needed
                    color = MaterialTheme.colorScheme.background          // Background color for Surface
                ) {
                  ToDoListPage(toDoViewModel)
                }

            }
        }
    }

    override fun onPause() {
        super.onPause()
        TOAS
    }
}


