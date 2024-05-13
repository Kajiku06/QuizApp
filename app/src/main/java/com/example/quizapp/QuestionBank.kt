package com.example.quizapp

object QuestionBank {
    val questions = arrayOf(
        Question("Jaka marka auta znajduje się na zdjęciu powyżej?", arrayOf("Audi", "BMW", "Lotus", "TATA"), 1,R.mipmap.bmw),
        Question("Z jakiego państwa pochodzi firma TATA?", arrayOf("Indie", "Niemcy", "Australia", "Stany Zjednoczone"), 0),
        Question("Która marka auta oznacza 'auto dla ludu'?", arrayOf("Fiat", "Porsche", "Opel", "Volkswagen"), 3),
        Question("Która marka nazywa swoje modele od nazw wysp rodzimego kraju?", arrayOf("Kia", "Honda", "Seat", "Hyundai"), 3),
        Question("Która marka aut pochodzi od hiszpańskiego imienia?", arrayOf("Mercedes", "Ford", "Nissan", "Volvo"), 0)
    )
}