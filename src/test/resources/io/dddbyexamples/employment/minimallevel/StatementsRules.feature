Feature: weryfikacja poprawnosci skladanych oświadczeń w danym roku akademickim

  dwa oswiadczenia na rok akademicki lub jedno
  - jedno na pierwszego stopnia
  - jedno na drugiego stopnia
  - lub tylko jedno na studia jednolite
  - wspolne oswiadczenie na pierwszy i drugi stopien tego samego kierunku

  maksymalnie dwa i maxymalnie jedno na drugi stopien

  Background:
    Given istnieje prawidłowe zatrudnienie umożliwiające dodanie oświadczenia o minimum kadrowym

    Given istnieją studia:
      | name                                     | courseOfStudy | profile           | level |
      | Matematyka stopnia 1.                    | Matematyka    | OGOLNO_AKADEMICKI | 1     |
      | Matematyka stopnia 2.                    | Matematyka    | OGOLNO_AKADEMICKI | 2     |
      | Informatyka stopnia 1.                   | Informatyka   | OGOLNO_AKADEMICKI | 1     |
      | Informatyka stopnia 2.                   | Informatyka   | OGOLNO_AKADEMICKI | 2     |
      | Marketing stopnia 1.                     | Marketing     | OGOLNO_AKADEMICKI | 1     |
      | Teoretyczne podstawy Zduństwa stopnia 1. | Zduństwo      | PRAKTYCZNY        | 1     |

  Scenario: jedno wspólne oswiadczenie
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oswiadczenie "Matematyka stopnia 1., Matematyka stopnia 2." z liczbą godzin "30"
    Then oswiadczenie zostanie złożone

  Scenario: oswiadczenie ze zbyt małą ilością godzin (<30)
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oswiadczenie "Matematyka stopnia 1." z liczbą godzin "20"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "za mala ilosc godzin w oswiadczeniu"

  Scenario: oswiadczenie z ogromną ilością godzin
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oswiadczenie "Matematyka stopnia 1." z liczbą godzin "300"
    Then oswiadczenie zostanie złożone

  Scenario: dwa wspólne oswiadczenie na różne kierunki
    Given istniejace oswiadczenie "Informatyka stopnia 1., Informatyka stopnia 2."
    When wprowadz oswiadczenie "Matematyka stopnia 1., Matematyka stopnia 2." z liczbą godzin "30"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "przekroczona ilośc oswiadczen"


  # napisac test gdzie proba dodania oswiadczenia wspolnego z tym samym kierunkiem dwa razy

    #==============================================================================

  Scenario: jedno na studia pierwszego stopnia
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oswiadczenie "Matematyka stopnia 1." z liczbą godzin "30"
    Then oswiadczenie zostanie złożone

  Scenario: dwa na studia pierwszego stopnia ale na różne kierunki
    Given istniejace oswiadczenie "Informatyka stopnia 1."
    When wprowadz oswiadczenie "Matematyka stopnia 1." z liczbą godzin "30"
    Then oswiadczenie zostanie złożone

  Scenario: 3 na studia pierwszego stopnia ale na różne kierunki
    Given istniejace oswiadczenie "Informatyka stopnia 1."
    Given istniejace oswiadczenie "Matematyka stopnia 1."
    When wprowadz oswiadczenie "Marketing stopnia 1." z liczbą godzin "30"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "przekroczona ilośc oswiadczen"

  Scenario: dwa na studia pierwszego stopnia ale na ten sam kierunek
    Given istniejace oswiadczenie "Informatyka stopnia 1."
    When wprowadz oswiadczenie "Informatyka stopnia 1." z liczbą godzin "30"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "przekroczona ilośc oswiadczen"

  Scenario: jedno na studia drugiego stopnia
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oswiadczenie "Matematyka stopnia 2." z liczbą godzin "30"
    Then oswiadczenie zostanie złożone

  Scenario: dwa na studia drugiego stopnia na ten sam kierunek
    Given istniejace oswiadczenie "Informatyka stopnia 2."
    When wprowadz oswiadczenie "Informatyka stopnia 1., Informatyka stopnia 2." z liczbą godzin "30"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "przekroczona ilośc oswiadczen"

  Scenario: dwa na studia drugiego stopnia na różne kierunki
    Given istniejace oswiadczenie "Informatyka stopnia 2."
    When wprowadz oswiadczenie "Matematyka stopnia 2." z liczbą godzin "30"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "przekroczona ilośc oswiadczen"

  Scenario: jedno wspólne oswiadczenie + jedno na studia pierwszego stopnia
    Given istniejace oswiadczenie "Informatyka stopnia 1., Informatyka stopnia 2."
    When wprowadz oswiadczenie "Matematyka stopnia 1." z liczbą godzin "30"
    Then oswiadczenie zostanie złożone

