Feature: Areas
  @ConsultaAreas1
  Scenario: Consulta de areas
    Given dado que estoy en la pagina
    When consulto el area con ID 2267
    Then valido que el codigo de respuesta sea 200

  @ConsultaAreas2
  Scenario Outline: Consulta de areas
    Given dado que estoy en la pagina
    When consulto el area con ID <id>
    Then valido que el codigo de respuesta sea <codigo>
    And la respuesta debe contener el id <id>, name<name>, parentAreaId<parentAreaId>
    Examples:
      | id   | name    | parentAreaId | codigo |
      | 2001 | Africa  | 2267         | 200    |
      | 2002 | Albania | 2077         | 200    |
      | 2002 | Albania | 2077         | 200    |