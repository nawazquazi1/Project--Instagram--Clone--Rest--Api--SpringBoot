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
 ![Screenshot (14)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/fb76c1f6-5308-4341-93b0-dbad75791de1)
![Screenshot (13)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/2ff564db-cdf9-487e-b910-42fe6e97925f)
![Screenshot (12)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/6ef5af22-041f-44e0-9890-3479d58f0c1a)
![Screenshot (11)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/e5c91042-c54a-4229-92e9-44e7831e4c4d)
![Screenshot (10)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/ef07f750-5942-4736-ae36-53c7044b42b7)
![Screenshot (9)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/cd05f834-d4e9-4197-946d-e37dc130f9c2)
![Screenshot (8)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/deaf10a4-7608-490b-a475-56e209469f6e)
![Screenshot (7)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/edcc3c99-5123-41c8-a2c7-20fc7d85ef01)
![Screenshot (6)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/0d3087a6-b353-4837-8fab-88caeea80768)
![Screenshot (5)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/1dd81d1d-185f-4370-985d-d9fb232b561f)
![Screenshot (4)](https://github.com/nawazquazi1/Project--Instagram--Clone--Rest--Api--SpringBoot/assets/111976978/5c2a779d-329d-41e3-a11b-7a8e4c5debbe)
 http://localhost:8080/swagger-ui.html for interactive API documentation.
