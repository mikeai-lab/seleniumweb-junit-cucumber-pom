Feature: Login

  Background: Precondicion del feature
    Given El usuario navega a la pagina del login

  @regression
  Scenario Outline: Credenciales erroneas
    When El usuario escribe el username <username> con el password <password> y presiona el boton de login
    Then Debe aparecer un mensaje de error indicando <mensajeError>

    Examples:
    | username         | password       | mensajeError                                                                |
    | "locked_out_user"| "secret_sauce" | "Epic sadface: Sorry, this user has been locked out."                       |
    | "hola mundo"     | "hola123"      | "Epic sadface: Username and password do not match any user in this service" |

  @regression @smoke
    Scenario: Verificar la UI de la pagina
      Then El usuario verifica que la UI de la pagina de login sea correcta