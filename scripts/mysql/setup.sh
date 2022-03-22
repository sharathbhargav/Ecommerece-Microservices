#!/bin/bash
docker pull mysql/mysql-server
docker run --name=mysql_ecomm --restart on-failure -d mysql/mysql-server
