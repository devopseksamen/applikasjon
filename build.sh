before install:
- ./gradlew build
- docker build -t pgr301

after_success: 
- docker build -t pgr301