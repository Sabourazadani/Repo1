Feature: Sample Feature File

#Background: < any repeated steps at the beginning of scenario can be placed under this keyword>
#Scenario: <scenario name>
#Given is precondition
#When Action
#And repeat of when 
#Then Expected behavior
#But Negative expected 

#Scenario Outline <scenario outline>
#Examples: every scenario outline follows an examples keyword



Scenario: Verify Positive Balance
    * I have $100 in my account
    * I withdraw $50
    * I should have $50 balance
    
    
