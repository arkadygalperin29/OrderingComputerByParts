package space.arkady.recyclerhomework.domain.domain.di

import org.koin.dsl.module
import space.arkady.recyclerhomework.data.GraphicCardRepositoryImplement
import space.arkady.recyclerhomework.data.MonitorRepositoryImplement
import space.arkady.recyclerhomework.data.OperationSystemRepositoryImplement
import space.arkady.recyclerhomework.domain.domain.*
import space.arkady.recyclerhomework.domain.domain.repositories.GraphicCardRepository
import space.arkady.recyclerhomework.domain.domain.repositories.MonitorRepository
import space.arkady.recyclerhomework.domain.domain.repositories.OperationSystemRepository

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
