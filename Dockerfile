# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the Maven wrapper and the project descriptor
COPY mvnw .
COPY .mvn .mvn

# Copy the project source
COPY pom.xml .
COPY src src

# Compile the application
RUN ./mvnw package -DskipTests

# Expose the port the application runs on
EXPOSE 8080

# Run the JAR file when the container launches
CMD ["java", "-jar", "target/FallOfTheGods-Data.jar"]

