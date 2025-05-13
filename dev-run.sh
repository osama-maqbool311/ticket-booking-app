#!/bin/bash

# Start booking-service in a new Git Bash window
start "" bash -c "cd booking-service && mvn clean && ./mvnw compile quarkus:dev; exec bash"

# Wait for a while to ensure booking-service has started
sleep 30

# Start payment-service in a new Git Bash window (since it's in the same directory)
start "" bash -c "cd payment-service && mvn clean && ./mvnw compile quarkus:dev; exec bash"
