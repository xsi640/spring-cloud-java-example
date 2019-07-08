#!/bin/bash

docker run -d \
--restart=always \
-e PREFER_HOST_MODE=hostname \
-e MODE=standalone \
-v /home/vagrant/nacos/logs:/home/nacos/logs \
-v /home/vagrant/nacos/init.d/custom.properties:/home/nacos/init.d/custom.properties \
-p 8848:8848 \
nacos/nacos-server:latest