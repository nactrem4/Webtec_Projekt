package htw.berlin.webtech.demo.web.api;

import htw.berlin.webtech.demo.persistence.ThingsRepository;
import htw.berlin.webtech.demo.service.ThingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ThingRestController {

    private final ThingService thingService;

    public ThingRestController(ThingService thingService){
        this.thingService = thingService;
    }

    @GetMapping(path = "/api/v1/things")
    public ResponseEntity<List<Thing>> fetchThing(){
        return ResponseEntity.ok(thingService.findall());
    }
}
