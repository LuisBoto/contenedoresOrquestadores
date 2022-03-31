# contenedoresOrquestadores

## Minikube using cilium
minikube start --cni=cilium --memory=4096 --driver=virtualbox
## Minikube enable ingress
minikube addons enable ingress

## Docker build
docker build -t usuario/imagen .

## JIB build
mvn -N io.takari:maven:wrapper
./mvnw compile jib:build -Dimage=miusuario/repositorio

## BuildPacks build
pack build usuario/imagen --path . --builder gcr.io/buildpacks/builder:v1 

//paketobuildpacks/builder:base **won't work**
