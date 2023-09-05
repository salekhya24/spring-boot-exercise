Feature: Git Hottest Repo Search API

  Background:
    * url 'http://localhost:8080'

  Scenario: Get Hottest Repos
    Given path '/api/hottest/2'
    When method GET
    Then status 200
    And match response == 
    """
    {
      "items": [
        {
          "name": "ChatDev",
          "html_url": "#string",
          "watchers_count": "#string",
          "language": "Python",
          "description": "#string"
        },
        {
          "name": "yf-boot",
          "html_url": "#string",
          "watchers_count": "#string",
          "language": "Java",
          "description": "#string"
        }
      ]
    }
    """