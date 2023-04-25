
@US05
Feature:	Admin_Deanleri_Gorebilmeli_Ve_Silebilmeli
  @US05_TC01
  Scenario:	TC01_Admin Dean'lerin Name Gender Phone Number SSN UserName bilgilerini görebilmel
    Given 	Kullanici https://www.managementonschools.com/ sayfasina gider
    When	Login Linkine tiklar
    Then	Admin userName ve Passwordu girer
    Then	Login Butonuna tiklar
    And	    Acilan sayfada Menu linkini tiklar
    Then	Acilan sayfada Dean Management linkini tiklar
    Then	Dean Listteki Name, Gender, Phone Number, SSN, User Name bilgilerini görebilmeli
    And 	Sayfayi kapatir