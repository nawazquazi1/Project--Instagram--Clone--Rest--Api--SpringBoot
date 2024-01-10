# Instagram Clone Rest API

## Overview

The Instagram Clone Rest API is a Spring Boot-based project designed to replicate core functionalities of the popular social media platform Instagram. It includes features such as user authentication, posting images, managing likes and comments, following other users, and real-time chat functionality using Spring WebSocket.

### Technologies Used

- **Java Spring Framework (version 3.0.9):**
  - Spring Boot for rapid development and easy configuration.
  - Spring Security for authentication and authorization.
  - Spring Data JPA for interacting with the MySQL database.
  - Spring WebSocket for real-time chat functionality.

- **Database:**
  - MySQL for data storage and retrieval.
  - Hibernate as the Object-Relational Mapping (ORM) tool for seamless database interactions.

- **API Documentation:**
  - Swagger for clear and interactive API documentation.

## Key Features

1. **Authentication and Authorization:**
   - Secure authentication system using Spring Security.
   - Utilization of JSON Web Tokens (JWT) for token-based authorization.

2. **User Management:**
   - `AuthController` for user registration, login, and token generation.
   - `UserController` for managing user profiles and account details.

3. **Post Management:**
   - `PostController` for handling post creation, retrieval, and updates.
   - Support for uploading post images.
   - Features include post likes, comments, and sharing.

4. **Like Controller:**
   - `LikeController` for handling post likes.
   - Users can like and unlike posts.

5. **Comment Controller:**
   - `CommentController` for managing post comments.
   - Features include adding, editing, and deleting comments.

6. **Follow Controller:**
   - `FollowController` to handle user following and follower management.
   - Users can follow and unfollow other users.

7. **Chat Functionality:**
   - Integration of Spring WebSocket for real-time user-to-user and group chat.
   - `UserChatController` for managing individual user chats.
   - `GroupChatController` for handling group chats.

8. **Instagram-like Stories:**
   - Features for users to create and view stories.
   - Stories automatically expire after a certain time.

9. **Swagger API Documentation:**
   - Utilization of Swagger to automatically generate API documentation.
   - Comprehensive and interactive API documentation interface for developers.

## Project Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot.git

 2. **Database Configuration:**
    - Create a MySQL database named instagram_clone. 
    - Update the application.properties file with your database configuration.  

3. **Run the Application:**
   ```bash
   ./mvnw spring-boot:run

4. **Access Swagger UI:**
   - Open your web browser and navigate to
  ```bash
 http://localhost:8080/swagger-ui.html for interactive API documentation.

![Screenshot (14)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/1ec82938-b6bd-4a8f-9cb2-784995a373b3)
![Screenshot (13)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/4abe2499-aa09-4f38-b5b0-b816c4baa743)
![Screenshot (12)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/d8dd7e2f-0558-48e1-8299-86eb1dc615d6)
![Screenshot (11)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/a03116e9-4653-4a35-aa4d-e21bc1984b2e)
![Screenshot (10)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/ee891bc9-aedf-4048-9f44-24609cde03b5)
![Screenshot (9)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/9afba410-601c-49c4-9340-d12b3da6f30a)
![Screenshot (8)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/d69ed385-d5c4-4d15-81e4-e8fe70f939e3)
![Screenshot (7)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/e6e49ee1-8ab0-44be-9bc8-6bf813da5510)
![Screenshot (6)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/ce732569-b4aa-426f-b795-d52374c578d7)
![Screenshot (5)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/b970e003-2a83-430f-aae9-f78b5a95f22b)
![Screenshot (4)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/e2761191-bd66-4f5a-b1d9-64fd892ab2f6)
