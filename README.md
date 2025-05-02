# Phonebook API

Fullstackopen [phonebook backend](https://github.com/justice1k/fullstackopen2) implemented in Java(Springboot)

## Features

- Create new contacts
- Retrieve all contacts
- Get contact by ID
- Update existing contacts
- Delete contacts

## API Endpoints

### GET /api/persons

- Retrieves all contacts
- Response: List of contacts

### GET /api/persons/{id}

- Retrieves a specific contact by ID
- Response: Contact details or 404 if not found

### POST /api/persons

- Creates a new contact
- Request body: Contact object
- Response: Created contact with 201 status

### PUT /api/persons/{id}

- Updates an existing contact
- Request body: Contact object
- Response: Success message or 404 if not found

### DELETE /api/persons/{id}

- Deletes a contact
- Response: Success message or 404 if not found

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Jakarta Persistence
- RESTful API
- MySQL Database

## Setup Instructions

1. Clone the repository
2. Make sure you have Java and Maven installed
3. Navigate to the project directory
4. Run `mvn spring-boot:run`
5. The API will be available at `http://localhost:8080`


