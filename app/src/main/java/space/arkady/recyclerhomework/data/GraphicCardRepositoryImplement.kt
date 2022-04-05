package space.arkady.recyclerhomework.data

import space.arkady.recyclerhomework.domain.domain.GraphicCardRepository
import space.arkady.recyclerhomework.domain.domain.models.BrandGraphicCard
import space.arkady.recyclerhomework.domain.domain.models.GraphicCard

object GraphicCardRepositoryImplement : GraphicCardRepository {

    private val graphicCardList = listOf<GraphicCard>(
        GraphicCard(BrandGraphicCard.AMD, "XT", 6900 ),
        GraphicCard(BrandGraphicCard.NVIDIA, "RTX", 3090 ),
        GraphicCard(BrandGraphicCard.NVIDIA, "RTX", 3080 ),
        GraphicCard(BrandGraphicCard.NVIDIA, "LHR", 3080 ),
        GraphicCard(BrandGraphicCard.NVIDIA, "RTX", 3070, "Ti"),
        GraphicCard(BrandGraphicCard.NVIDIA, "RTX", 2080, "Ti"),
        GraphicCard(BrandGraphicCard.NVIDIA, "RTX", 2070 ),
        GraphicCard(BrandGraphicCard.NVIDIA, "GTX", 1080 ),
        GraphicCard(BrandGraphicCard.NVIDIA, "RTX", 2060 ),
        GraphicCard(BrandGraphicCard.NVIDIA, "GTX", 1660, "Ti")
    )

    override fun getGraphicCardList(): List<GraphicCard> {
        return graphicCardList
    }
}