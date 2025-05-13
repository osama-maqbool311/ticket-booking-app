# 🎟️ Ticket Booking App

A **multi-module Quarkus microservices** application for booking and payment management.

This project includes:

* `booking-service`: Handles show booking and seat reservations.
* `payment-service`: Manages payment processing for bookings.

---

## 🧱 Project Structure

```
ticket-booking-app/
├── booking-service/     # Booking microservice
├── payment-service/     # Payment microservice
├── pom.xml              # Parent POM with dependency management and module definitions
```

---

## 🛠️ Prerequisites

Before building or running the services, ensure the following tools are installed:

* [Java 21+](https://adoptium.net/)
* [Apache Maven 3.9+](https://maven.apache.org/)
* [Docker (optional)](https://www.docker.com/) – if containerization is needed
* [PostgreSQL](https://www.postgresql.org/) – if using Flyway and persistence

---

## ⚙️ Build Instructions

### 🔁 Build All Modules (Full Project)

To build the entire project from the root:

```bash
mvn clean install
```

This will compile and package both `booking-service` and `payment-service`.

---

### 🧹 Build Individual Modules

#### 📆 Booking Service

```bash
mvn clean install -pl booking-service -am
```

#### 💳 Payment Service

```bash
mvn clean install -pl payment-service -am
```

`-pl`: Specifies the module to build
`-am`: Also builds any dependencies required by that module

---

## 🚀 Run Instructions

### Run in Development Mode

#### 🔹 Booking Service

```bash
cd booking-service
./mvnw quarkus:dev
```

#### 🔹 Payment Service

```bash
cd payment-service
./mvnw quarkus:dev
```

By default, each service runs on its configured port (`8081`, `8082`, etc.). You can change this in `application.yaml`.

---

## 🧪 Running Tests

To run **all tests**:

```bash
mvn test
```

To test an individual module:

```bash
mvn test -pl booking-service
```

---

## 🐳 Optional: Docker Build (Native or JVM Mode)

From each service directory:

```bash
./mvnw clean package -Dquarkus.container-image.build=true
```

Or use:

```bash
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

---

## 📄 API Documentation

When the services are running, you can view OpenAPI docs at:

* Booking Service: `http://localhost:8081/q/swagger-ui`
* Payment Service: `http://localhost:8082/q/swagger-ui`

---

## 🧑‍💻 Contributing

Pull requests are welcome. For major changes, please open an issue first.

---

## 📜 License

[MIT](LICENSE)
