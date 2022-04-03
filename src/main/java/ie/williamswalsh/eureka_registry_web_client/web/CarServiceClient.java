package ie.williamswalsh.eureka_registry_web_client.web;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CarServiceClient {

    private RestTemplate rest;

    public CarServiceClient(@LoadBalanced RestTemplate rest) {
        this.rest = rest;
    }

    @GetMapping("/first_bounce")
    public String getCarFromService() {
        return rest.getForObject("http://car-service/car", String.class);
    }
}
