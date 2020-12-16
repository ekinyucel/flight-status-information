# Schiphol flight status information application

The main goal is to demonstrate the usage of Apache Kafka with Spring boot framework.
There is one producer which retrieves data from Schiphol API
There is one consumer which reads the topic and prints the data.

### Data
Schiphol flight status API is used as the source of the flight status information

* [Schiphol flight status API](https://developer.schiphol.nl/)

### Tech stack

*   Reactive Spring
*   Spring cloud stream
*   Apache Kafka
*   Confluent cloud

### Version guide

*   In version 1 all logic is inside the main application class. In the later versions, the application logic will be divided into separate modules/classes

### TODO

*   Add unit test cases
*   Functional routing&handlers instead of controllers
*   Using non-blocking web client to fetch data from schiphol
*   Retrieve data at constant time intervals (I want to retrieve the latest status flights within 10 minutes)