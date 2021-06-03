package com.example.vocab

data class Words(
    var id:Int,
    var word: String,
    var type: String,
    var definition: String,
    var example_sentence: String,
    val isSynonymExists: Int,
    val Synonym: String,
    val isAntonymExists: Int,
    val Antonym: String,
    var isUserAdded: Int
)
