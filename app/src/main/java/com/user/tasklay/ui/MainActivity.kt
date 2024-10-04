package com.user.tasklay.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.user.tasklay.theme.TasklayTheme
import com.user.tasklay.ui.task.TaskListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasklayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskListScreen(innerPadding)
                }
            }
        }
    }
}

