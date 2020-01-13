This is the application repository for devops exam 2019. Link to the infrastructure repository

~~~~
https://github.com/thatra94/infrastructure
~~~~

To run on local

~~~~
export DOCKER_USERNAME="docker username"
export DOCKER_PASSWORD="docker password"
export LOGZ_TOKEN="your logz token"
~~~~
To build with travis

~~~~
travis encrypt DOCKER_USERNAME=[secure] --add env.global
travis encrypt DOCKER_PASSWORD=[secure] --add env.global
~~~~
commit and push to git.

Everytime you push to your github repo a new docker image will be pushed to your dockerhub.

If everything is built successfully travis will also deploy the application to ci stage in heroku.

----
To test the API first run the application.

To see the database go to http://localhost:8080/h2-console

Using an application like postman let's us easily send different requests to the api.

Set the url to http://localhost:8080

---
Creating a new device by sending a post request to /devices returns the created device.
![Device creation](pictures/creating.device.JPG?raw=true)

Get request to /devices will return all devices.

![Get all devices](pictures/get.all.devices.JPG?raw=true)

Post request with a raw body to /devices/{deviceId}/measurements will create a new measurement.

![Create measurement](pictures/create.measurement.JPG?raw=true)

Get request to /devices/{deviceId}/measurements with parameter key geigerId and value returns all measurements of that device.
![get measurements by device id](pictures/get.measurement.by.device.id.JPG?raw=true)

----

If Logz_token variable is set and the logzioUrl in the logback.xml is correctly set according to your logz.io account, the application will send logs to logz.io

![Logzio](pictures/logzio.JPG?raw=true)





