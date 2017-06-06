#Tutorial: Docker 101

This is a quick Docker 101 course with tasks.
The Live folder is just a live demo i made to present before making the students perform the tasks

********************************************
##Stuff needed:
1. OSX/Windows: download docker-toolbox  https://www.docker.com/docker-toolbox (docker, docker-compose, virtualbox)
2. Install node,java,.net, or a language you would like to work with
********************************************

##Tasks:

Download code: 
		git clone https://github.com/Roykk/dockerdag

Create a docker machine

		docker-machine create --driver virtualbox myDocker
		docker-machine env myDocker
		eval $(docker-machine env myDocker)

run ```docker-machine ip``` and note your ip-address!

### Task 1:
#####Get to know docker: Create a dockerfile, build a docker imageand start a container.

3 different webapps is created in different languages, dockerize as many as you can.
All of them has a solutions folder, this is a dockerfile which can be used in futher in task2. 

1. Springboot   (Java)

		cd springboot
		mvn install
		java -jar  -Djava.security.egd=file:/dev/./urandom target/springboot-1.0-SNAPSHOT.jar
		curl mot localhost:8081/ping  (or use your browser browser)


2. NodeDock     (Node)

		cd nodeDock
		npm install
		node nodeapp.js
		curl localhost:8082/ping (or use your browser browser)

3. SimpleNancy  (.NET , created just as showcase, to show .net in docker and linux)

		Build and run it the .net way
		curl localhost:8082/ping


all web appliacations has a solutions folder. Please take a peak there if you are stuck


### Task 2
##### Get to know docker-compose: Make services talk together! Java --> Node --> MongoDB

		Go to /dockerdag, and look at docker-compose.yml
		docker-compose up
		curl localhost:8081/count (or use your browser browser)

Try to complete the docker-compose.yml!

(PS. please use  dockerfile in solutions, if you have not completed them yourself)


### Task 3
##### Challenge yourself, play around with Docker

		DO you have your own project you want to dockerize??
		Do you want to test you docker in the cloud?
		Play with docker!

