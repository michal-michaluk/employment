Feature: możliwość składania, wycofania oświadczeń o minimum kadrowym

  Scenario: składanie poprawnego oswiadczenia
    When wprowadz poprawne oswiadczenie
    Then informacje o zatrudnieniu pracownika zostały uwzględnione
    Then informacje o kierunkach zostały uwzględnione
    And oswiadczenie zostanie złożone
    And oswiadczenie nie jest zawieszone
    And minima kadrowe są uaktualnione


  Scenario: składanie oswiadczenia, które będzie zawieszone
    When wprowadz oswiadczenie nie spełniające warunków
    Then informacje o zatrudnieniu pracownika zostały uwzględnione
    Then informacje o kierunkach zostały uwzględnione
    And oswiadczenie zostanie złożone
    But oswiadczenie jest zawieszone
    And minima kadrowe NIE są uaktualnione


  Scenario: składanie błędnego oswiadczenia
    Given nie ma oświadczeń na dany rok akademicki
    When wprowadz błędne oswiadczenie
    Then informacje o zatrudnieniu pracownika zostały uwzględnione
    Then informacje o kierunkach zostały uwzględnione
    But oswiadczenie NIE zostanie złożone
    And minima kadrowe NIE są uaktualnione
