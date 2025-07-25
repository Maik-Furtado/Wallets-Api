# Wallets-Api
> This Spring Boot API simulates digital wallets with role-based access, balance verification, and transfer restrictions.

#### Tecnologies ####

+ Java17
+ Spring Boot 3.x
+ Spring Data JPA
+ Hibernate
+ Mysql
+ Maven 3.x
+ Docker and Docker Compose

> Note: This API uses Eclipse Temuirn JDK 17.0.15

### How to Use this API ###

1. Clone the repository:
```
 git clone https://github.com/Maik-Furtado/Wallets-Api.git
 cd Wallets-Api
```
2. Star the application with Docker Compose:
```
docker compose up -d --build
```
### Available Endpints ### 

##### wallet Creation #####
- POST /http://localhost:8080/wallets
- Required body:
  ``` Json
  {
   {
     "fullName":"test",
     "cpfCnpj": "111.444.777-35",
     "email": "user@email.com",
     "password":"12345678",
     "walletType": "USER",
     "balance":999
 }
}

#### Transfer Between Wallets ####
- POST /http://localhost:8080/transfers
- Required Body
```
{
"value": 1,
"payer": 12, 
"payee": 11 
}
```
> Only USER wallets can make transfers. MERCHANT wallets cannot transfer money, only receive it.

### Additional Details: ###
- CPF/CNPJ validator
- Balance availability
- Transaction authorization rules
- Simple error hanling and logging

Swagger/OpenAPI documentation is available in the project.
with the project started by docker access

http://localhost:8080/swagger-ui/index.html




