# contenedoresOrquestadores

## Istio
export PATH=$PWD/bin:$PATH

istioctl install --set profile=demo -y

kubectl label namespace default istio-injection=enabled

kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.status.loadBalancer.ingress[0].ip}'

## Artillery
artillery run test.yml

## Minikube using cilium
minikube start --cni=cilium --memory=4096 --driver=virtualbox
## Minikube enable ingress
minikube addons enable ingress

## Helm install
helm install releaseName folder
### Helm uninstall
helm uninstall releaseName
## Helm dry run
helm install --debug --dry-run releaseName folder

## Okteto
*okteto up*

*okteto down*

## Docker build
docker build -t usuario/imagen .

## JIB build
mvn -N io.takari:maven:wrapper
./mvnw compile jib:build -Dimage=miusuario/repositorio

## BuildPacks build
pack build usuario/imagen --path . --builder gcr.io/buildpacks/builder:v1 

// paketobuildpacks/builder:base **won't work**
