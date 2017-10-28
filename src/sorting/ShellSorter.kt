package sorting

class ShellSorter : Sorter {
    override fun <T : Comparable<T>> ascendingSort(list: MutableList<T>): List<T> {
        return sort(list, { element, selectedElement -> element.compareTo(selectedElement) > 0 })
    }

    override fun <T : Comparable<T>> descendingSort(list: MutableList<T>): List<T> {
        return sort(list, { element, selectedElement -> element.compareTo(selectedElement) < 0 })
    }

    private fun <T> sort(list: MutableList<T>, compareFunction: (T, T) -> Boolean): List<T> {
        var step = list.count() / 2;
        while (step > 0)
        {
            var i: Int = step
            var j: Int
            while (i < list.count())
            {
                var selectedElement = list[i]
                j = i - step
                while ((j >= 0) && (compareFunction(list[j], selectedElement)))
                {
                    list[j + step] = list[j]
                    j -= step
                }
                list[j + step] = selectedElement;
                i += 1
            }
            step /= 2;
        }
        return list
    }
}