package sorting

class BubbleSorter : Sorter {
    override fun <T : Comparable<T>> ascendingSort(list: MutableList<T>): List<T> {
        return sort(list, { element, selectedElement -> element.compareTo(selectedElement) > 0 })
    }

    override fun <T : Comparable<T>> descendingSort(list: MutableList<T>): List<T> {
        return sort(list, { element, selectedElement -> element.compareTo(selectedElement) < 0 })
    }

    private fun <T> sort(list: MutableList<T>, compareFunction: (T, T) -> Boolean): List<T> {
        var index1 = 0
        while (index1 < list.count())
        {
            var index2 = 0
            while (index2 < list.count() - 1)
            {
                if (compareFunction(list[index2], list[index2 + 1]))
                {
                    swap(index2, list)
                }
                index2 += 1
            }
            index1 += 1
        }
        return list
    }

    private fun <T> swap(index2: Int, list: MutableList<T>) {
        var temp: T = list[index2]
        list[index2] = list[index2 + 1]
        list[index2 + 1] = temp
    }
}