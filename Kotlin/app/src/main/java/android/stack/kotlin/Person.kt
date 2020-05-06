package android.stack.kotlin

/**
 * Created on 2020/5/6 13:49
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
data class Person(val name: String, val age: Int? = null) {


}

fun main(args: Array<String>) {
    val persons = listOf(Person("ZHANG", 20), Person("YOU"))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("Oldest is  $oldest")
    print(max(1,2))
}

fun max(a: Int, b: Int): Int = if (a > b) a else b