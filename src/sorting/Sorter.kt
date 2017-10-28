package sorting

interface Sorter {
    fun <T : Comparable<T>> ascendingSort(list: MutableList<T>): List<T>

    fun <T : Comparable<T>> descendingSort(list: MutableList<T>): List<T>
}