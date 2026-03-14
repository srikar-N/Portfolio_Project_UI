@tag
Feature: Login Test for Ecommerce website
 	I want to check the login functionality of Ecommerce website

  Background:
    Given I am on the Login page

  @tag2
  Scenario Outline: Login using valid Credentials
    Given Logged in with username <username> and password <password>
    When I Clicked on the Signin button
    Then user should be taken to Prodcutpage url <url>

  Examples:
	|username		   |password         |url|
	|rahulshettyacademy|Learning@830$3mK2|https://rahulshettyacademy.com/angularpractice/shop|
