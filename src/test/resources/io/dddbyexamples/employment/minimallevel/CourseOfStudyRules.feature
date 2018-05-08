Feature: zawieszanie / odwieszanie oświadczenia wzwiązku z właściwościami kierunku studiów




  studia nie są uruchomione na kierunku na rok skladanego oswiadczenia

  wspólne oswiadczenie może uprawnienie do danego kierunku musi byc zdefiniowane na tej samej jednostce

  fizjoterapia jesli trwa ciągle "01.10.2016" - "01.10.2017" to pozwalamy dodatkowo na jednolite

  W oswiadczeniu można zdefiniować maksymalnie dwa kierunki (inne niż fizjoterapia)


  Dla kierunku studiów o kodzie: <<nr kodu>> nie uruchomiono studiów w wskazanym roku akademickim



  Scenario: Dodajemy dwa kierunki w jednym oświadczeniu
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oświadczenie "Matematyka poz. 1.", "Informatyka poz. 1." z liczbą godzin "30h"
    Then oswiadczenie zostanie złożone
      And oswiadczenie ma status "zawieszone"



  Scenario: Dodajemy trzy kierunki w jednym oświadczeniu (inne niz fizjoterapia)
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadzon oświadczenie "Matematyka poz. 1.", "Informatyka poz. 1.", "Marketing poz. 1." z liczbą godzin "30h"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "R_1429"

  Scenario: Dodajemy trzy kierunki w jednym oświadczeniu (z fizjoterapią)
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz oświadczenie "Matematyka poz. 1.", "Informatyka poz. 1.", "Fizjoterapia poz. 1." z liczbą godzin "30h"
    #Then // todo: dopytać analityka


  Scenario: Dodajemy oświadczenie z kierunkiem bez uruchomionych studiów w danym roku akademickim
    Given nie ma oświadczeń na dany rok akademicki
      And istnieja studia "Matematyka z nieuruchom poz. 1" bez uruchomionych studiow
    When wprowadz oświadczenie "Matematyka z nieuruchom poz. 1" z liczbą godzin "30h"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "R_1355"


#    //R_1354 -- // todo: zapytac analityka

  Scenario: Dodajemy oświadczenie dla kierunku praktycznego dla pracownika który pracuje więcej niż 25% na etacie
    Given nie ma oświadczeń na dany rok akademicki
    And istnieja studia "Matematyka w praktyce" o profilu "praktycznym"
    And pracownik ma "3/4" etatu
    When wprowadz oświadczenie "Matematyka w praktyce" z liczbą godzin "30h"
    Then oswiadczenie zostanie złożone


  Scenario: Dodajemy oświadczenie dla kierunku praktycznego dla pracownika który pracuje 25% na etacie
    Given nie ma oświadczeń na dany rok akademicki
    And istnieja studia "Matematyka w praktyce" o profilu "praktycznym"
    And pracownik ma "1/4" etatu
    When wprowadz oświadczenie "Matematyka w praktyce" z liczbą godzin "30h"
    Then oswiadczenie zostanie złożone


  Scenario: Dodajemy oświadczenie dla kierunku praktycznego dla pracownika który pracuje mniej niż 25% na etacie
    Given nie ma oświadczeń na dany rok akademicki
      And istnieja studia "Matematyka w praktyce" o profilu "praktycznym"
      And pracownik ma "1/6" etatu
    When wprowadz oświadczenie "Matematyka w praktyce" z liczbą godzin "30h"
    Then oswiadczenie nie zostanie przyjęte z komunikatem "R_1432"


  Scenario: Dodanie dwóch oświadczeń na kierunku fizjoterapia drugiego stopnia
    Given istniejace oswiadczenie na dany rok "fizjoterapia 1+2"
    When wprowadz oswiadczenie "fizjoterapia" z liczbą godzin "30h"
    Then oswiadczenie zostanie złożone


  Scenario: Dodanie oświadczenia
    Given istniejace oswiadczenie na dany rok "fizjoterapia 1+2+jednolite"
      And uprawnienie dla kierunku "fizjoterapia 1+2" trwa od "01.10.2016" - "01.10.2017"
    When wprowadz oswiadczenie "Matematyka poz. 1." z liczbą godzin "30h"
    Then oswiadczenie zostanie złożone


  Scenario: fizjoterapia 3
    Given istniejace oswiadczenie (wspólne) na dany rok "fizjoterapia"
    Given pierwszy i drugi stopnia "Fizjoterapi" była zawieszona w okresie "01.01.2017" - "01.06.2017"
    When wprowadz oswiadczenie jednolite stopnia "fizjoterapia" "30h"
    Then oswiadczenie zostanie złożone
    And oswiadczenie zostanie zawieszone


  Scenario: studia nie są uruchomione na kierunku na rok skladanego oswiadczenia

  Scenario: oswiadczenienie wspolne na 1. 2. stop. tego samego kierunku o roznych nazwach
