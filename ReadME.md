# SPRING BOOT & JPA & HIBERNATE
## APPLICATION: APP USER and DETAILS MANAGEMENT
### Part 1 - Setup:
* Initialize a new Spring Boot project with following required dependencies:
* Spring Web
* Spring Data JPA
* MySQL Driver
* H2 Database (for testing)
* Make sure you have created a database in MySQL.
* Configure your production MySQL DataSource with application.properties file.
* Change pom.xml H2 dependency to be active in test by changing: <scope>runtime</scope> → <scope>test</scope>
* Create resources directory in test directory.(Should come up as a suggestion once you right click test folder)
* Configure your H2 database with an application.properties file added in the resource folder under the test folder. (will override the other application.properties file for your tests.)
* Verify that you application starts without errors.

### Part 2 – Adding AppUser and Details entities
1. Create a package for your entity models
2. Create classes AppUser and Details according to Table 1
3. Turn Details into an entity
4. Turn AppUser into an entity
5. Set up the OneToOne relationship
6. Create a package (repository) for the Interfaces.
7. Create interfaces and follow the repository requirments.
8. Test implementations of Repositories.

#### AppUser requirements:
* id generated with the identity strategy
* username need to be unique
#### Details requirements:
* id generated with identity strategy
* email need to be unique
#### AppUserRepository requirements:
* Basic CRUD Operations.
* Find a user by Username.
* Find users by registration date between two specific dates.
* Find users by details id.
* Find user by email ignore case.
* (Optional)Add more as needed.
#### DetailsRepository requirements:
* Basic CRUD Operations.
* Find a details by email.
* Find details by name contains.
* Find details by name ignore-case.
* (Optional)Add more as needed.