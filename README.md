#April 2024 Technical Test

### Create docker wastemanager
1. git clone https://github.com/CFernandezCairoTechnicalTests/april2024-waste-manager.git [branch origin/main]
2. cd april2024-waste-manager
3. mvn clean compile install -DskipTests
4. cd framework/
5. docker build . -t april2024/wastemanager -f .\src\main\docker\Dockerfile
6. cd ..

### Run all containers
1. git clone https://github.com/CFernandezCairoTechnicalTests/april2024-microservices-base.git [branch origin/main]
2. cd april2024-microservices-base
3. mvn clean compile install -DskipTests
4. docker-compose up

### Testing
1. Import in postman Tarea Tecnica.postman_collection.json

### Key URIs
1. http://127.0.0.1:8761/ [Discovery/Registry server]




