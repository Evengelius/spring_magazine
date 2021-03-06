[![Spring Boot](https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg)](https://spring.io)

-----------------------------------------------------

# Spring | Magazine

This is a magazine application.


## Getting Started

Spring(boot) takes care of everything on the back end | server side.

<ins>Before going further, please make sure you are processing the repositories in order as follow</ins> : 

* [Spring](https://github.com/Evengelius/spring_magazine)<br />
* [Angular](https://github.com/Evengelius/angular-magazine)<br />

### Installing

```
1. git clone https://github.com/Evengelius/spring_magazine.git your_desired_name

2. // Change the Project SDK version to 14 | Intellij
   File | Project Structure | Project Settings: Project | Project SDK : 14
   
3. Create a database and name it spring_magazine.

4. Import the SQL file present here, in your database.

5. // application.properties
   #Database Connection
    spring.datasource.url= jdbc:mysql://localhost:3306/spring_magazine?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
    spring.datasource.username=yourUsername
    spring.datasource.password=yourPassword

6. Preset credentials => user: admin | password: admin

7. Test it | Postman.
```

## Functionnalities

**CRUD - Create | Read | Update | Delete**<br />
CRUD operations on table :<br />
* User

**Custom Exception handling**<br />
Errors on the server side are handled by various exceptions returning an HTTP status: 400 - 500 - 404.

**Authentication management | Spring Security**<br />
Implementation of the JSON Web Token | JWT : using public key and secret key.

**Data Mapping management**<br />
Implementation of the Data Transfer Object or DTO, with MapStruct.

## API Endpoints | Postman

You need to be authenticated in order to use this endpoint.<br />
We are talking about the api that finds an article by id, and renders it.<br />
<br /><br />

```
GET
       /api/articles/{id}

-----------------------------

Authentication | JWT

POST
       /api/users
POST
       /api/users/login
```

Once logged in, it generates a JWT, that you need to put in, *Authorization | Type : Bearer Token*, in order to access the page that requires an authentication.



## Screenshots | Demo

**Registration**

![Authentication | Register](https://zupimages.net/up/20/43/vktp.png)

**Custom Exception**

![Custom | Exception](https://zupimages.net/up/20/43/987i.png)

**Hibernate | Query**

![Hibernate | Query](https://www.zupimages.net/up/20/29/9jud.png)

**Login | JWT generated**

![Authentication | Login](https://zupimages.net/up/20/43/h2sn.png)

**Authenticated | Show Endpoint**

![Authentication | Authenticated](https://zupimages.net/up/20/43/hmo3.png)
