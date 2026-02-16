# 🚀 Space Biology Knowledge Engine (NASA BioExplorer)

A comprehensive platform designed to explore and analyze NASA's space biology data. This project leverages a **Spring Boot Backend** for robust data management and AI integration, and a **React Frontend** for an interactive user experience.

---

## 🏗️ Architecture

The project is divided into two main components:
-   **BACKEND**: A Java Spring Boot application that handles business logic, database interactions (PostgreSQL), and AI services (Google GenAI).
-   **FRONTEND**: A React application that provides a modern, responsive UI for users to search, filter, and visualize research data.

---

## 🛠️ Tech Stack

### Backend (Java)
-   **Language**: Java 17
-   **Framework**: Spring Boot 3.5.6
-   **Database**: PostgreSQL
-   **AI Integration**: Google GenAI
-   **Build Tool**: Maven

### Frontend (React)
-   **Framework**: React 18
-   **Styling**: Tailwind CSS
-   **Visualization**: D3.js, Recharts
-   **State Management/Data Fetching**: React Query
-   **Icons**: Lucide React

---

## 🚀 Getting Started

### Prerequisites
Ensure you have the following installed:
-   **Java Development Kit (JDK) 17+**
-   **Node.js** (v16 or higher) & **npm**
-   **PostgreSQL** (running locally or accessible remotely)
-   **Maven** (optional, wrapper provided)

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/Space-Biology-Knowledge-Engine.git
cd Space-Biology-Knowledge-Engine
```

### 2. Backend Setup
1.  Navigate to the backend directory:
    ```bash
    cd BACKEND
    ```
2.  **Configuration**:
    -   Verify `src/main/resources/application.properties` (or `application.yml`) for database credentials.
    -   Ensure your PostgreSQL database is running and verify the connection details.
3.  **Run the Application**:
    ```bash
    # Using Maven Wrapper (Windows)
    ./mvnw spring-boot:run
    
    # Using Maven Wrapper (Linux/Mac)
    ./mvnw spring-boot:run
    ```
    The backend server usually runs on `http://localhost:8080`.

### 3. Frontend Setup
1.  Navigate to the frontend client directory:
    ```bash
    cd FRONTEND/client
    ```
2.  **Install Dependencies**:
    ```bash
    npm install
    ```
3.  **Start the Development Server**:
    ```bash
    npm start
    ```
    The frontend will launch at `http://localhost:3000`.

---

## ✨ Features

-   **Advanced Search**: Filter research papers by organism, environment, year, and more.
-   **AI-Powered Insights**: Generate summaries and extract key findings from research papers.
-   **Interactive Visualizations**: Explore connections between research topics using D3.js knowledge graphs.
-   **Data Export**: Download summaries and reports in PDF or CSV formats.

---

## 🤝 Contributing
Contributions are welcome! Please follow these steps:
1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/YourFeature`).
3.  Commit your changes.
4.  Push to the branch and open a Pull Request.

---

## 📄 License
[MIT License](LICENSE)
