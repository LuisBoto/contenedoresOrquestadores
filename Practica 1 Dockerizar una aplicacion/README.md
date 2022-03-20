# Practica 1 - Dockerizar una aplicación
La aplicación consta de los servicios server, planner, weatherservice y toposervice. 
Tanto server como planner cuentan con un fichero Dockerfile que permite construir la image docker correspondiente,
mientras que weatherservice y toposervice estan preparados para construir una imagen docker haciendo uso de buildpacks y JIB respectivamente.
El fichero *buildAndPublish.sh* cuenta con instrucciones de shell para construir las cuatro imagenes y realizar push de ellas a DockerHub.
Todas las imágenes se encuentran ya disponibles en DockerHub al momento de realizar al entrega.

## Devcontainers
Los cuatros servicios cuentan con directorios .devcontainer preparados con contenedores Node o Java según sea necesario, los cuales se ejecutan en
modo de red *host*. Para complementar el desarrollo haciendo uno de dichos devcontainers, se incluye el fichero docker-compose-development.yml que 
cuenta con imágenes mongoDB, mySQL y RabbitMQ para ofrecer servicios utilizados por distintas partes de la aplicación.

## Lanzar la aplicación
Para la ejecución de la aplicación se debe levantar el fichero docker-compose.yml, que incluye imágenes de los cuatros servicios principales de la aplicación,
completos con variables de entorno para la adecuada comunicación entre ellos, así como el broker RabbitMQ y las bases de datos necesarias. Dichas bases de datos
hacen uso de volúmenes para persistir la información independientemente del ciclo de vida del contenedor.
