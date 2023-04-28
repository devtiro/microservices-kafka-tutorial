If you are running this on an ARM machine, then make sure to update the respective microservices' dockerfile.

Change `FROM openjdk:17-alpine` to `FROM arm64v8/openjdk:17`
