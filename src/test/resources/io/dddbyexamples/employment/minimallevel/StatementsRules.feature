Feature: weryfikacja poprawnosci skladanych oświadczeń w damym roku akademickim

  dwa oswiadczenia na rok akademicki lub jedno
  - jedno na pierwszego stopnia
  - jedno na drugiego stopnia
  - lub tylko jedno na studia jednolite
  - wspolne oswiadczenie na pierwszy i drugi stopien tego samego kierunku

  maksymalnie dwa i maxymalnie jedno na drugi stopien


  Background:


  Scenario: jedno wspólne oswiadczenie
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oswiadczenie wspólne "Matematyka poz. 1." "30h"
    Then oswiadczenie zostanie złożone

  Scenario: oswiadczenie z zbyt małą ilością godzin (<30)
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oswiadczenie "Matematyka poz. 1." "20h"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "za mala ilosc godzin w oswiadczeniu"

  Scenario: oswiadczenie z ogromną ilością godzin
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oswiadczenie "Matematyka poz. 1." "300h"
    Then oswiadczenie zostanie złożone

  Scenario: dwa wspólne oswiadczenie na różne kierunki
    Given istniejace oswiadczenie (wspólne) na dany rok "Informatyka poz. 1."
    When wprowadz oswiadczenie "Matematyka poz. 1." "30h"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "przekroczona ilośc oswiadczen"

  Scenario: jedno na studia pierwszego stopnia
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oswiadczenie pierwszego stopnia "Matematyka poz. 1." "30h"
    Then oswiadczenie zostanie złożone

  Scenario: dwa na studia pierwszego stopnia ale na różne kierunki
    Given oswiadczenie na rok "2018" pierwszego stopnia "Informatyka poz. 1." "30h"
    When wprowadz oswiadczenie pierwszego stopnia "Matematyka poz. 1." "30h"
    Then oswiadczenie zostanie złożone

  Scenario: 3 na studia pierwszego stopnia ale na różne kierunki
    Given oswiadczenie na rok "2018" pierwszego stopnia "Informatyka poz. 1." "30h"
    Given oswiadczenie na rok "2018" pierwszego stopnia "Matematyka poz. 1." "30h"
    When wprowadz oswiadczenie pierwszego stopnia "Marketing poz. 1." "30h"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "przekroczona ilośc oswiadczen"

  Scenario: dwa na studia pierwszego stopnia ale na ten sam kierunek
    Given oswiadczenie na rok "2018" pierwszego stopnia "Informatyka poz. 1." "30h"
    When wprowadz oswiadczenie pierwszego stopnia "Matematyka poz. 1." "30h"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "przekroczona ilośc oswiadczen"

  Scenario: 3 oswiadczeia na studia pierwszego stopnia ale na różne kierunki
    Then NIE

  Scenario: jedno na studia drugiego stopnia

  Scenario: dwa na studia drugiego stopnia

  Scenario: jedno wspólne oswiadczenie + jedno na studia pierwszego stopnia
