# Grocery backend getting-started
___

A java application using springboot 2.5.2  
This is the backend API, frontend mobile version created with flutter at https://github.com/ramdanariadi/grocery-front-end
## Running Locally
___
* Installing docker  
    visit : https://docs.docker.com/engine/install/
* Installing docker compose  
    visit : https://docs.docker.com/compose/install/  

* Run   
```
    $ git clone https://github.com/ramdanariadi/grocery-be.git
    $ docker-compose up -d
    $ mvn clean install  
    $ mvn spring-boot:run
```
The application should now be running on localhost:8080  

## Deploying to heroku  
___
```
    $ heroku  login
    $ heroku create
    $ git push heroku master
```
or  

[![Deploy to heroku](https://www.herokucdn.com/deploy/button.svg)](https://devcenter.heroku.com/articles/deploying-java)  

## Documentation
___
For more information about using java on heroku, see these Dev Center articles:  
* [Getting started on Heroku with java](https://devcenter.heroku.com/articles/getting-started-with-java)
* [Preparing a Java Web App for Production on Heroku](https://devcenter.heroku.com/articles/preparing-a-java-web-app-for-production-on-heroku)
* [Heroku java support](https://devcenter.heroku.com/articles/java-support)