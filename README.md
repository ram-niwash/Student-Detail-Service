# Student-Detail-Service
Student Detail Service API

# Setup MySQL Database Server

Install MySQL or Create docker container as following.

    $ docker run -d --name mysql-container -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=student_service mysql:8.0.36-debian

Set the environment variable as following

    MYSQL_DB_HOST=localhost
    MYSQL_DB_PORT=3306
    MYSQL_DB_USERNAME=root
    MYSQL_DB_PASSWORD=root
    MYSQL_DB_NAME_STUDENT_SERVICE=student_service
