# Retrofit playground

Experimenting and learning how to use and work with Retrofit!

## Modules

- buildSrc - Contains some convention Gradle plugins used throughout the repo
- app - A barebones application. This is where the retrofit calls are being made from. This can take many forms,
I chose to go as simple (and frameworkless) and go back to my intro to java roots with a while loop to focus on the Retrofit implementation.
- example-service - This is a simple Micronaut application that has a couple endpoints that map to what is in the client, this is what our
application hits. 
- example-client - This is a Retrofit client that we use to make HTTP calls!

## Requirements

You will need 2 terminal sessions to run this example. 

In one session, run `./gradlew :example-service:run`. This will spin up the micronaut application on `localhost:8080`

In the other session, run `./gradlew :app:run` which will spin up our app that we will make HTTP calls from! Just follow the prompts. 