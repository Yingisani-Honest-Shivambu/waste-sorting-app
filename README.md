⸻

♻️ Waste Sorting API

A Spring Boot REST API for managing Waste Categories, Disposal Guidelines, and Recycling Tips.

This API allows CRUD operations on these entities and is backed by an H2 in-memory database.

⸻

📌 Features

✔️ Manage Waste Categories (Create, Read, Update, Delete)
✔️ Manage Disposal Guidelines (Linked to waste categories)
✔️ Manage Recycling Tips (Linked to waste categories)
✔️ H2 Database Integration
✔️ Swagger API Documentation
✔️ Postman API Testing

⸻

📦 Tech Stack
	•	Java 17
	•	Spring Boot 3.3.9
	•	Spring Data JPA
	•	Spring Web
	•	Spring Boot DevTools
	•	H2 Database
	•	Lombok
	•	Swagger (Springdoc OpenAPI 2.0.2)

⸻

🚀 Getting Started

1️⃣ Clone the Repository

git clone https://github.com/Yingisani-Honest-Shivambu/Enviro365_Waste_Management.git
cd waste-sorting-api



⸻

2️⃣ Setup & Run the Application

Using Maven

mvn clean install
mvn spring-boot:run

Using IntelliJ or VS Code
	1.	Open the project in IntelliJ IDEA or VS Code
	2.	Navigate to WasteSortingAppApplication.java
	3.	Click Run

⸻

🛠 API Endpoints

🌍 Waste Categories

| Method	| Endpoint	                      |Description                    |
|---------------|-------------------------------------|-------------------------------|
|POST	        |/wastemanagementapi/categories	      |Create a new waste category    |
|GET	        |/wastemanagementapi/categories	      |Get all waste categories       |
|GET	        |/wastemanagementapi/categories/{id}  |Get a category by ID           |
|PUT	        |/wastemanagementapi/categories/{id}  |Update a waste category        |
|DELETE         |/wastemanagementapi/categories/{id}  |Delete a waste category        |



⸻

🗑️ Disposal Guidelines

| Method	| Endpoint	                      |Description                    |
|---------------|-------------------------------------|-------------------------------|
|POST		|/wastemanagementapi/guidelines	      |Create a new disposal guideline|
|GET		|/wastemanagementapi/guidelines       |Get all disposal guidelines    |
|GET		|/wastemanagementapi/guidelines/{id}  |Get a guideline by ID          |
|PUT		|/wastemanagementapi/guidelines/{id}  |Update a disposal guideline    |
|DELETE		|/wastemanagementapi/guidelines/{id}  |Delete a disposal guideline    |



⸻

♻️ Recycling Tips

| Method	| Endpoint	                      |Description                    |
|---------------|-------------------------------------|-------------------------------|
POST	/wastemanagementapi/tips	Create a new recycling tip
GET	/wastemanagementapi/tips	Get all recycling tips
GET	/wastemanagementapi/tips/{id}	Get a recycling tip by ID
PUT	/wastemanagementapi/tips/{id}	Update a recycling tip
DELETE	/wastemanagementapi/tips/{id}	Delete a recycling tip



⸻

🛠 Database Configuration

The application uses an H2 in-memory database.
To access the H2 Console:
	•	URL: http://localhost:8081/h2-console
	•	JDBC URL: jdbc:h2:mem:testdb
	•	Username: sa
	•	Password: (leave blank)

To check tables, run:

SELECT * FROM WASTE_CATEGORIES;
SELECT * FROM DISPOSAL_GUIDELINES;
SELECT * FROM RECYCLING_TIPS;



⸻

📖 API Documentation (Swagger)
	•	Swagger UI: http://localhost:8081/swagger-ui.html
	•	OpenAPI JSON: http://localhost:8081/v3/api-docs

⸻

📮 Postman Collection

You can import the Postman Collection from this GitHub repository:
📌 Postman Collection Link:
Waste Sorting API Postman Collection

⸻

👨‍💻 Contributors
	•	Yingisani Honest Shivambu (Project Developer)
	•	GitHub: Yingisani-Honest-Shivambu

⸻
