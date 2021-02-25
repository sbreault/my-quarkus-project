# my-quarkus-project
 Sample exploration of Quarkus

## Local development - Running the application in dev mode
You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## native build

## Docker build
Add necessary Docker extension...
```shell script
./mvnw quarkus:add-extension -Dextensions="container-image-docker"
```
then issue build...
```shell script
./mvnw clean package -Dquarkus.container-image.build=true
```
confirm image exists...
```shell script
docker images
```
Run image...
```shell script
docker run --publish <hostport>:<containerport> --detach <imagename>
```

## OpenShift s2i build
Add necessary OpenShift extension...
```shell script
./mvnw quarkus:add-extension -Dextensions="container-image-s2i"
```