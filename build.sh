chmod +x docker
./gradle build

after_success: 
- docker build -t pgr301