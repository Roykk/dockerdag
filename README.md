# dockerdag

* cd nodeDock
* installere npm: 'brew install npm'
* Bygg node-app: 'npm install'
* Kjør node-app: 'node nodeapp.js'
* test med browser eller curl mot localhost:8082/ping
* Bygg Image med docker: 'docker build . '
* kjør 'docker run -p 8082:8082 imagenavn' (mener jeg å huske , dobbelsjekk)
* test med browser eller curl mot dockerip:8082/ping

* cd springboot
* installere maven: 'brew install maven'
* Bygg spring-boot-app: 'mvn install'
* Kjør spring-boot-app: 'java -jar target/springboot-1.0-SNAPSHOT.jar'
* test med browser eller curl mot localhost:8081/ping
* Bygg Image med docker: 'docker build . '
* kjør 'docker run -p 8081:8081 imagenavn' (mener jeg å huske , dobbelsjekk)
* test med browser eller curl mot dockerip:8081/ping


* Stopp alle containere

* gå til root folder
* installer docker-compose? husker ikke om jeg har gjort det eller om det kom med i dockermachine. evt 'brew install docker-compose'
* kjør docker-compose up
* test med browser mot springboot , som går mot node, som går mot mongodb. 'dockerip:8100/count'
* port til node er også åpne så en kan pinge den også om en vil på 8200:

TODO
####

* Sette opp egen container med delt volum for å holde på data i mongodb? dette vil vise at data blir igjen ved container restart
* lage oppgaver uten løsninger :)
* Og masse mer kode rydding:)





