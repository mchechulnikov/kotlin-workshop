package sorting

class QuickSorter : Sorter {
    override fun <T : Comparable<T>> ascendingSort(list: MutableList<T>): List<T> {
        return sort(list, { element, selectedElement -> element.compareTo(selectedElement) > 0 })
    }

    override fun <T : Comparable<T>> descendingSort(list: MutableList<T>): List<T> {
        return sort(list, { element, selectedElement -> element.compareTo(selectedElement) < 0 })
    }

    private fun <T> sort(list: MutableList<T>, compareFunction: (T, T) -> Boolean): List<T> {
        var indexBottom = list.indices.first
        var indexTop = list.indices.last
        val pivotIndex = getPivotElementIndex(list)

        do {
            while (!compareFunction(list[indexBottom], list[pivotIndex])) indexBottom += 1
            while (compareFunction(list[indexBottom], list[pivotIndex])) indexTop -= 1

            if (indexBottom <= indexTop) {
                swap(indexBottom, indexTop, list)
                indexBottom += 1
                indexTop -= 1
            }
        } while (indexBottom <= indexTop)

        if (indexTop > 0)
            sort(list.slice(indexTop..list.indices.last).toMutableList(), compareFunction)
        if (list.indices.last > indexBottom)
            sort(list.slice(list.indices.first..indexBottom).toMutableList(), compareFunction)

        return list
    }

    private fun <T> getPivotElementIndex(list: MutableList<T>): Int {
        return list.count() / 2
    }

    private fun <T> swap(index1: Int, index2: Int, list: MutableList<T>) {
        var temp: T = list[index1]
        list[index1] = list[index2]
        list[index2] = temp
    }
}