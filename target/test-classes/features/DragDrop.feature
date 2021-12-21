@dragDrop
Feature: API DEMOS
  Scenario: drag_drop testing
    Given open app on the phone
    When click API Demos button
    When kullanici Views tiklasin
    When kullanici drag an drop tiklasin
    Then kullanici ilk noktayi alip ucuncu noktaya tasiyacak
    Then cikan yaziyi onaylayacak
    Then screenshot al
