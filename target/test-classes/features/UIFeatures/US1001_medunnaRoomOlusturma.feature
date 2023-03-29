@medunna_room
Feature: US1001 Medunna_Room_Olusturma

  @signIn
  Scenario: TC01 medunna_kullanici_olarak_giris_yapma

    Given kullanici medunna sayfasina gider
    And   kullanici signIn butonuna tiklar
    And   acilan sayfada user name girer
    And   daha sonra password girer
    And   daha sonra signIn butonuna tiklar
    Then  kullanici sign in yaptigini kontrol eder
    And   sayfayi kapatir

  @create_Room
  Scenario: TC02 create_Room
    Given kullanici itemsAndTitle tiklar
    And   kullanici rooma tiklar
    And   acilan sayfada create a room butonuna tiklar
    And   room number kutusuna room numarasi girer
    And   room type kutusuna room Type girer
    And   status radio butonuna tiklar
    And   price kutusuna orice girer
    And   Description kutusuna birseyler yazar
    And   creates date butonuna tiklar
    And   save butonuna tiklar
    Then  girmis oldugu room numberin varligini dogrular


#  @amazon @ipad
#  Scenario: TC03 amazon ipad arama
#    When kullanici amazon sayfasina gider
#    And ipad icin arama yapar
#    Then sonucun ipad icerdigini test eder
#    And sayfayi kapatir