package com.user.tasklay.ui.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tasklay.data.utils.calculateDaysLeft
import com.user.tasklay.R
import com.user.tasklay.theme.LightRed
import com.user.tasklay.theme.LightYellow
import com.user.tasklay.theme.Typography
import com.user.tasklay.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(
    padding: PaddingValues,
    viewModel: TaskViewModel = hiltViewModel()
) {
    val tasks by viewModel.tasks.collectAsState()
    val isLoading by viewModel.loading.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchTasks()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding())
            .background(color = LightYellow)
    ) {

        TaskTitleBar()

        Spacer(modifier = Modifier.height(10.dp))

        if (!isLoading && tasks.isEmpty()) {
            NoTaskForToday()
        } else if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = LightRed)
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(tasks) { task ->
                    TaskView(
                        taskTitle = task.title,
                        dueDate = task.dueDate.orEmpty(),
                        daysLeft = "${calculateDaysLeft(task.targetDate, task.dueDate)}"
                    )
                }
            }
        }
    }
}

@Composable
fun NoTaskForToday() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty_screen),
            contentDescription = "All tasks done",
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.no_task_for_today),
            style = Typography.titleLarge,
            color = Color.White,
            fontSize = 20.sp
        )
    }
}
