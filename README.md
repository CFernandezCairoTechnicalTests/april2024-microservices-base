#April 2024 Technical Test

### Create docker wastemanager
1. git clone https://github.com/CFernandezCairoTechnicalTests/april2024-waste-manager.git [branch origin/main]
2. cd april2024-waste-manager && mvn clean compile install
3. cd framewirk/
4. docker build . -t april2024/wastemanager -f .\src\main\docker\Dockerfile

### Run all containers
1. git clone https://github.com/CFernandezCairoTechnicalTests/april2024-microservices-base.git [branch origin/main]
2. cd april2024-microservices-base && docker-compose up

### Testing
1. Import in postman Tarea Tecnica.postman_collection.json

### Key URIs
1. http://127.0.0.1:8761/ [Discovery/Registry server]




