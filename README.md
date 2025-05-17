# 📚 Library Management System - Design Pattern Overview

This project is a modular library system that applies multiple design patterns and adheres to the SOLID principles. It allows users to borrow various types of books (eBooks, physical, premium, historical) while handling borrow requests through a structured approval chain.

---

## 🧱 Design Patterns Used

### 1. **Strategy Pattern (via `BookInterface`)**

- **Implemented In:**
  - `BookInterface.java`
  - `Book.java`
  - `EBook.java`
  - `PhysicalBook.java`
  - `HistoricalBook.java`

- **Purpose:**
  - Encapsulates the common book operations and allows defining different types of books without changing the client code.

- **SOLID Principle:**
  - **Open/Closed Principle**: New book types can be added without modifying existing code.
  - **Liskov Substitution Principle**: All classes implementing `BookInterface` can be used interchangeably.

---

### 2. **Decorator Pattern**

- **Implemented In:**
  - `PremiumBookDecerator.java`

- **Purpose:**
  - Adds extra functionality (like 10 additional days for premium users) to eBooks without modifying their code.

- **SOLID Principle:**
  - **Open/Closed Principle**: Adds behavior without modifying original class.
  - **Single Responsibility Principle**: Keeps core book behavior and extended behavior separate.

---

### 3. **Chain of Responsibility Pattern**

- **Implemented In:**
  - `BookRequestHandler.java`
  - `LibrarianHandler.java`
  - `ManagerHandler.java`
  - `DirectorHandler.java`

- **Purpose:**
  - Delegates borrow approval based on number of requested days.
    - **Librarian**: ≤ 7 days  
    - **Manager**: 8–14 days  
    - **Director**: > 14 days

- **SOLID Principle:**
  - **Single Responsibility Principle**: Each handler handles only its specific logic.
  - **Open/Closed Principle**: New handlers can be added without affecting existing ones.

---

### 4. **Factory Pattern**

- **Implemented In:**
  - `BookFactory.java`

- **Purpose:**
  - Encapsulates the creation logic for different book types including premium decorators.

- **SOLID Principle:**
  - **Single Responsibility Principle**: Centralizes book creation logic.
  - **Open/Closed Principle**: Easily extended for new types of books.

---

### 5. **Adapter Pattern (Optional/Extensible)**

- **Suggested In:**
  - `ExternalBook.java`

- **Purpose:**
  - Could be adapted to conform to `BookInterface` to integrate third-party or external book APIs.

- **(Not Yet Implemented)**: Would require an adapter class like `ExternalBookAdapter` to fit into the system.

---

## 📄 Files Summary

| File | Purpose | Design Pattern |
|------|---------|----------------|
| `BookInterface.java` | Common book behavior | Strategy |
| `Book.java` | Concrete book class | Strategy |
| `EBook.java`, `PhysicalBook.java`, `HistoricalBook.java` | Different book types | Strategy |
| `PremiumBookDecerator.java` | Enhances eBook behavior | Decorator |
| `BookRequestHandler.java` | Abstract handler | Chain of Responsibility |
| `LibrarianHandler.java`, `ManagerHandler.java`, `DirectorHandler.java` | Concrete approval handlers | Chain of Responsibility |
| `BookRequest.java` | Encapsulates borrow request | - |
| `BookFactory.java` | Creates various book types | Factory |
| `ExternalBook.java` | Represents third-party data model | Adapter (potential) |
| `LibraryService.java` | Manages book operations and approval chain | - |
| `Main.java` | Application entry point | - |

---

## ✅ SOLID Principle Coverage

| Principle | How it's Achieved |
|----------|--------------------|
| **S - Single Responsibility** | Book logic, request handling, and user management are separated. |
| **O - Open/Closed** | New book types, handlers, or decorators can be added without modifying existing code. |
| **L - Liskov Substitution** | All `BookInterface` implementations behave predictably in place of one another. |
| **I - Interface Segregation** | The `BookInterface` is clean and minimal. |
| **D - Dependency Inversion** | Client code depends on `BookInterface` abstraction, not concrete book types. |

---

## 📌 Example Scenario

- A user requests to borrow an **eBook** for **10 days**.
- The `LibraryService` sends a `BookRequest` through the chain:
  - **LibrarianHandler**: skips (too long)
  - **ManagerHandler**: handles request and approves
- If it's a **PremiumBook**, extra behavior is added via `PremiumBookDecerator`.

---

## 📦 Future Enhancements

- Implement `ExternalBookAdapter` to support third-party book formats.
- Add persistence (database or file storage).
- Add a GUI or REST API on top of the service layer.
- Implement logging using Observer or Command pattern.

---

