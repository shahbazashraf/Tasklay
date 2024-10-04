package com.user.tasklay.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.user.tasklay.R
import com.user.tasklay.theme.LightYellow


@Composable
fun IntroScreen(innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightYellow)
            .padding(bottom = innerPadding.calculateBottomPadding()),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(140.dp)
        )
        
        // Image at the bottom
        Image(
            painter = painterResource(id = R.drawable.intro_illustration),
            contentDescription = "Bottom Image",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(250.dp)
        )
    }
}