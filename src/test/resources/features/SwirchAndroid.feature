@switchbutton
Feature: APIDEMIS
  Background:
    Given open app on the phone
    When click API Demos button
    When click Preference button
    When kullanici Switch tiklasin

  Scenario: Switch element
    And ilk switch butonu acik olmali
    Then ilk switch butonunu acik oldugunu onayla

@secondSwitchButton
Scenario: Switch elementler
    And ilk switch butonu kapali olmali
  Then ilk switch buttonunun kapali oldugunu onaylayin
  And ikinci swtich butonu acik olmali
  Then ikinci swtich butonunun acik oldugunu onaylayin
  Then screenshot al
