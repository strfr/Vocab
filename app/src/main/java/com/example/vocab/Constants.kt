package com.example.vocab

import java.util.*
import kotlin.collections.ArrayList


object Constants {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    private var randomNumber: Int = 0
    private var integerList: MutableList<Int>? = null
    private fun getRandomNumber(): Int {
        val rand = Random()
        randomNumber = rand.nextInt(20)
        if (integerList?.contains(randomNumber) == true) {
            getRandomNumber()
        } else {
            integerList?.add(randomNumber)
        }
        return randomNumber
    }

    private fun questionShuffle(question: Question): Question {
        val answer = question.optionOne
        val opArray = arrayOf(
            question.optionOne,
            question.optionTwo,
            question.optionThree,
            question.optionFour
        )
        opArray.shuffle()
        val ansIndex = opArray.indexOf(answer)

        return Question(
            question.id,
            question.question,
            opArray[0],
            opArray[1],
            opArray[2],
            opArray[3],
            ansIndex + 1
        )
    }

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val words = getWords()
        for (i in 1..10) {
            val index = getRandomNumber()
            val op1 = getRandomNumber()
            val op2 = getRandomNumber()
            val op3 = getRandomNumber()
            val que = Question(
                i,
                words[index].definition,
                words[index].word,
                words[op1].word,
                words[op2].word,
                words[op3].word,
                1
            )
            questionsList.add(questionShuffle(que))
        }
        return questionsList

    }

    fun getWords(): ArrayList<Words> {
        val words = ArrayList<Words>()
        words.let {
            it.add(
                Words(
                    "word",
                    "noun",
                    "[countable] a single unit of language that means something and can be spoken or written",
                    "Do not write more than 200 words.",
                    true,
                    "phrase",
                    false,
                    ""
                )
            )
            it.add(
                Words(
                    "ability",
                    "noun",
                    "[singular] ability to do something the fact that somebody/something is able to do something",
                    "People with the disease may lose their ability to communicate.",
                    true,
                    "capability",
                    false,
                    ""
                )
            )
            it.add(
                Words(
                    "baby", "noun", "a very young child or animal",
                    "The baby's crying!", true, "newborn", false, ""
                )
            )
            it.add(
                Words(
                    "cable",
                    "noun",
                    "[countable, uncountable] a set of wires, covered in plastic or rubber, that carries electricity, phone signals, etc.",
                    "Connect the cable to the correct terminal.",
                    true,
                    "cord",
                    false,
                    ""
                )
            )
            it.add(
                Words(
                    "damage",
                    "noun",
                    " [uncountable] physical harm caused to something which makes it less attractive, useful or valuable",
                    "The building suffered extensive damage by fire in 1925.",
                    true,
                    "harm",
                    true,
                    "benefit"
                )
            )
            it.add(
                Words(
                    "earth",
                    "noun",
                    "[uncountable, singular] the world; the planet that we live on",
                    "The earth revolves around the sun.",
                    true,
                    "world",
                    false,
                    ""
                )
            )
            it.add(
                Words(
                    "facility",
                    "noun",
                    " [plural] buildings, services, equipment, etc. that are provided for a particular purpose",
                    "The school is upgrading its outdoor play facilities.",
                    true,
                    "amenity",
                    false,
                    ""
                )
            )
            it.add(
                Words(
                    "gang", "noun", "an organized group of criminals",
                    "A four-man gang carried out the robbery.", true, "bunch", false, ""
                )
            )
            it.add(
                Words(
                    "habit",
                    "noun",
                    "[countable] a thing that you do often and almost without thinking, especially something that is hard to stop doing",
                    "Most of us have some undesirable habits.",
                    true,
                    "tendency",
                    false,
                    ""
                )
            )
            it.add(
                Words(
                    "idea",
                    "noun",
                    "[countable] a plan, thought or suggestion, especially about what to do in a particular situation",
                    "That's a great idea!",
                    true,
                    "plan",
                    false,
                    ""
                )
            )


            it.add(
                Words(
                    "abandon",
                    "verb",
                    "cease to support or look after (someone); desert.",
                    "her natural mother had abandoned her at an early age.",
                    true,
                    "leave",
                    true,
                    "keep"
                )
            )
            it.add(
                Words(
                    "bait",
                    "verb",
                    "to prepare (a hook or trap) with bait.",
                    "her natural mother had abandoned her at an early age.",
                    true,
                    "heckle",
                    false,
                    ""
                )
            )
            it.add(
                Words(
                    "climb",
                    "verb",
                    "to go up or ascend, especially by using the hands and feet or feet only",
                    "to climb up a ladder.",
                    true,
                    "ascend",
                    true,
                    "descend"
                )
            )
            it.add(
                Words(
                    "dig",
                    "verb",
                    "to break up, turn over, or remove earth, sand, etc., as with a shovel, spade, bulldozer, or claw; make an excavation.",
                    "the boar had been digging for roots",
                    true,
                    "cultivate",
                    true,
                    "compliment"
                )
            )
            it.add(
                Words(
                    "enrich",
                    "verb",
                    "to supply with riches, wealth, abundant or valuable possessions, etc.:",
                    "Commerce enriches a nation.",
                    true,
                    "elevate",
                    true,
                    "decrease"
                )
            )
            it.add(
                Words(
                    "feed", "verb", "to give food to; supply with nourishment:",
                    "to feed a child.", true, "nourish", true, "starve"
                )
            )
            it.add(
                Words(
                    "eat",
                    "verb",
                    "to take into the mouth and swallow for nourishment; chew and swallow (food).",
                    "We'll eat at six o'clock.",
                    true,
                    "bite",
                    true,
                    "abstain"
                )
            )
            it.add(
                Words(
                    "gain",
                    "verb",
                    "to get (something desired), especially as a result of one's efforts",
                    "to gain possession of an object; to gain permission to enter a country.",
                    true,
                    "procure",
                    true,
                    "lose"
                )
            )
            it.add(
                Words(
                    "heal",
                    "verb",
                    "to make healthy, whole, or sound; restore to health; free from ailment.",
                    "They tried to heal the rift between them but were unsuccessful.",
                    true,
                    "compose",
                    true,
                    "irritate"
                )
            )
            it.add(
                Words(
                    "jam",
                    "verb",
                    "to press, squeeze, or wedge tightly between bodies or surfaces, so that motion or extrication is made difficult or impossible:",
                    "The ship was jammed between two rocks.",
                    true,
                    "bind",
                    true,
                    "boon"
                )
            )

            it.add(
                Words(
                    "easily", "adverb", "in an easy manner; with ease; without trouble:",
                    "The traffic moved along easily.", true, "certainly", true, "hardly"
                )
            )
            it.add(
                Words(
                    "nearly", "adverb", "all but; almost:",
                    "nearly dead with cold.", true, "closely", false, ""
                )
            )
            it.add(
                Words(
                    "fortunately ", "adverb", "by good fortune or luck",
                    "Fortunately, no one was hurt.", true, "luckily", true, "unfortunately"
                )
            )
            it.add(
                Words(
                    "easily", "adverb", "in an easy manner; with ease; without trouble:",
                    "The traffic moved along easily.", true, "certainly", true, "hardly"
                )
            )
            it.add(
                Words(
                    "easily", "adverb", "in an easy manner; with ease; without trouble:",
                    "The traffic moved along easily.", true, "certainly", true, "hardly"
                )
            )
            it.add(
                Words(
                    "easily", "adverb", "in an easy manner; with ease; without trouble:",
                    "The traffic moved along easily.", true, "certainly", true, "hardly"
                )
            )
            it.add(
                Words(
                    "easily", "adverb", "in an easy manner; with ease; without trouble:",
                    "The traffic moved along easily.", true, "certainly", true, "hardly"
                )
            )
            it.add(
                Words(
                    "easily", "adverb", "in an easy manner; with ease; without trouble:",
                    "The traffic moved along easily.", true, "certainly", true, "hardly"
                )
            )
            it.add(
                Words(
                    "easily", "adverb", "in an easy manner; with ease; without trouble:",
                    "The traffic moved along easily.", true, "certainly", true, "hardly"
                )
            )
            it.add(
                Words(
                    "easily", "adverb", "in an easy manner; with ease; without trouble:",
                    "The traffic moved along easily.", true, "certainly", true, "hardly"
                )
            )
        }
        return words
    }
}