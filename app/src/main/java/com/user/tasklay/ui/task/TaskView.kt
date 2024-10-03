package com.user.tasklay.ui.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.user.tasklay.theme.LightRed
import com.user.tasklay.theme.OffWhiteYellow
import com.user.tasklay.theme.PurpleGrey40
import com.user.tasklay.theme.Typography

@Composable
fun TaskView(taskTitle: String, dueDate: String, daysLeft: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {

            Text(
                modifier = Modifier.padding(vertical = 7.dp),
                text = taskTitle,
                color = LightRed,
                style = Typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            HorizontalDivider(
                modifier = Modifier.padding(bottom = 10.dp),
                thickness = 1.dp, color = OffWhiteYellow)

            Row(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Due date",
                    style = Typography.labelSmall,
                    color = PurpleGrey40
                )
                Text(
                    text = "Days left",
                    style = Typography.labelSmall,
                    color = PurpleGrey40
                )

            }
            Row(
                modifier = Modifier.padding(vertical = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = dueDate,
                    color = LightRed,
                    style = Typography.titleLarge,
                )

                Text(
                    text = daysLeft,
                    color = LightRed,
                    style = Typography.titleLarge,
                )
            }
        }
    }
}