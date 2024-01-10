Instagram Clone Rest API
Overview
The Instagram Clone Rest API is a Spring Boot-based project designed to replicate core functionalities of the popular social media platform Instagram. It includes features such as user authentication, posting images, managing likes and comments, following other users, and real-time chat functionality using Spring WebSocket.

Technologies Used
Java Spring Framework (version 3.0.9):

Spring Boot for rapid development and easy configuration.
Spring Security for authentication and authorization.
Spring Data JPA for interacting with the MySQL database.
Spring WebSocket for real-time chat functionality.

Database:
MySQL for data storage and retrieval.
Hibernate as the Object-Relational Mapping (ORM) tool for seamless database interactions.

API Documentation:
Swagger for clear and interactive API documentation.

Key Features

Authentication and Authorization:
Secure authentication system using Spring Security.
Utilization of JSON Web Tokens (JWT) for token-based authorization.

User Management:
AuthController for user registration, login, and token generation.
UserController for managing user profiles and account details.

Post Management:
PostController for handling post creation, retrieval, and updates.
Support for uploading post images.
Features include post likes, comments, and sharing.

Like Controller:
LikeController for handling post likes.
Users can like and unlike posts.

Comment Controller:
CommentController for managing post comments.
Features include adding, editing, and deleting comments.

Follow Controller:
FollowController to handle user following and follower management.
Users can follow and unfollow other users.

Chat Functionality:
Integration of Spring WebSocket for real-time user-to-user and group chat.
UserChatController for managing individual user chats.
GroupChatController for handling group chats.

Instagram-like Stories:
Features for users to create and view stories.
Stories automatically expire after a certain time.

Swagger API Documentation:
Utilization of Swagger to automatically generate API documentation.
Comprehensive and interactive API documentation interface for developers.

Project Setup
Clone the Repository:
git clone https://github.com/yourusername/instagram-clone-api.git

Database Configuration:
Create a MySQL database named instagram_clone.
Update the application.properties file with your database configuration.

Run the Application:
./mvnw spring-boot:run

Access Swagger UI:
Open your web browser and navigate to http://localhost:8080/swagger-ui.html for interactive API documentation.

Future Enhancements
This project can be expanded in the future with additional features such as direct messaging, image and video uploads in chat, explore functionality, notifications, and more, to further enhance the Instagram-like experience.

License
This project is licensed under the MIT License - see the LICENSE file for details.

