@GestiónOrdenes
Feature: Gestión de ordenes de la tienda

  @CrearOrden
  Scenario Outline: Crear una nueva orden
    Given que estoy en la pagina de mascotas
    And la URL_BASE del Servicio de la tienda responde 200
    When creo una orden con id <id>, petId <petId>, quantity <quantity>
    Then el código de estado de la respuesta debe ser <codigo>
    And la respuesta debe contener el id <id>, petId <petId>, quantity <quantity>
    Examples:
    |id|petId|quantity|codigo|
    |201|2   |3       |200   |
    |202|3   |1       |200   |
    |203|3   |1       |200   |
    |204|3   |1       |200   |


  @ConsultaOrden
  Scenario: Consultar una orden
    Given que estoy en la pagina de mascotas
    And la URL_BASE del Servicio de la tienda responde 200
    When consulto la orden con id 201
    Then el código de estado de la respuesta debe ser 200
    And la respuesta debe contener el id 201, petId 2, quantity 3


  @ConsultaOrden-Outline
  Scenario Outline: Consultar una orden
    Given que estoy en la pagina de mascotas
    And la URL_BASE del Servicio de la tienda responde 200
    When consulto la orden con id <id>
    Then el código de estado de la respuesta debe ser <codigo>
    And la respuesta debe contener el id <id>, petId <petId>, quantity <quantity>
    Examples:
      |id|petId|quantity|codigo|
      | 1564 | 12    | 8        | 200    |
      | 203  | 3     | 1        | 200    |
      | 204  | 3     | 1        | 200    |




