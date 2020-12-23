# Schiphol flight status information application

The main goal is to demonstrate the usage of Apache Kafka with Spring boot framework.

There are two different services in this repository (flight-source and flight-sink)

Flight-source calls Schiphol flight status API and publishes the retrieved data to Kafka topic on confluent cloud
Flight-sink consumes Kafka topic and retrieves data. Currently it prints out in the console. It is planned to use MongoDB cloud as a storage to store the consumed data.

(Uml diagram will come later.)

### Data
Schiphol flight status API is used as the source of the flight status information

* [Schiphol flight status API](https://developer.schiphol.nl/)

### Tech stack

*   Reactive Spring
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

### Remarks

* Go to confluent cloud and create an account. Follow the instructions and get the key and secret for the access [Confluent cloud](https://confluent.cloud/)