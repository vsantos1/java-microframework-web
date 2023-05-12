# Web micro-framework with Java

<div align="center">
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="128" />
</div>

## Project description (en-US)

This project is a **web framework** with Servlet specifications.
Very simple micro-framework that allows built a web API with new features.
This project was developed for learn purposes, not meant to be used in production.

- Provides Response builder, Web Standard enums, Crud interface for database access, routing, JSON parser, file upload
  (**DISK ONLY**) and more.
- Provides a simple way to create a web application for study cases.

- ⚠️ **WARNING**: This project is not meant to be used in production, it is only for study purposes.

## Descrição do projeto (pt-BR)

Este projeto é um **micro-framework** web com as especificações do Servlet. É um micro-framework que permite construir e facilitar API Rest, mas, este projeto foi desenvolvido para fins de aprendizagem e não é destinado a ser usado em
produção.

- Fornece um construtor de resposta, enums padrão da Web, interface Crud para acesso ao banco de dados, roteamento,
  parser JSON, envio de arquivos (APENAS EM DISCO) e muito mais.

- Fornece uma maneira simples de criar uma aplicação web para fins didáticos.

⚠️ ATENÇÃO: Este projeto não é destinado a ser usado em produção, é apenas para fins de estudo.

# Technologies used in this project

- [x] [Servlet](https://jakarta.ee/specifications/servlet/4.0/apidocs/)
- [x] [Java](https://www.java.com/)
- [x] [MySQL](https://www.mysql.com/)

## Requirements

- [x] [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [x] [Tomcat](https://tomcat.apache.org/) (needed for the deployment of the application)
- [x] [Maven](https://maven.apache.org/)
- [x] [Docker](https://www.docker.com/) (optional)

## Features

- [x] Database connection [Hibernate](https://hibernate.org/)
- [x] Json serialization
- [x] Migration runner
- [x] Json deserialization
- [x] Object mapper
- [x] Generic DAO (Data Access Object) for database access
- [x] Encryption handler
- [x] Yaml configuration file
- [x] Handle all File upload types (**Disk only**)
- [x] Multiple Files upload (**Disk only**)
- [x] HTTP handler [Servlet](https://jakarta.ee/specifications/servlet/6.0/apidocs/)
- [x] Response builder

## Application configuration example

```yaml
# Dialects: https://docs.jboss.org/hibernate/orm/5.4/javadocs/org/hibernate/dialect/package-summary.html
dialect: org.hibernate.dialect.MySQL5Dialect
# Driver class name: https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-jdbc-url-format.html
driverClassName: com.mysql.cj.jdbc.Driver
# Database connection host
host: localhost
# Database connection port
port: 3306
# Database connection username
username: ${DB_USERNAME}
# Database connection password
password: ${DB_PASSWORD}
# Database connection url (jdbc:driver://host:port/database)
url: jdbc:mysql://localhost:3306/hireme?serverTimezone=UTC
# Hibernate configuration (create,create-drop, update, validate, none)
ddl: update
# Hibernate format sql
formatSql: false
# Hibernate show sql
showSql: true
```

### ⚠️ **WARNING**: This project is not meant to be used in production, it is only for study purposes.

I made it for fun and to learn more about Java.



