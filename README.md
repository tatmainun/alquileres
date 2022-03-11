# Alquileres
Proyecto de practica que consiste en un servicio de alquileres

## Tecnologias
- Spring 2.6.4.
- Java 8.
- Cucumber.
- JUnit 5.

## Docker
```
// Ejemplo de imagen
docker run -d -p 33061:3306 --name mysql8 -e MYSQL_ROOT_PASSWORD=secret mysql:8 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
  
// Luego solo basta con levantarlo y bajarlo con
docker start mysql8
docker stop mysql8
```
