package com.tasklay.data.module

import com.tasklay.data.domain.FetchTasksUseCase
import com.tasklay.data.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun fetchTasksUseCase(taskRepository: TaskRepository): FetchTasksUseCase {
        return FetchTasksUseCase(taskRepository)
    }
}