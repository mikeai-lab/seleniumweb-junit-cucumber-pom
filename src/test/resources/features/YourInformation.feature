Feature: Your Information

  Background: Precondicion del feature
    Given El usuario navega a la pagina del Your Information

    Scenario Outline: Mensaje de errores
      When El usuario escribe el nombre <nombre>, el apellido <apellido>, el zipcode <zipcode> y presiona continue
      Then El mensaje de error <mensaje> debe aparecer
      Examples:
      |nombre |apellido |zipcode |mensaje |
      | ""      |"Apellido" |"Zipcode123" |"Error: First Name is required"  |
      |"Nombre" |    ""     |"Zipcode123" |"Error: Last Name is required"   |
      |"Nombre" |"Apellido" |   ""        |"Error: Postal Code is required" |