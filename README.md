# Spring Boot & Lambda

A Lambda function 

  - Written in Jaba & Spring Boot
  - Connecting to AWS RDS `PostgreSQL`

### Package

Run the command:
```sh
$ mvn clean package shade:shade
```
### NOTE 
Spring boot running on Lmabda but not efficiently because every request will load the entire application, if anyone have a solution for this you can participate and commit changes.
