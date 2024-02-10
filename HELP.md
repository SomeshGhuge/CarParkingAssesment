# Parking Lot Management System

This is a simple parking lot management system implemented in Java. It provides functionality to create a parking lot, park cars, leave parking slots, and query parking lot status.



## Table of Contents
* Features 
* Requirements 
* Installation 
* Interacting with the APIs Postman URLs.


### Features
* Creation of a parking lot with a specified capacity. Parking cars and allocating nearest available slots. Leaving parking slots and marking them as available. Retrieving parking lot status. Querying registration numbers and slot numbers based on color and registration number and ticket generation.


### Requirements
* Java Development Kit(JDK) v17 and above installed.
* IDE 
* Maven installed. 
* Postman or any API testing tool for interacting with the APIs

### Installation
* Clone the repository
```` 
git clone https://github.com/SomeshGhuge/CarParkingAssesment/tree/task
```` 
* Build the project using Maven
```
mvn clean install
```

### Interacting with the APIs Postman URL
* Once the application is running, you can interact with the APIs using Postman or any other API testing tool.

#### Postman URLs
##### baseurl = localhost:8080 (default)
* create_parking_lot
* Create a parking lot with a specified capacity
````
POST 
{baseurl}/api/create_parking_lot/{capacity}
````
* park
* Park a car in the parking lot.
````
POST 
{baseurl}/api/park

RequestBody to pass
{
 "registrationNumber": "MH-01-AB-1234", 
 "color": "White" 
}
````
* leave
* Remove a car from the parking lot.
````
POST 
{baseurl}/api/leave

RequestBody to pass
{ 
  "slot": 1, 
  "car":
       {
         "registrationNumber": "MH-01-GJ-4940", 
         "color": "Gray"
       } 
}
````
* status
* Get the current status of the parking lot.
```
GET
{baseurl}/api/status
```
* registration_numbers_for_cars_with_colour
* Get registration numbers of cars with a specified color.
````
GET 
{baseurl}/api/registration_numbers_for_cars_with_colour?color=White
````
* slot_number_for_registration_number
* Get the slot number of a car with a specified registration number.
````
GET 
{baseurl}/api/slot_number_for_registration_number?registrationNumber=
````
* slot_numbers_for_cars_with_colour
* Get slot numbers of cars with a specified color.
````
GET 
{baseurl}/api/slot_numbers_for_cars_with_colour?color=White
````
