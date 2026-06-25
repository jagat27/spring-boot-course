FROM openjdk:28-ea-trixie
WORKDIR /DockerDemoSpringApp
COPY target/rest-demo.jar rest-demo.jar
ENTRYPOINT ["java","-jar","rest-demo.jar"]