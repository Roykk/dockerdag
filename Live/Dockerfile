################
#GET A BASEIMAGE
################
FROM anapsix/alpine-java

################################
#COPY THE JAR INTO THE CONTAINER
################################
ADD target/live-1.0.jar /application/live.jar

#######################################
#COPY THE CONFIG.YML INTO THE CONTAINER
#######################################
ADD config.yml /application/config.yml

#############
#EXPOSE A PORT
#############
EXPOSE 8080


######################
#START THE APPLICATION
######################
CMD ["java","-jar", "/application/live.jar" ,"server", "/application/config.yml"]

