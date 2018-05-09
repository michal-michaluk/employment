Feature: zawieszanie / odwieszanie / zakończenie oświadczenia wzwiązku z warunkami zatrudnienia

  Sprawdzane reguły:
  skladamy na aktualne zatrudnienie
  oświadczenia tylko na podstawowe miejsce pracy
  wymiar etatu

  Scenario: zatrudnienie zostało zakończone
    Given aktualne oświadczenie powązane z zatrudnieniem
    When zatrudnienie zostaje "zakończone"
    Then oświadczenie zmienia status na "zakończone"

  Scenario: semestr letni jeszcze nie rozpoczęty
  # ktos sie zatrudnia w trakcie trwania pierwszego semestru
  # moze lozyc oswiadczenie
  # bedzie sie to wliczas w minimum kadrowe wylącznie w 2. semestrze
    Given zatrudnienie rozpocząte po pierwszym dniu semestru zimowego
    When wprowadz oswiadczenie pierwszego stopnia "Informatyka poz. 1." "30h"
    Then oswiadczenie zostanie złożone ze statusem "zawieszone"

  Scenario: semestr letni rozpoczęty
  # ktos sie zatrudnia w trakcie trwania pierwszego semestru
  # moze lozyc oswiadczenie
  # bedzie sie to wliczas w minimum kadrowe wylącznie w 2. semestrze
    Given zatrudnienie rozpocząte po pierwszym dniu semestru zimowego
    Given oswiadczenie powiązane z zatrudnieniem ma status "zawieszone"
    When rozpoczęcie letniego semestru
    Then oświadczenie zmienia status na "aktualne"

  Scenario: nauczyciel akademicki oswiadcza wylacznie na podstawowe miejsce pracy


  Scenario: profil kierunku: ogolno akademicki
    Given pełny etat w całym okresie
    Then oswiadczenie zostanie złożone
    And oswiadczenie zostanie zawieszone


  Scenario: profil kierunku: praktyczny
    Given 25% etatu w całym okresie
    Then oswiadczenie zostanie złożone
    And oswiadczenie zostanie zawieszone


  Scenario: zmiana etatu w pirtwszym semestrze z 10% na 50%
