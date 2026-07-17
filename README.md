City Break Manager - Professional README

---
# City Break Manager

City Break Manager is a Spring Boot application designed for travelers to efficiently manage their city breaks. It allows users to track visited cities, maintain a bucket list of cities to explore, and log trips with details, ratings, and personal notes.

---

## Table of Contents

* [Features](#features)
* [Technologies](#technologies)
* [Getting Started](#getting-started)

  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
  * [Database Configuration](#database-configuration)
* [API Endpoints](#api-endpoints)

  * [City Endpoints](#city-endpoints)
  * [Trip Endpoints](#trip-endpoints)
* [Usage Examples](#usage-examples)
* [Contributing](#contributing)

---

## Features

* **CRUD operations for Cities**

  * Add, view, update, and delete cities.
  * Store city information such as name, country, and description of attractions.

* **CRUD operations for Trips**

  * Log trips for a specific city with start/end dates, ratings, and personal notes.
  * View, update, or delete trips.

* **Relationship Management**

  * Each trip is linked to one city.
  * Easily track trips and cities visited or planned.

* **Scalable Architecture**

  * Built with a layered Spring Boot structure: Controllers, Services, and Repositories.

---

## Technologies

* Java 17+
* Spring Boot 3.x
* Spring Data JPA (Hibernate)
* MySQL Database (configurable)
* Maven for dependency management
* RESTful API design

---

## Getting Started

### Prerequisites

* Java 17+
* Maven 3+
* IDE (IntelliJ IDEA, Eclipse, VS Code)
* MySQL Database


### Database Configuration

Update `application.properties` with your database details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/[Your Database Name]
spring.datasource.username=[Your Username]
spring.datasource.password=[Your Password]
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.flyway.enabled=true
```

Access the API at:

```
http://localhost:8080/api/v1
```

---

## API Endpoints

### City Endpoints

| Method | Endpoint         | Description     |
| ------ | ---------------- | --------------- |
| GET    | /cities          | List all cities |
| GET    | /cities/{id}     | Get city by ID  |
| POST   | /cities          | Add a new city  |
| PUT    | /cities/{id}     | Update a city   |
| DELETE | /cities/{id}     | Delete a city   |

### Trip Endpoints

| Method | Endpoint        | Description    |
| ------ | --------------- | -------------- |
| GET    | /trips          | List all trips |
| GET    | /trips/{id}     | Get trip by ID |
| POST   | /trips          | Add a new trip |
| PUT    | /trips/{id}     | Update a trip  |
| DELETE | /trips/{id}     | Delete a trip  |

---

## Usage Examples

**Add a new city**

```json
POST /api/v1/cities
{
  "name": "Paris",
  "country": "France",
  "description": "Vibrant culture, must see the Louvre and Eiffel Tower"
}
```

**Log a trip**

```json
POST /api/v1/trips
{
  "cityId": 1,
  "startDate": "2024-04-10",
  "endDate": "2024-04-15",
  "rating": 4,
  "notes": "Loved the food and art museums!"
}
```

**Get all trips**

```json
GET /api/v1/trips
{
        "id": 1,
        "city": {
            "id": 1,
            "name": "New York",
            "country": "USA",
            "details": "A major global financial and cultural center."
        },
        "startDate": "2024-03-14T18:30:00.000+00:00",
        "endDate": "2024-03-21T18:30:00.000+00:00",
        "rating": 5,
        "personalNotes": "Amazing food and culture! Visited the Met and Central Park."
    },
    {
        "id": 2,
        "city": {
            "id": 2,
            "name": "London",
            "country": "UK",
            "details": "The capital and largest city of England and the United Kingdom."
        },
        "startDate": "2024-05-31T18:30:00.000+00:00",
        "endDate": "2024-06-04T18:30:00.000+00:00",
        "rating": 3,
        "personalNotes": "Weather was a bit rainy, but the museums were excellent."
    }
```

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch:

   ```bash
   git checkout -b feature/YourFeature
   ```
3. Commit your changes:

   ```bash
   git commit -m "feat: description"
   ```
4. Push to the branch:

   ```bash
   git push origin feature/YourFeature
   ```
5. Open a Pull Request

---
