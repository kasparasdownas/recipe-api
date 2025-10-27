# Recipe API

![Build](https://github.com/kasparasdownas/recipe-api/actions/workflows/maven.yml/badge.svg)

A simple **Java Spring Boot REST API** for storing and retrieving recipes and their ingredients.  
Built to demonstrate clean code, layered architecture, and CI/CD with GitHub Actions.

---

## Features
- Add and fetch recipes with ingredients
- Uses **Spring Boot 3**, **Spring Data JPA**, and **H2 in-memory DB**
- Auto-generates tables and sample data on startup (`data.sql`)
- **Swagger UI** for testing endpoints
- Includes **CI/CD pipeline** with Maven & GitHub Actions

---

## Tech Stack
- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Swagger / OpenAPI
- GitHub Actions (CI/CD)

---

## Getting Started

### 1. Clone the repo
```bash
git clone https://github.com/kasparasdownas/recipe-api.git
cd recipe-api