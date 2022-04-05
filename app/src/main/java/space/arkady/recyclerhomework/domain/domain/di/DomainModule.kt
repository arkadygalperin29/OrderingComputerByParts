package space.arkady.recyclerhomework.domain.domain.di

import org.koin.dsl.module
import space.arkady.recyclerhomework.data.GraphicCardRepositoryImplement
import space.arkady.recyclerhomework.data.MonitorRepositoryImplement
import space.arkady.recyclerhomework.data.OperationSystemRepositoryImplement
import space.arkady.recyclerhomework.domain.domain.*
import space.arkady.recyclerhomework.domain.domain.interactor.CommonInteractor
import space.arkady.recyclerhomework.domain.domain.models.CommonItem

val domainModule = module {
/*    val q1 = qualifier("OperationSystem")
    val q2 = qualifier("Monitor")
    val q3 = qualifier("GraphicCard")*/

    factory<CommonInteractor<CommonItem>>() {
        OperationSystemInteractorImplement(
            get()
        )
        MonitorInteractorImplement(
            get()
        )
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
