package space.arkady.recyclerhomework.domain.models

data class GraphicCard(
    val brand: BrandGraphicCard,
    val series: String,
    val number: Int,
    val postfix: String? = ""
)
