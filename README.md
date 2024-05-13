# QuizApp

QuizApp to prosta aplikacja quizowa, która pozwala użytkownikowi odpowiadać na pytania i sprawdzać swoje odpowiedzi.

## Pliki Klas

### Question

`Question` to klasa reprezentująca pojedyncze pytanie w quizie.

#### Pola

- `question`: String - Treść pytania.
- `options`: Array<String> - Tablica zawierająca możliwe odpowiedzi.
- `correctAnswer`: Int - Indeks poprawnej odpowiedzi w tablicy `options`.
- `imageRes`: Int? (opcjonalne) - Zasób obrazu dla pytania (domyślnie null).

### QuestionBank

`QuestionBank` to obiekt zawierający listę pytań do quizu.

#### Pola

- `questions`: Array<Question> - Tablica zawierająca wszystkie pytania w quizie.

## MainActivity

`MainActivity` to główna aktywność aplikacji, która obsługuje logikę quizu i interakcję z użytkownikiem.

#### Pola

- `resultTextView`: TextView - Pole tekstowe wyświetlające wynik quizu.
- `checkButton`: Button - Przycisk służący do sprawdzenia odpowiedzi.
- `correctAnswers`: Int - Liczba poprawnych odpowiedzi.

#### Metody

- `onCreate(savedInstanceState: Bundle?)`: Metoda cyklu życia aktywności, inicjująca interfejs użytkownika i logikę quizu.
