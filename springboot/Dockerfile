FROM java:8
VOLUME /tmp
ADD /target/springboot-1.0-SNAPSHOT.jar  myApplication.jar
ENTRYPOINT ["java","-jar","-Djava.security.egd=file:/dev/./urandom", "/myApplication.jar"]
