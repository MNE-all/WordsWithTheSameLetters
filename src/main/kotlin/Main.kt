import java.util.*

class Word(word: String){
    val letters: String = word
    var composition: MutableMap<Char, Int> = mutableMapOf()
    init {
        val dictionary = mutableSetOf<Char>()
        dictionary.addAll(letters.toList())
        for (letter in dictionary){
            composition[letter] = Collections.frequency(letters.toList(), letter)
        }
    }
}

fun main() {
    val words: MutableList<Word> = arrayListOf()
    println("Программа для нахождения слов, состоящих из одинаковых букв")
    print("Введите слова через пробел: ")
    val userInput = readln().split(" ")
    for (word in userInput) {
        words.add(Word(word))
    }
    val result = words.groupBy { it.composition }
    for (group in result){
        for (word in group.value) print("${word.letters} ")
        println()
    }
}