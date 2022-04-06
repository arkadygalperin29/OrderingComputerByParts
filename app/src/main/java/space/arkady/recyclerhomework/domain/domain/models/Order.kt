package space.arkady.recyclerhomework.domain.domain.models

data class Order(
    val user: User?,
    val domainGraphicCard: DomainGraphicCard?,
    val domainMonitor: DomainMonitor?,
    val domainOperationSystem: DomainOperationSystem?,
    val periphery: Periphery?,
) {

    override fun toString(): String {
        return "Your order:\n" +
                "${user?.name} ${user?.secondName} ${user?.phone}\n" +
                "GraphicsCard: ${domainGraphicCard?.brand}\n" +
                "Monitor: ${domainMonitor?.brand}\n" +
                "OperationSystem: ${domainOperationSystem?.brand}\n" +
                "Accessories:\n" +
                "${periphery?.keyboard} ${periphery?.mouse} ${periphery?.webcam}"
    }
}
