class aaa{

    var name: String = ""
        get() = "이름은 $field"
        set(value) {
            println("이름을 $value 로 바꿈")
            field = value
        }
}

class bbb {
    var nickName: String = ""
}


class ccc {
    var aa = "aa"
    var bb = "bb"
    var cc = "cc"
}

data class ddd (
    var aa: String = "aa",
    var bb: String = "bb",
    var cc: String = "cc"
)

fun main() {
    val a = aaa()

    val b = bbb()

    println(a.name)
    a.name = "원숭이"
    println(a.name)

    println(b)

    println("\nccc---")
    ccc::class.java.declaredMethods.forEach { println(it.name) }
    println("\nddd---")
    ddd::class.java.declaredMethods.forEach { println(it.name) }

}
