Feature: Skladanie oswiadczenia o minium kadrowym

  dwa oswiadczenia na rok akademicki lub jedno
  - jedno na pierwszego stopnia
  - jedno na drugiego stopnia
  - lub tylko jedno na studia jednolite
  - wspolne oswiadczenie na pierwszy i drugi stopien tego samego kierunku

  : maksymalnie dwa i maxymalnie jedno na drugi stopien

  skladamy na aktualne zatrudnienie

  fizjoterapia jesli trwa ciągle "01.10.2016" - "01.10.2017" to pozwalamy dodatkowo na jednolite

  studia nie są uruchomione na kierunku na rok skladanego oswiadczenia

  wspólne oswiadczenie może uprawnienie do danego kierunku musi byc zdefiniowane na tej samej jednostce


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


  Scenario: zakonczenie zatrudnienia w pierwszym semestrze


  Scenario: semestr letni
  # ktos sie zatrudnia w trakcie trwania pierwszego semestru
  # moze lozyc oswiadczenie
  # bedzie sie to wliczas w minimum kadrowe wylącznie w 2. semestrze

  Scenario: nauczyciel akademicki oswiadcza wylacznie na podstawowe miejsce pracy


  Scenario: fizjoterapia 1
    Given istniejace oswiadczenie (wspólne) na dany rok "fizjoterapia"
    When wprowadz oswiadczenie jednolite stopnia "fizjoterapia" "30h"
    Then oswiadczenie zostanie złożone


  Scenario: fizjoterapia 2
    Given istniejace oswiadczenie (wspólne) na dany rok "fizjoterapia"
    Given pierwszy i drugi stopnia "Fizjoterapi" trwa do "01.10.2016" - "01.10.2017"
    When wprowadz oswiadczenie jednolite stopnia "fizjoterapia" "30h"
    Then oswiadczenie zostanie złożone

  Scenario: fizjoterapia 3
    Given istniejace oswiadczenie (wspólne) na dany rok "fizjoterapia"
    Given pierwszy i drugi stopnia "Fizjoterapi" musial trwać do "01.10.2016" - "01.10.2017"
    When wprowadz oswiadczenie jednolite stopnia "fizjoterapia" "30h"
    Then oswiadczenie zostanie złożone


  Scenario: studia nie są uruchomione na kierunku na rok skladanego oswiadczenia

  Scenario: oswiadczenienie wspolne na 1. 2. stop. tego samego kierunku o roznych nazwach

  Scenario: nauczyciel akademicki oswiadcza wylacznie na podstawowe miejsce pracy


  Scenario: profil kierunku: ogolno akademicki
    Given pełny etat w całym okresie
    Then oswiadczenie zostanie złożone


  Scenario: profil kierunku: praktyczny
    Given 25% etatu w całym okresie
    Then oswiadczenie zostanie złożone

  Scenario: zmiana etatu w pirtwszym semestrze z 10% na 50%


  Scenario: zmiana podstawowego miejsca zatrudnienia

  Scenario: zakonczenie zatrudnienia

  Scenario: zmiana etatu w pirtwszym semestrze z 10% na 50%

  Scenario: "Fizjoterapi" została skorygowana musial byla zawieszona "01.10.2016" - "01.10.2017"


#
#  Scenario Outline: weryfikacja ilosci godzin na oswiadczenie
#    Given w ruleski zdewiniowano "minimalna ilosc godzin oswiadczenia" na "30h"
#    When wprowadz oswiadczenie "Matematyka poz. 1." "<ilosc>"
#    Then przyjęto lub nie <wynik> i komunikat <komunikat>
#
#    Examples:
#      | ilosc | wynik | komunikat |
#      | 20    | NIE   |           |
#      | 30    | TAK   |           |
#      | 300   | TAK   |           |
