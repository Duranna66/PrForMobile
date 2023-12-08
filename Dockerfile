FROM openjdk
MAINTAINER Ivan Nikolaev
ADD target/test-for-mobile-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]
