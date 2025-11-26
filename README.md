# RetirementPro API

Retirement benefits management platform - Demo application for CloudBees Unify.

## Features

- REST API for beneficiary management
- Calculate annual retirement benefits
- H2 in-memory database
- JUnit tests with Mockito

## Tech Stack

- Java 17
- Spring Boot 3.2.0
- Maven
- H2 Database
- JUnit 5

## Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

## API Endpoints

- `GET /api/beneficiaries` - List all beneficiaries
- `POST /api/beneficiaries` - Create beneficiary
- `GET /api/beneficiaries/{id}/annual-benefit` - Calculate annual benefit

## CI/CD

- **Jenkins**: Build and test pipeline
- **CloudBees Unify**: Orchestration with Smart Test and Analytics
