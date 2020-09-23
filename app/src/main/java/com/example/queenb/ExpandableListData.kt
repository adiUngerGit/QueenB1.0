package com.example.queenb

internal object ExpandableListData {
    val data: HashMap<String, List<String>>
        get() {
            val expandableListDetail =
                HashMap<String, List<String>>()
            val city: MutableList<String> = ArrayList()
            city.add("ירושלים")
            city.add("חיפה")
            city.add("תל אביב")

            val age: MutableList<String> = ArrayList()
            age.add("י'")
            age.add("י\"א")
            age.add("י\"ב")

            expandableListDetail["מוקד"] = city
            expandableListDetail["כיתה"] = age
            return expandableListDetail
        }
}