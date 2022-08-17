package space.arkady.recyclerhomework.domain.di

import org.koin.dsl.module
import space.arkady.recyclerhomework.data.GraphicCardRepositoryImplement
import space.arkady.recyclerhomework.data.MonitorRepositoryImplement
import space.arkady.recyclerhomework.data.OperationSystemRepositoryImplement
import space.arkady.recyclerhomework.domain.repository.GraphicCardRepository
import space.arkady.recyclerhomework.domain.repository.MonitorRepository
import space.arkady.recyclerhomework.domain.repository.OperationSystemRepository
import space.arkady.recyclerhomework.domain.*

val domainModule = module {

    single<OperationSystemInteractor> {
        OperationSystemInteractorImplement(
            get()
        )
    }
    single<MonitorInteractor> {
        MonitorInteractorImplement(
            get()
        )
    }
    single<GraphicCardInteractor> {
        GraphicCardInteractorImplement(
            get()
        )
    }
    single<OperationSystemRepository> {
        OperationSystemRepositoryImplement
    }
    single<MonitorRepository> {
        MonitorRepositoryImplement
    }
    single<GraphicCardRepository> {
        GraphicCardRepositoryImplement
    }
}
