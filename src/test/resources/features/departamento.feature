Feature: Pruebas del endpoint de departamento

  Scenario: Obtenemos todos los departamentos
    Given Existen dos departamentos
    When Se solicitan todos los departamentos
    Then Obtenemos todos los departamentos