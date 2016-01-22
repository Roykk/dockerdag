FROM rmacdonaldsmith/docker-debian-mono-devel
RUN apt-get update
RUN apt-get install -y curl
WORKDIR /tmp
ENV EnableNuGetPackageRestore true
ADD . /app
WORKDIR /app
RUN nuget restore SimpleNancy.sln -Source https://www.nuget.org/api/v2/
RUN xbuild SimpleNancy.sln
EXPOSE 8081
RUN chmod +x run.sh
CMD ./run.sh
