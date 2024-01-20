# Kaiburr Task 1

## Prerequisites

Ensure you have the following tools installed before running the application:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)
- [MongoDB](https://www.mongodb.com/try/download/community)
- [Spring Boot](https://spring.io/projects/spring-boot) 

## API Endpoints

1. **Get All Tasks**
    - **URL:** `/tasks`
    - **Method:** `GET`
    - **Description:** Retrieve the list of all tasks.
<img width="1440" alt="Screenshot 2024-01-12 at 2 35 41 PM" src="https://github.com/Arunodhai/Kaiburr-Tasks/assets/60264218/899eff76-7e5a-4a99-80d8-533445a38927">
<br/><br/><br/><br/>


2. **Get Task by ID**
    - **URL:** `/tasks/{id}`
    - **Method:** `GET`
    - **Description:** Retrieve a specific task by its ID.
<img width="1440" alt="Screenshot 2024-01-12 at 2 36 48 PM" src="https://github.com/Arunodhai/Kaiburr-Tasks/assets/60264218/e2faa236-f566-418f-be86-b4783f7667b2">
<img width="1440" alt="Screenshot 2024-01-12 at 2 38 06 PM" src="https://github.com/Arunodhai/Kaiburr-Tasks/assets/60264218/bd6c2f7b-f336-4ee4-9404-c754a1985e66">
<br/><br/><br/><br/>


3. **Save Task**
    - **URL:** `/tasks`
    - **Method:** `PUT`
    - **Description:** Save a new task. Send a JSON payload in the request body.
<img width="1440" alt="Screenshot 2024-01-12 at 2 32 55 PM" src="https://github.com/Arunodhai/Kaiburr-Tasks/assets/60264218/de85377d-6ecb-487d-9e52-e21923799d10">

<br/><br/><br/><br/>

4. **Delete Task**
    - **URL:** `/tasks/{id}`
    - **Method:** `DELETE`
    - **Description:** Delete a task by its ID.
<img width="1440" alt="Screenshot 2024-01-12 at 2 39 01 PM" src="https://github.com/Arunodhai/Kaiburr-Tasks/assets/60264218/5c21282d-58ba-49cf-92a5-a327f40c33b1">

<br/><br/><br/><br/>

5. **Find Tasks by Name**
    - **URL:** `/tasks/findByName?name={taskName}`
    - **Method:** `GET`
    - **Description:** Find tasks that contain the specified name.
<img width="1440" alt="Screenshot 2024-01-12 at 2 43 45 PM" src="https://github.com/Arunodhai/Kaiburr-Tasks/assets/60264218/a5dd2e42-482b-435e-b08a-995e7e6a0fb0">
<img width="1440" alt="Screenshot 2024-01-12 at 2 44 12 PM" src="https://github.com/Arunodhai/Kaiburr-Tasks/assets/60264218/2be3f7db-f74e-4f70-bf76-579664d724db">

<br/><br/><br/><br/>

6. **Find First 10 Tasks by Assignee**
    - **URL:** `/tasks/findFirst10TasksByAssignee?assignee={assigneeName}`
    - **Method:** `GET`
    - **Description:** Retrieve the first 10 tasks for the specified assignee, sorted by start time.
      
<img width="1440" alt="Screenshot 2024-01-12 at 2 51 49 PM" src="https://github.com/Arunodhai/Kaiburr-Tasks/assets/60264218/9913782a-f9ba-4e7a-8b76-6ecdc7c6a483"><img width="1440" alt="Screenshot 2024-01-12 at 2 52 09 PM" src="https://github.com/Arunodhai/Kaiburr-Tasks/assets/60264218/5d693104-20c8-4b7d-99db-f77c2652f74c">
<br/><br/><br/><br/>

## How to Run

1. Clone this repository.
2. Update MongoDB connection details in `application.yml`.
3. Build the project using `./mvnw clean install`
4. Run the application using `./mvnw spring-boot:run` 

# Dependencies

This project uses the following dependencies:

- [Spring Boot Starter Data MongoDB](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb)
- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- [Project Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
- [Apache Commons Lang](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3)


## Configuration

MongoDB connection details are specified in `application.yml`. Update the `uri` and `database` accordingly.

```yaml
spring:
  data:
    mongodb:
      uri : mongodb+srv://username:password@your-mongodb-uri
      database : YourDatabaseName

