# **EV Route Optimization App**

## **Overview**
The EV Route Optimization App is a multi-repository project designed to help electric vehicle (EV) users find the most energy-efficient routes, locate charging stations, and optimize their travel plans to balance speed and energy consumption. The project consists of separate repositories for the frontend (web), mobile app, backend, and machine learning services.

## **Repositories**

- **Frontend (Angular)**: [ev-route-optimization-frontend](https://github.com/felixojiambo/ev-route-optimization-frontend)
- **Mobile App (Flutter)**: [ev-route-optimization-mobile](https://github.com/felixojiambo/ev-route-optimization-mobile)
- **Backend (Spring Boot)**: [ev-route-optimization-backend](https://github.com/felixojiambo/ev-route-optimization-backend)
- **Machine Learning/AI (Python)**: [ev-route-optimization-ml](https://github.com/felixojiambo/ev-route-optimization-ml)

## **Key Features**
- **Route Optimization:** Provides energy-efficient routes considering real-time traffic and road conditions.
- **Charging Station Locator:** Displays nearby charging stations with availability.
- **Predictive Energy Consumption:** Machine learning models predict energy use for trips.
- **Real-time Updates:** Dynamic routing based on live traffic data.
- **User-Friendly Interfaces:** Available via a web app and a mobile app.

## **Project Structure**

### **1. Frontend (Angular)**
   - **Repository:** [ev-route-optimization-frontend](https://github.com/felixojiambo/ev-route-optimization-frontend)
   - **Purpose:** Provides a responsive web interface for trip planning and user management.
   - **Technologies:** Angular, Angular Material, RESTful services.
   - **Setup:** See the [Frontend README](https://github.com/felixojiambo/ev-route-optimization-frontend) for installation and usage.

### **2. Mobile App (Flutter)**
   - **Repository:** [ev-route-optimization-mobile](https://github.com/felixojiambo/ev-route-optimization-mobile)
   - **Purpose:** Cross-platform mobile app for on-the-go route planning and updates.
   - **Technologies:** Flutter, Dart, RESTful services.
   - **Setup:** See the [Mobile README](https://github.com/felixojiambo/ev-route-optimization-mobile) for installation and usage.

### **3. Backend (Spring Boot)**
   - **Repository:** [ev-route-optimization-backend](https://github.com/felixojiambo/ev-route-optimization-backend)
   - **Purpose:** Centralized backend managing user data, trip planning logic, and API integration.
   - **Technologies:** Spring Boot, PostgreSQL/MongoDB, Spring Security, RESTful APIs.
   - **Setup:** See the [Backend README](https://github.com/felixojiambo/ev-route-optimization-backend) for installation and usage.

### **4. Machine Learning/AI (Python)**
   - **Repository:** [ev-route-optimization-ml](https://github.com/felixojiambo/ev-route-optimization-ml)
   - **Purpose:** Provides predictive analysis and route optimization through machine learning models.
   - **Technologies:** Python, TensorFlow/PyTorch, Flask/FastAPI.
   - **Setup:** See the [ML README](https://github.com/felixojiambo/ev-route-optimization-ml) for installation and usage.

## **Overall Setup and Integration**

### **Prerequisites**
- **Java 11** or later (for Spring Boot)
- **Node.js** and **npm** (for Angular)
- **Flutter SDK** (for mobile app)
- **Python 3.7** or later (for ML/AI)
- **PostgreSQL** or **MongoDB** (for the backend database)
- **Google Maps API Key** and Charging Station API keys

### **Step 1: Clone the Repositories**
Clone each repository into your local development environment:
```bash
# Clone the Frontend repo
git clone https://github.com/felixojiambo/ev-route-optimization-frontend.git

# Clone the Mobile repo
git clone https://github.com/felixojiambo/ev-route-optimization-mobile.git

# Clone the Backend repo
git clone https://github.com/felixojiambo/ev-route-optimization-backend.git

# Clone the ML repo
git clone https://github.com/felixojiambo/ev-route-optimization-ml.git
```

### **Step 2: Backend Setup**
1. Navigate to the backend directory:
   ```bash
   cd ev-route-optimization-backend
   ```
2. Build and run the Spring Boot application:
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```
3. Configure the database connection in `application.properties`.

### **Step 3: Frontend Setup**
1. Navigate to the frontend directory:
   ```bash
   cd ../ev-route-optimization-frontend
   ```
2. Install dependencies and start the Angular application:
   ```bash
   npm install
   ng serve
   ```
3. Access the web app at `http://localhost:4200`.

### **Step 4: Mobile App Setup**
1. Navigate to the mobile app directory:
   ```bash
   cd ../ev-route-optimization-mobile
   ```
2. Install dependencies and run the app:
   ```bash
   flutter pub get
   flutter run
   ```

### **Step 5: Machine Learning/AI Setup**
1. Navigate to the ML directory:
   ```bash
   cd ../ev-route-optimization-ml
   ```
2. Create a virtual environment and install dependencies:
   ```bash
   python3 -m venv venv
   source venv/bin/activate
   pip install -r requirements.txt
   ```
3. Run the Flask/FastAPI server:
   ```bash
   python app.py
   ```

### **Step 6: Integration**
- Ensure that the backend is correctly calling the ML service for predictive analysis.
- Confirm that the frontend and mobile app are making proper API requests to the backend.

## **Contributing**
Contributions are welcome! Please see the respective repository's `README` for contribution guidelines.

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file in each repository for details.

## **Contact**
For any questions or support, please open an issue in the relevant repository or contact us at [your-email@example.com](mailto:felixojiamboe@gmail.com).
