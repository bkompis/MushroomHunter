# MushroomHunter
Project repository for PA165 - team Mushroom Hunter


### Build Status - Travis

[![Build Status](https://travis-ci.org/bkompis/MushroomHunter.svg?branch=master)](https://travis-ci.org/bkompis/MushroomHunter)

#### Testing commands for REST interface:
```
curl -i -X GET http://localhost:8080/pa165/rest
```
 * for displaying all hunters including information about the HTTP header (-i):
```
curl -i -X GET http://localhost:8080/pa165/rest/hunters
```
* for displaying information about a hunter with id = 1:
```
curl -i -X GET http://localhost:8080/pa165/rest/hunters/1
```
* for deleting a hunter with id = 1:
```
curl -i -X DELETE http://localhost:8080/pa165/rest/hunters/1
```
* for updating a hunter (you can change one or more parametres): 
```
curl -X PUT -i -H "Content-Type: application/json" --data '{"firstName":"test","surname":"test","admin":"false","userNickname":"XXX", "personalInfo":"lorem ipsum"}' http://localhost:8080/pa165/rest/
```
* for creating a new hunter:
```
curl -X POST -i -H "Content-Type: application/json" --data '{"firstName":"test","surname":"test","admin":"false","userNickname":"YYY", "personalInfo":"lorem ipsum", "passwordHash":"UNDEFINED"}' http://localhost:8080/pa165/rest/
```


