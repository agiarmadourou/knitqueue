# KnitQueue

KnitQueue is a backend-first application designed to help knitters organize project ideas, manage ongoing and future projects, and keep a single shopping list for their knitting supplies.

The idea behind KnitQueue is to make knitting project planning simple: capture inspiration, decide what to knit next, and keep track of what needs to be purchased without the overhead of a detailed inventory system.

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

## Architecture

KnitQueue follows a layered architecture, separating data persistence, business logic, and the REST API layer. The relational database schema is defined using SQL and mapped to Java entities through JPA.

The domain model consists of three main entities: `AppUser`, `Project`, and `ShoppingItem`.

## Development Status

KnitQueue is currently under active development.

**Implemented or in progress:**

- PostgreSQL database schema with relational constraints and foreign keys.
- JPA entity mappings and repositories for all three domain entities.
- Service-layer operations for users, projects, and shopping items.
- Project retrieval by user and state, partial-name search, and selective updates to editable project fields.

**Upcoming:**

- REST API endpoints for project and shopping list management.
- Request validation and structured exception handling.
- User registration, authentication, and ownership-based authorization with Spring Security.
- Automated tests.
- A simple user interface.

The service layer is still being developed and tested. The full REST API and user authentication are not yet available.

## Motivation

As both a knitter and a software developer interested in backend development, I wanted to build an application around a problem I encounter in my everyday life. KnitQueue also gives me the opportunity to apply relational database design, persistence, business logic, and REST API development in an independent end-to-end project.
