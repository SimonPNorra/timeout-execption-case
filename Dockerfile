# Use a temporary image with Maven and JDK to build the project
FROM maven:3.9.6-sapmachine-21 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml ./
COPY src ./src

# Run Maven to install dependencies and build the project
RUN mvn clean package -DskipTests=true

# Use a distroless image for running the application
FROM gcr.io/distroless/java21-debian12

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the builder image
COPY --from=builder /app/target/*.jar app.jar

# Specify the command to run tests (or modify this line for runtime execution if needed)
CMD ["app.jar"]
