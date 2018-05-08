Feature: zawieszanie / odwieszanie oświadczenia wzwiązku z warunkami zatrudnienia

  Sprawdzane reguły:
  skladamy na aktualne zatrudnienie
  oświadczenia tylko na podstawowe miejsce pracy
  wymiar etatu

  Scenario: zakonczenie zatrudnienia w pierwszym semestrze


  Scenario: semestr letni
  # ktos sie zatrudnia w trakcie trwania pierwszego semestru
  # moze lozyc oswiadczenie
  # bedzie sie to wliczas w minimum kadrowe wylącznie w 2. semestrze

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
