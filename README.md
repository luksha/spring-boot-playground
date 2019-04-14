# spring-boot-playground

Requirements:

- A boot JAR using spring boot.
- Rest endpoints that can return a `JSON` response.
- Endpoint that returns an HTML page with a model from java using `thymeleaf`
- Models should be picked up from DB using `JPA` we will use `Hibernate`.
- Must have `unit-test` and `mockMVC` tests.
- For the models you should use an `SQL` db recommended `MySql`
- The endpoints should be secured with basic auth and the user data should be on a in memory db like `H2`

Extra points:
- Make the db boot in a docker container.
- Configure the db url with a YAML