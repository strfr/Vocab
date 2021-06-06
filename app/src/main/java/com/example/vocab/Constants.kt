package com.example.vocab

import android.content.Context
import android.util.Log
import java.util.*
import kotlin.collections.ArrayList


object Constants {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    private var randomNumber: Int = 0
    private var integerList: MutableList<Int>? = null
    private fun getRandomNumber(): Int {
        val rand = Random()
        randomNumber = rand.nextInt(50)
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

    fun getQuestions(context: Context, selected: String?): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val dbHelper = DBHelper(context)
        val words = dbHelper.readData()
        for (i in 1..10) {
            var index = getRandomNumber()
            if (selected != null) {
                Log.e("sda", selected)
            }
            while (words[index].type != selected){
                index = getRandomNumber()
                Log.e("asda","asdas")
            }
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
                    0,
                    "word",
                    "noun",
                    "[countable] a single unit of language that means something and can be spoken or written",
                    "Do not write more than 200 words.",
                    1,
                    "phrase",
                    0,
                    "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "ability",
                    "noun",
                    "[singular] ability to do something the fact that somebody/something is able to do something",
                    "People with the disease may lose their ability to communicate.",
                    1,
                    "capability",
                    0,
                    "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "baby", "noun", "a very young child or animal",
                    "The baby's crying!", 1, "newborn", 0, "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "cable",
                    "noun",
                    "[countable, uncountable] a set of wires, covered in plastic or rubber, that carries electricity, phone signals, etc.",
                    "Connect the cable to the correct terminal.",
                    1,
                    "cord",
                    0,
                    "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "damage",
                    "noun",
                    " [uncountable] physical harm caused to something which makes it less attractive, useful or valuable",
                    "The building suffered extensive damage by fire in 1925.",
                    1,
                    "harm",
                    1,
                    "benefit", 0
                )
            )
            it.add(
                Words(
                    0,
                    "earth",
                    "noun",
                    "[uncountable, singular] the world; the planet that we live on",
                    "The earth revolves around the sun.",
                    1,
                    "world",
                    0,
                    "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "facility",
                    "noun",
                    " [plural] buildings, services, equipment, etc. that are provided for a particular purpose",
                    "The school is upgrading its outdoor play facilities.",
                    1,
                    "amenity",
                    0,
                    "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "gang", "noun", "an organized group of criminals",
                    "A four-man gang carried out the robbery.", 1, "bunch", 0, "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "habit",
                    "noun",
                    "[countable] a thing that you do often and almost without thinking, especially something that is hard to stop doing",
                    "Most of us have some undesirable habits.",
                    1,
                    "tendency",
                    0,
                    "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "idea",
                    "noun",
                    "[countable] a plan, thought or suggestion, especially about what to do in a particular situation",
                    "That's a great idea!",
                    1,
                    "plan",
                    0,
                    "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "abandon",
                    "verb",
                    "cease to support or look after (someone); desert.",
                    "her natural mother had abandoned her at an early age.",
                    1,
                    "leave",
                    1,
                    "keep", 0
                )
            )
            it.add(
                Words(
                    0,
                    "bait",
                    "verb",
                    "to prepare (a hook or trap) with bait.",
                    "her natural mother had abandoned her at an early age.",
                    1,
                    "heckle",
                    0,
                    "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "climb",
                    "verb",
                    "to go up or ascend, especially by using the hands and feet or feet only",
                    "to climb up a ladder.",
                    1,
                    "ascend",
                    1,
                    "descend", 0
                )
            )
            it.add(
                Words(
                    0,
                    "dig",
                    "verb",
                    "to break up, turn over, or remove earth, sand, etc., as with a shovel, spade, bulldozer, or claw; make an excavation.",
                    "the boar had been digging for roots",
                    1,
                    "cultivate",
                    1,
                    "compliment", 0
                )
            )
            it.add(
                Words(
                    0,
                    "enrich",
                    "verb",
                    "to supply with riches, wealth, abundant or valuable possessions, etc.:",
                    "Commerce enriches a nation.",
                    1,
                    "elevate",
                    1,
                    "decrease", 0
                )
            )
            it.add(
                Words(
                    0,
                    "feed", "verb", "to give food to; supply with nourishment:",
                    "to feed a child.", 1, "nourish", 1, "starve", 0
                )
            )
            it.add(
                Words(
                    0,
                    "eat",
                    "verb",
                    "to take into the mouth and swallow for nourishment; chew and swallow (food).",
                    "We'll eat at six o'clock.",
                    1,
                    "bite",
                    1,
                    "abstain", 0
                )
            )
            it.add(
                Words(
                    0,
                    "gain",
                    "verb",
                    "to get (something desired), especially as a result of one's efforts",
                    "to gain possession of an object; to gain permission to enter a country.",
                    1,
                    "procure",
                    1,
                    "lose", 0
                )
            )
            it.add(
                Words(
                    0,
                    "heal",
                    "verb",
                    "to make healthy, whole, or sound; restore to health; free from ailment.",
                    "They tried to heal the rift between them but were unsuccessful.",
                    1,
                    "compose",
                    1,
                    "irritate", 0
                )
            )
            it.add(
                Words(
                    0,
                    "jam",
                    "verb",
                    "to press, squeeze, or wedge tightly between bodies or surfaces, so that motion or extrication is made difficult or impossible:",
                    "The ship was jammed between two rocks.",
                    1,
                    "bind",
                    1,
                    "boon", 0
                )
            )
            it.add(
                Words(
                    0,
                    "easily", "adverb", "in an easy manner; with ease; without trouble:",
                    "The traffic moved along easily.", 1, "certainly", 1, "hardly", 0
                )
            )
            it.add(
                Words(
                    0,
                    "nearly", "adverb", "all but; almost:",
                    "nearly dead with cold.", 1, "closely", 0, "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "fortunately ", "adverb", "by good fortune or luck",
                    "Fortunately, no one was hurt.", 1, "luckily", 1, "unfortunately", 0
                )
            )
            it.add(
                Words(
                    0,
                    "Clumsily", "adverb", "in a way that is not smooth or steady or careful",
                    "She stumbled clumsily down the dark hallway.", 1, "awkwardly", 1, "adroitly", 0
                )
            )
            it.add(
                Words(
                    0,
                    "slowly", "adverb", "at a slow speed; not quickly",
                    "Please could you speak more slowly?", 1, "steadily", 1, "fastly", 0
                )
            )
            it.add(
                Words(
                    0,
                    "sadly", "adverb", "in a sad way",
                    "‘I'm so sorry,’ she said sadly.", 1, "wistfully", 1, "happily", 0
                )
            )
            it.add(
                Words(
                    0,
                    "warmly",
                    "adverb",
                    "in a way that keeps you warm",
                    "They were warmly dressed in coats and scarves.",
                    1,
                    "ardently",
                    1,
                    "grudgingly",
                    0
                )
            )
            it.add(
                Words(
                    0,
                    "diligently",
                    "adverb",
                    "in a way that shows care and effort in your work or duties",
                    "They worked diligently on the task they had been given.",
                    1,
                    "hurriedly",
                    1,
                    "idly",
                    0
                )
            )
            it.add(
                Words(
                    0,
                    "badly", "adverb", "without skill or care",
                    "to play/sing badly", 1, "awkwardly", 1, "well", 0
                )
            )
            it.add(
                Words(
                    0,
                    "hourly ", "adverb", "every hour",
                    "Reapply sunscreen hourly and after swimming.", 0, "certainly", 0, "hardly", 0
                )
            )



            it.add(
                Words(
                    0,
                    "a hot potato",
                    "Phrases and Idioms",
                    "a controversial issue or situation that is awkward or unpleasant to deal with.",
                    "The subject of bullying and fighting in my school is a hot potato.",
                    0,
                    "",
                    0,
                    "",
                    0
                )
            )
            it.add(
                Words(
                    0,
                    "piece of cake",
                    "Phrases and Idioms",
                    "something that is easy to do",
                    "Learning English is a piece of cake as long as you do it with our website.",
                    0,
                    "",
                    0,
                    "",
                    0
                )
            )
            it.add(
                Words(
                    0,
                    "once in a blue moon ",
                    "Phrases and Idioms",
                    "very rarely",
                    "I go to visit my grandfather only once in a blue moon; he lives in a remote",
                    0,
                    "",
                    0,
                    "",
                    0
                )
            )
            it.add(
                Words(
                    0,
                    "by hook or by crook ",
                    "Phrases and Idioms",
                    "by any possible means",
                    "The farmer will not sell us the land. By hook or by crook, he is hanging on to it.",
                    0,
                    "",
                    0,
                    "",
                    0
                )
            )
            it.add(
                Words(
                    0,
                    "call the shots ", "Phrases and Idioms", "to be in charge of what is happening and what should happen",
                    "The policeman is the one who will call the shots during the political gatherings.", 0,
                    "", 0, "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "green thumb ", "Phrases and Idioms", "good gardening results",
                    "My mother has green fingers. She can grow just about anything in the garden.",
                    0, "", 0, "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "hit the roof ", "Phrases and Idioms", "experience sudden anger",
                    "Jake's parents are going to hit the roof when they see the damage he's done to their car.",
                    0, "", 0, "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "lone it ", "Phrases and Idioms", "to do an activity alone",
                    "They asked him to go to the movies, but he decided to lone it.",
                    0, "", 0, "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "zip your lip ", "Phrases and Idioms", "to stop talking",
                    "I don't want to hear another sound out of you. Now do as you're told and zip your lip.",
                    0, "", 0, "", 0
                )
            )
            it.add(
                Words(
                    0,
                    "apple of eye ", "Phrases and Idioms", "someone very precious or dear",
                    "Every kid in the world is the apple of their parents' eye(s).", 0,
                    "", 0, "", 0
                )
            )



            it.add(
                Words(
                    0,
                    "happy", "adjectives", "feeling or showing pleasure; pleased",
                    "You don't look very happy today.", 1,
                    "pleased", 1, "sad", 0
                )
            )
            it.add(
                Words(
                    0,
                    "sad", "adjectives", "unhappy or showing unhappiness",
                    "She looked sad and tired.", 1,
                    "bitter", 1, "happy", 0
                )
            )
            it.add(
                Words(
                    0,
                    "beautiful", "adjectives", " having beauty; giving pleasure to the senses or to the mind",
                    "She looked stunningly beautiful that night.", 1,
                    "pretty", 1, "ugly", 0
                )
            )
            it.add(
                Words(
                    0,
                    "ugly", "adjectives", "unpleasant to look at",
                    "The witch was hideously ugly.", 1,
                    "awful", 1, "beautiful", 0
                )
            )
            it.add(
                Words(
                    0,
                    "gross", "adjectives", " being the total amount of something before anything is taken away",
                    "Investments showed a gross profit of 26 per cent.", 1,
                    "great", 1, "insignificant", 0
                )
            )
            it.add(
                Words(
                    0,
                    "insignificant", "adjectives", "not big or valuable enough to be considered important",
                    "These results are statistically insignificant.", 1,
                    "inconsequential", 1, "gross", 0
                )
            )
            it.add(
                Words(
                    0,
                    "cool", "adjectives", "fairly cold; not hot or warm",
                    "Cooler weather is forecast for the weekend.", 1,
                    "cold", 1, "hot", 0
                )
            )
            it.add(
                Words(
                    0,
                    "hot", "adjectives", "having a high temperature; producing heat",
                    "It's hot today, isn't it?", 1,
                    "blazing", 1, "cold", 0
                )
            )
            it.add(
                Words(
                    0,
                    "long", "adjectives", "measuring or covering a great length or distance, or a greater length or distance than usual",
                    "He walked down the long corridor.", 1,
                    "great", 1, "short", 0
                )
            )
            it.add(
                Words(
                    0,
                    "short", "adjectives", "measuring or covering a small length or distance, or a smaller length or distance than usual",
                    "He had short curly hair.", 1,
                    "abbreviated", 1, "tall", 0
                )
            )

        }
        return words
    }
}