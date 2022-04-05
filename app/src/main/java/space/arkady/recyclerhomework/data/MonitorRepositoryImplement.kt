package space.arkady.recyclerhomework.data

import space.arkady.recyclerhomework.domain.domain.MonitorRepository
import space.arkady.recyclerhomework.domain.domain.models.BrandMonitor
import space.arkady.recyclerhomework.domain.domain.models.Monitor

object MonitorRepositoryImplement : MonitorRepository {

    private val monitorList = listOf<Monitor>(
        Monitor(BrandMonitor.LG, "29WP60G-B", 29, 2560 - 1080),
        Monitor(BrandMonitor.LG, "32GN600-B", 32, 2560 - 1440),
        Monitor(BrandMonitor.LG, "27GN950-B", 27, 3840 - 2160),
        Monitor(BrandMonitor.GIGABYTE, "G27Q", 27, 2560 - 1440),
        Monitor(BrandMonitor.DELL, "S2722DGM", 27, 2560 - 1440),
        Monitor(BrandMonitor.DELL, "S3222DGM", 32, 2560 - 1440),
        Monitor(BrandMonitor.GIGABYTE, "M28U", 28, 3840 - 2160),
        Monitor(BrandMonitor.ACER, "Predator X38", 37, 3840 - 1600),
        Monitor(BrandMonitor.SAMSUNG, "Odyssey Neo G9", 49, 5120 - 1440)
    )

    override fun getMonitorList(): List<Monitor> {
        return monitorList
    }
}