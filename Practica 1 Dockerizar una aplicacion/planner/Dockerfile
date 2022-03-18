#################################################
# Imagen base para el contenedor de compilación
#################################################
FROM maven:3.8.4-openjdk-17 as builder

# Define el directorio de trabajo donde ejecutar comandos
WORKDIR /planner

# Copia las dependencias del proyecto
COPY pom.xml /planner/

# Descarga las dependencias del proyecto
RUN mvn -B clean verify --fail-never

# Copia el código del proyecto
COPY src /planner/src

# Compila proyecto
RUN mvn -B package

#################################################
# Imagen base para el contenedor de la aplicación
#################################################
FROM openjdk:17-jdk-slim

# Define el directorio de trabajo donde se encuentra el JAR
WORKDIR /usr/src/plannerApp/

# Copia el JAR del contenedor de compilación
COPY --from=builder /planner/target/*.jar /usr/src/plannerApp/

# Indica el puerto que expone el contenedor
#EXPOSE 8080 # Planner doesnt expose any ports as it only communicates with rabbitmq

# Comando que se ejecuta al hacer docker run
CMD [ "java", "-jar", "planner-0.0.1-SNAPSHOT.jar" ]