#FROM describes baseImage
FROM alpine 

#RUN executes given command in container
RUN apk add --update nodejs

#COPY files from disk to container
COPY . /src
RUN cd /src; npm install

#Expose the port that is defined in the js.
EXPOSE 8082

#Run the app
CMD ["node", "/src/nodeapp.js"]

