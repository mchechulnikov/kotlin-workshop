package sorting

class InsertionSorter : Sorter {
    override fun <T : Comparable<T>> ascendingSort(list: MutableList<T>): List<T> {
        return sort(list, { element, selectedElement -> element.compareTo(selectedElement) > 0 })
    }

    override fun <T : Comparable<T>> descendingSort(list: MutableList<T>): List<T> {
        return sort(list, { element, selectedElement -> element.compareTo(selectedElement) < 0 })
    }

    private fun <T> sort(list: MutableList<T>, compareFunction: (T, T) -> Boolean): List<T> {
        for ((index, item) in list.withIndex()) {
            val selectedElement = item
            var innerIndex = index
            while (innerIndex > 0 && compareFunction(list[innerIndex - 1], selectedElement)) {
                list[innerIndex] = list[innerIndex - 1]
                innerIndex -= 1
            }
            list[innerIndex] = selectedElement
        }
        return list
    }
}

