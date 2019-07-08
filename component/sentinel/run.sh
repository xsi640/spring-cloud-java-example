#!/bin/bash

docker run -d \
--restart=always \
-p 8080:8080 \
-v /etc/localtime:/etc/localtime \
sentinel:1.6.2