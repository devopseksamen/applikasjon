#!/usr/bin/env bash

before_install:
chmod +x gradlew

after_install:
./gradle w build
docker build -t pgr301
