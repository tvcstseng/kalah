# kalah
Turn based game using Spring Boot and Angular

## Requirements
|Software|Version|
|---|---|
| Maven 3 | ^3.5.0 |
| Node Package Manager | ^3.10.10 |

## Installation & execution
```bash
cd <<any place>>
git clone https://github.com/tvcstseng/kalah.git

# Startup the backend(websockets) @ localhost:8080
cd kalah
mvn clean install
cd kalah-websockets
mvn spring-boot:run

# Startup the backend(rest) @ localhost:8081
cd kalah
mvn clean install
cd kalah-rest
mvn spring-boot:run

# Startup the angular frontend @ localhost:4200
cd kalah/kalah-angular
npm install
npm start

# open a webbrowser and go to http://localhost:4200
```

## Resources