# payara-embedded-web and integration-test with jax-rs client

## Simple integration test

  * build a Client (ClientBuilder.newClient())
  * call get on url
  * expected some sort of output (given a internet connection)

## Issue

Adding payara-embedded-(web|all) as a "provided" dependency

Your integration testing blows up (when running jax-rs client against fx. wiremock)

payara-embedded-all is needed for: fish.payara.cdi.jsr107.impl.NamedCache annotation

## Demonstration

I've made 2 profiles in the `pom.xml` switched on the property
`payara-embedded-web`=(`true`|`false`) to either include or exclude
the payara-embedded-web dependency.

Run with `mvn clean verify -Dpayara-embedded-web=false` succeeds

Run with `mvn clean verify -Dpayara-embedded-web=true` throws up with an 
`java.lang.IllegalStateException: Service fish.payara.nucleus.requesttracing.RequestTracingService was started at level -2 but it has a run level of 10.` exception
