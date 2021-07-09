Feature: Crud operations in API
@wip
  Scenario: Get operations with request and response
    Given the user sends request to "https://jsonplaceholder.typicode.com/posts/1"
    And the key is "id" and value is 1
    And response Content type should be "application/json; charset=utf-8"
    And Title should be "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
    Then response status code should be 200
    And response userId should be 1

#I used Jsonplaceholder because reaching the Api address from
# the UI did not give the correct results.

  Scenario: Post operations with request and response
    Given the user sends request to "https://jsonplaceholder.typicode.com/posts/14"
    And the user sends "id"key with a value of  198
    And Content type should be Json
