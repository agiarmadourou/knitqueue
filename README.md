# KnitQueue

KnitQueue is a backend-first application designed to help knitters organize project ideas,
manage ongoing and future projects, and keep a single shopping list for their knitting supplies.

The idea behind KnitQueue is to make knitting project planning simple: capture inspiration, 
decide what to knit next, and keep track of what needs to be purchased without the overhead 
of a detailed inventory system.

## Features

The application is designed to support:

- Knitting projects with four states: `IDEA`, `UP_NEXT`, `WIP` (work in progress), and `FINISHED`.
- Project notes, reference links, and images.
- Project filtering by state and case-insensitive search by name.
- A unified shopping list with standalone items or items linked to a project.
- Marking shopping items as purchased.
- Individual user accounts with private projects and shopping lists.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- JUnit and Mockito (unit testing)

## Architecture

KnitQueue follows a layered architecture with REST controllers, services, and Spring Data JPA repositories. 
The PostgreSQL database schema is defined in SQL and mapped to three JPA entities:
AppUser, Project, and ShoppingItem.

## Development Status

KnitQueue is currently under active development.

**Implemented:**

- PostgreSQL database schema, JPA entities, and repositories.
- Core service-layer operations for users, projects, and shopping lists.
- First REST endpoint for retrieving a project.
- Initial unit tests with JUnit and Mockito.

**Upcoming:**

- Remaining REST endpoints and error handling.
- Authentication and authorization with Spring Security.
- Additional automated tests.
- A simple user interface.


## Motivation

As both a knitter and a software developer interested in backend development, 
I wanted to build an application around a problem I encounter in my everyday life. 
KnitQueue also gives me the opportunity to apply relational database design, 
persistence, business logic, and REST API development in an independent end-to-end project.
