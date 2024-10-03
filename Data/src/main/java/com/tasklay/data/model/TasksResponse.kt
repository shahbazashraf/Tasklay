package com.tasklay.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TasksResponse(
    val tasks: List<Task>
):Parcelable

@Parcelize
data class Task(
    @SerializedName("id")
    val id: String,
    @SerializedName("TargetDate")
    val targetDate: String,
    @SerializedName("DueDate")
    val dueDate: String?,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Description")
    val description: String,
    @SerializedName("Priority")
    val priority: Int
) :Parcelable
