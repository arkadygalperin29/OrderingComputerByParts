package space.arkady.recyclerhomework.presentation.recycler.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder.GraphicCardViewModel
import space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder.MonitorViewModel
import space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem.OperationSystemViewModel
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModel

val viewModelModule = module {
    viewModel {
        SharedViewModel()
    }
    viewModel {
        GraphicCardViewModel(
            get()
        )
    }
    viewModel {
        MonitorViewModel(
            get()
        )
    }
    viewModel {
        OperationSystemViewModel(
            get()
        )
    }
}