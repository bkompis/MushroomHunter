# MushroomHunter
Project repository for PA165 - team Mushroom Hunter


### Build Status - Travis

[![Build Status](https://travis-ci.org/bkompis/MushroomHunter.svg?branch=master)](https://travis-ci.org/bkompis/MushroomHunter)


### Run instructions
```sh
mvn clean install && cd mvc && mvn tomcat7:run #(MVC)
mvn clean install && cd rest && mvn tomcat7:run #(REST)
```

### Prepared users:
* Admin: 
    * nickname: `admin`
    * password: `Password.123`
* Non-admin: 
    * nickname: `john`
    * password: `Password.123`

#### Testing commands for REST interface:
We only implemented a REST interface for the Mushroom Hunter entity, supporting CRUD operations.

 * Display all hunters including information about the HTTP header (-i):
```
curl -i -X GET http://localhost:8080/pa165/rest/hunters
```

* Display information about a hunter with id = 1:
```
curl -i -X GET http://localhost:8080/pa165/rest/hunters/1
```

* Delete a hunter with id = 1:
```
curl -i -X DELETE http://localhost:8080/pa165/rest/hunters/1
```

* Create a new hunter:
```
curl -X POST -i -H "Content-Type: application/json" --data '{"userNickname":"testing","unencryptedPassword":"password","firstName":"foo","surname":"bar","personalInfo":"lorem ipsum","admin":"false"}' http://localhost:8080/pa165/rest/
```

* Update a hunter (here: hunter with id = 1 gets all attributes changed from default): 
```
curl -X PUT -i -H "Content-Type: application/json" --data '{"id":1,"firstName":"somethingElse","surname":"entirely","userNickname":"newNick","personalInfo":"I'm a new person now!","admin":false}' http://localhost:8080/pa165/rest/
```


