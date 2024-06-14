# First stage: Build the application
FROM maven:3.9.2-eclipse-temurin-20 AS build

# Install JDK 21
RUN apt-get update && apt-get install -y openjdk-21-jdk && rm -rf /var/lib/apt/lists/*

# Set JAVA_HOME to JDK 21
ENV JAVA_HOME /usr/lib/jvm/java-21-openjdk-amd64
RUN update-alternatives --set java /usr/lib/jvm/java-21-openjdk-amd64/bin/java

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .

# Download the dependencies without running tests
RUN mvn dependency:go-offline -B

# Copy the rest of the application source code
COPY src ./src

# Build the application, skipping tests
RUN mvn clean package -DskipTests

# Second stage: Run the application
FROM eclipse-temurin:21-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from the first stage
COPY --from=build /app/target/FoodOrdering-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application will run on
EXPOSE 5454

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
