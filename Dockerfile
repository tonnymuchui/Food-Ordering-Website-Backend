FROM maven:3.9.2-eclipse-temurin-21 AS build

# Copy your project files to the build stage
COPY . .
# Copy the pom.xml and download dependencies
COPY pom.xml .

# Download the dependencies without running tests
RUN mvn dependency:go-offline -B

# Copy the rest of the application source code
COPY src ./src
# Run Maven to build your project, skipping tests
RUN mvn clean package -DskipTests

# Second stage: Run the application
FROM eclipse-temurin:21-jre-alpine

# Copy the built JAR file from the build stage to the final image
COPY --from=build /target/FoodOrdering-0.0.1-SNAPSHOT.jar FoodOrdering.jar

# Expose port 5454 where your application might listen
EXPOSE 5454

# Define the default command to run your application using the JAR file
ENTRYPOINT ["java", "-jar", "FoodOrdering.jar"]
