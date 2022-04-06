package space.arkady.recyclerhomework.domain.domain.mapper

import space.arkady.recyclerhomework.domain.domain.models.*

fun GraphicCard.toDomainGraphicCard(): DomainGraphicCard {
    return DomainGraphicCard(
        "$brand $series $number $postfix"
    )
}
fun Monitor.toDomainMonitor(): DomainMonitor {
    return DomainMonitor(
        "$brand $model $inches $resolution"
    )
}
fun OperationSystem.toDomainOperationSystem(): DomainOperationSystem {
    return DomainOperationSystem(
        "$name $version"
    )
}