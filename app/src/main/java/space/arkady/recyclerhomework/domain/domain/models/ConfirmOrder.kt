package space.arkady.recyclerhomework.domain.domain.models

data class ConfirmOrder(
val name: String,
val phone: String,
val operationSystem: BrandOperationSystem,
val graphicCard: BrandGraphicCard,
val monitor: BrandMonitor,
val periphery: String
)
