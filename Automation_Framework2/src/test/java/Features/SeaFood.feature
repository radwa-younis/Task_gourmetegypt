Feature: Gourmet Egypt
 
Scenario: select randam Seafood 

 Given open SeaFood Menu 
 When select randam seafood
 Then Add to Card
 And check on total price
 


