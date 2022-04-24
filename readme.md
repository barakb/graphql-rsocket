
### Example of Graph
* http://localhost:8080/actuator
* http://localhost:8080/graphiql
* http://localhost:8080/graphql
* https://docs.spring.io/spring-boot/docs/2.7.0-SNAPSHOT/reference/html/messaging.html#messaging.rsocket.server-auto-configuration
* https://docs.spring.io/spring-graphql/docs/1.0.0-RC1/reference/html/#server-transports
* https://github.com/spring-projects/spring-graphql
* https://spring.io/blog/2022/04/20/spring-for-graphql-1-0-rc1-released

```shell
java -jar rsc.jar --request --route=graphql --dataMimeType="application/graphql+json" --data='{"query":"{\n  greeting \n}"}' --debug ws://localhost:8080/rsocket
java -jar rsc.jar --request --route=graphql --dataMimeType="application/graphql+json" --data='{"query":"{\n  callGreeting \n}"}' --debug ws://localhost:8080/rsocket
java -jar rsc.jar --stream --route=graphql --dataMimeType="application/graphql+json" --data='{"query":"subscription { integers }"}' --debug ws://localhost:8080/rsocket
```


```shell
mvn spring-boot:run
```