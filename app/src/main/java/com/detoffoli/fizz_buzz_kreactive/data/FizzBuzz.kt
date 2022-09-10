package com.detoffoli.fizz_buzz_kreactive.data

data class FizzBuzz(
    val number1: Number,
    val number2: Number,
    val word1: String,
    val word2: String,
    val limit: Number,
) {
    fun getStrListResult(): ArrayList<String> {
        val listString = arrayListOf<String>()
        for (i in 1..this.limit.toInt()) {
            var value = ""
            if (i % this.number1.toInt() == 0)
                value += this.word1
            if (i % this.number2.toInt() == 0)
                value += this.word2
            if (value.isEmpty())
                value = i.toString()
            listString.add("$i : $value")
        }
        return listString
    }
}
