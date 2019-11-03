To run on local

export DOCKER_USERNAME=[secure]
export DOCKER_PASSWORD=[secure]

To run with travis 

travis encrypt DOCKER_USERNAME=[secure] --add env.global
travis encrypt DOCKER_PASSWORD=[secure] --add env.global

commit and push to git.

Everytime you push to your github repo a new docker image will be pushed to your dockerhub.