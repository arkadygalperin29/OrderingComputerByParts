package space.arkady.recyclerhomework.domain.domain.interactor

interface CommonInteractor<T> {
fun getItem(): List<T>
}