# Online Wallet

Simple user friendly web application to control your finances.

Made on [Bootstrap 5.2](https://getbootstrap.com/) and [Spring Boot](https://spring.io/)

By Miroslav Vetrov

## Installation

### Requirements

1) This application is using **postgresql** database. Install it.

2) Also, you need to install **git** and **maven**.

3) This app is using JDK 17
### Installation

Clone repository:

```bash
git clone https://github.com/VetrovMilka/online-wallet.git
```

To get this application working you shoud set up ```application.properties``` file:

```properties
# HOSTNAME
hostname=localhost:8080
# DATABASE CONNECT
spring.datasource.url=jdbc:postgresql://localhost:5432/online_wallet
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
# CSRF
spring.freemarker.expose-request-attributes=true
# HIBERNATE
spring.jpa.generate-ddl=false
spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
spring.flyway.create-schemas=true
spring.flyway.clean-on-validation-error=true
# SMTP MAIL
spring.mail.host=smtp.gmail.com
spring.mail.username=miroslav.vetrov2003@gmail.com
spring.mail.password=pphimimechvvspvn
spring.mail.port=465
spring.mail.protocol=smtps
mail.debug=true
# SPRING SESSION JDBC
spring.session.jdbc.initialize-schema=always
spring.session.jdbc.table-name=SPRING_SESSION
```

After setting up ```application.properties``` you can run application, or build artifacts with:

1) In right side of the screen enter Maven ("M")
2) Online wallet -> Lifecycle -> Clean
3) Select class CourseworkApplication
4) Run