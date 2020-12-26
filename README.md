# Schiphol flight status information application

The main goal is to demonstrate the usage of Apache Kafka with Spring boot framework. This application simulates a complex version of services for retrieving and processing flight status information. Trying to use different technologies and concepts on the way to try out them within a single application idea. Feel free to comment and contribute.

There are three different services in this repository (flight-source, flight-sink and flight-status-rest)

*   Flight-source calls Schiphol flight status API and publishes the retrieved data to Kafka topic on confluent cloud
*   Flight-sink consumes Kafka topic and retrieves data. Currently it prints out in the console. It is planned to use MongoDB cloud as a storage to store the consumed data. The reactive mongo client for spring boot is used to achieve reactiveness.
*   Flight-status-rest for retrieving the flight status information from mongodb and serving the response to the clients. Spring webflux will be used.

(Uml diagram will come later.)

### Data
Schiphol flight status API is used as the source of the flight status information

* [Schiphol flight status API](https://developer.schiphol.nl/)

### Tech stack

*   Reactive Spring (Webflux)
*   Spring cloud stream
*   Apache Kafka
*   Confluent cloud
*   MongoDB 

### Version guide

*   In version 1 all logic is inside the main application class. In the later versions, the application logic will be divided into separate modules/classes

### TODO

*   Add unit test cases
*   Create functional endpoints for controller level
*   Retrieve data at constant time intervals (I want to retrieve the latest status flights within 10 minutes)
*   A separate README for each application will be created.

### Remarks

* Go to confluent cloud and create an account. Follow the instructions and get the key and secret for the access [Confluent cloud](https://confluent.cloud/)
* Before connecting to the mongodb cluster on atlas, do not forget to use -Djdk.tls.client.protocols=TLSv1.2 JVM argument
