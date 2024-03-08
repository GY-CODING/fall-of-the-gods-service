# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the application JAR file into the container at /usr/src/app
COPY target/FallOfTheGods-Data.jar .

# Expose the port the application runs on
EXPOSE 8080

# Run the JAR file when the container launches
CMD ["java", "-jar", "FallOfTheGods-Data.jar"]
