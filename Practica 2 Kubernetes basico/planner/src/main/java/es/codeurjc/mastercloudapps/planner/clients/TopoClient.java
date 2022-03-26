package es.codeurjc.mastercloudapps.planner.clients;

import es.codeurjc.mastercloudapps.planner.models.LandscapeResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class TopoClient {

	@Value("${topo.client.address}")
    private String TOPO_ADDRESS; // = "localhost:8181";

    @Async
    public CompletableFuture<String> getLandscape(String city) {
        
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://"+TOPO_ADDRESS+"/api/topographicdetails/" + city;
        
        LandscapeResponse response = restTemplate.getForObject(url, LandscapeResponse.class);
        
        return CompletableFuture.completedFuture(response.getLandscape());
    }
}
