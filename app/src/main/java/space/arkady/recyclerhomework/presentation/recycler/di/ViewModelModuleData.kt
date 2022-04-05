package space.arkady.recyclerhomework.presentation.recycler.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModelData

val viewModelModuleData = module {
    viewModel<SharedViewModelData> {
        SharedViewModelData(interactor = get())
    }
}