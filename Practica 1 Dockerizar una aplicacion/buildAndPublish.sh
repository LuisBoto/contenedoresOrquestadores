docker build -t luisb493/server ./server/
docker build -t luisb493/planner ./planner/
pack build luisb493/weatherservice --path ./weatherservice/ --builder gcr.io/buildpacks/builder:v1
cd toposervice
./mvnw compile jib:build -Dimage=luisb493/toposervice
