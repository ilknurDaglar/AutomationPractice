Feature: Crud operations in API

  Scenario: Get operations with request and response
    Given the user sends request to api_url
    And the key is "id" and value is 1
    And response Content type should be "application/json; charset=utf-8"
    And Title should be "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
    Then response status code should be 200
    And response userId should be 1

#  I used Jsonplaceholder because reaching the Api address from
# AutomationPractice's UI did not give the correct results.

  Scenario: Post operations with request and response
    Given the user sends request to api_url
    And the user sends "id"key with a value of  198
    And Content type should be Json
