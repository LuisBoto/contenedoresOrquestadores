# Selecciona la imagen base
FROM node:16.14-bullseye

ENV NODE_ENV production

# Define el directorio de trabajo donde ejecutar comandos
WORKDIR /project/server/

# Copia el código del proyecto
COPY src /project/server/src
COPY public /project/server/public
COPY config /project/server/config
COPY package.json /project/server/
COPY wait-for-it.sh /project/server/

# Compila proyecto y descarga librerías
RUN chmod +x /project/server/wait-for-it.sh
RUN npm install --only=production

# Indica el puerto que expone el contenedor
EXPOSE 3000

# Comando que se ejecuta al hacer docker run
CMD ["node", "./src/server.js"]
