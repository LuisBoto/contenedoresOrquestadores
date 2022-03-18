# contenedoresOrquestadores

## Docker build
docker build -t usuario/imagen .

## JIB build
mvn -N io.takari:maven:wrapper
./mvnw compile jib:build -Dimage=miusuario/repositorio

## BuildPacks build
pack build usuario/imagen --path . --builder paketobuildpacks/builder:base
