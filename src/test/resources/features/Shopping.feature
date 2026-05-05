Feature: Shopping
  Background: Precondicion del feature
    Given El usuario entre logueado a la pagina de Shopping

    @regression @smoke
      Scenario: Verificar la UI
        Then El usuario verifica que la UI de la pagina de Shopping sea correcta

    @regression
       Scenario: Verificar precios
        When Leo los productos esperados del excel
        Then Verifico que los productos de excel sean los mismos que de la pagina