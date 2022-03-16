# Selecciona la imagen base
FROM node:16.14.0-alpine3.14

ENV NODE_ENV production

# Define el directorio de trabajo donde ejecutar comandos
WORKDIR /project/server/

# Copia el código del proyecto
COPY src/ /project/server/
COPY public/ /project/server/
COPY config/ /project/server/
COPY package.json /project/server/

# Compila proyecto y descarga librerías
RUN npm install --only=production

# Indica el puerto que expone el contenedor
EXPOSE 3000

# Comando que se ejecuta al hacer docker run
CMD ["node", "src/server.js"]
