#!/usr/bin/env bash

before_install:
chmod +x gradlew

after_install:
./gradlew build
- docker build -t pgr301

after_success: 
- ./docker build -t pgr301