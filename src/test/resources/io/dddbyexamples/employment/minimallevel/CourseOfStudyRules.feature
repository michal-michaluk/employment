Feature: zawieszanie / odwieszanie oświadczenia wzwiązku z właściwościami kierunku studiów

  studia nie są uruchomione na kierunku na rok skladanego oswiadczenia

  wspólne oswiadczenie może uprawnienie do danego kierunku musi byc zdefiniowane na tej samej jednostce

  fizjoterapia jesli trwa ciągle "01.10.2016" - "01.10.2017" to pozwalamy dodatkowo na jednolite


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
    Given pierwszy i drugi stopnia "Fizjoterapi" była zawieszona w okresie "01.01.2017" - "01.06.2017"
    When wprowadz oswiadczenie jednolite stopnia "fizjoterapia" "30h"
    Then oswiadczenie zostanie złożone
    And oswiadczenie zostanie zawieszone


  Scenario: studia nie są uruchomione na kierunku na rok skladanego oswiadczenia

  Scenario: oswiadczenienie wspolne na 1. 2. stop. tego samego kierunku o roznych nazwach
