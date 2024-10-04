package com.user.tasklay.ui.intro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.user.tasklay.ui.MainActivity
import com.user.tasklay.theme.TasklayTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasklayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IntroScreen(innerPadding)
                }
            }
        }

            lifecycleScope.launch {
                delay(3000L)
                startActivity(Intent(this@IntroActivity, MainActivity::class.java))
                finish()
            }
        }
    }