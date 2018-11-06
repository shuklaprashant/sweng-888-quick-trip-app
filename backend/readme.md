# Quick Trip App Backend

## Setup to run locally

* Download and install docker CE: https://docs.docker.com/v17.12/install/
* Install node js on your machine. Easiest way is to use NVM: https://github.com/creationix/nvm Install at least node version 10
* Once node is installed navigate to the directory where this is installed and run `npm install`
* Then start up the docker containers: `docker-compose up` this will start a postgres instance running on port 5432 as pgadmin 4 running on port 5050
    * Connect to pgAdmin at http://localhost:5050 and to login use the username/password in the `docker-compose.yml` file
    * Once that is open you can create a new connection to the quicktrip DB. So create a new connection and use the details for the DB from the `docker-compose.yml`
* Once your docker containers are up you can start the node server: `npm start` assuming all goes well you should get a message like `Server up on port 9000....`
* From the android app you can connect to the server running on your local machine at `http://10.0.2.2:9000` so ensure this is what is configured within the app API constants