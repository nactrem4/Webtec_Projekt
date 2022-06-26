package htw.berlin.webtech.demo.web.api;

import htw.berlin.webtech.demo.service.ThingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ThingRestController {

    private final ThingService thingService;

    public ThingRestController(ThingService thingService) {
        this.thingService = thingService;
    }

    @GetMapping(path = "/api/v1/things")
    public ResponseEntity<List<Thing>> fetchThing() {
        return ResponseEntity.ok(thingService.findall());
    }
    @GetMapping(path = "/api/v1/things/{id}")
    public ResponseEntity<Thing> fetchThingById(@PathVariable Long id){
        var thing = thingService.findById(id);
        return thing != null? ResponseEntity.ok(thing) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/things")
    public ResponseEntity<Void> createThing(@RequestBody ThingCreate request) throws URISyntaxException {
        var thing =thingService.create(request);
        URI uri = new URI("/api/v1/things/" + thing.getId());
        return ResponseEntity.created(uri).build();
}
    @PutMapping(path = "/api/v1/things/{id}")
    public ResponseEntity<Thing> updateThing(@PathVariable Long id,@RequestBody ThingCreate request) {
        var thing =thingService.update(id,request);
        return thing != null? ResponseEntity.ok(thing) : ResponseEntity.notFound().build();
    }
    @DeleteMapping(path = "/api/v1/things/{id}")
    public ResponseEntity<Void> deleteThing(@PathVariable Long id){
        boolean succesful = thingService.deleteById(id);
        return succesful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
