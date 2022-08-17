package space.arkady.recyclerhomework.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import space.arkady.recyclerhomework.presentation.ui.fragment.graphicsCardFragment.GraphicCardViewModel
import space.arkady.recyclerhomework.presentation.ui.fragment.monitorFragment.MonitorViewModel
import space.arkady.recyclerhomework.presentation.ui.fragment.operationSystem.OperationSystemViewModel
import space.arkady.recyclerhomework.presentation.ui.SharedViewModel

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