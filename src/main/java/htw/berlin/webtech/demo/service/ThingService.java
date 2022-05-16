package htw.berlin.webtech.demo.service;

import htw.berlin.webtech.demo.persistence.ThingEntity;
import htw.berlin.webtech.demo.persistence.ThingsRepository;
import htw.berlin.webtech.demo.web.api.Thing;
import htw.berlin.webtech.demo.web.api.ThingCreate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThingService {
    private final ThingsRepository thingsRepository;

    public ThingService(ThingsRepository thingsRepository) {
        this.thingsRepository = thingsRepository;
    }

    public List<Thing> findall() {
        List<ThingEntity> things = thingsRepository.findAll();
        return things.stream()
                .map(this::transformThingEntity)
                .collect(Collectors.toList());
    }

    public Thing findById(Long id) {
        var thingEntity = thingsRepository.findById(id);
        return thingEntity.isPresent() ? transformThingEntity(thingEntity.get()) : null;
    }

    public Thing create(ThingCreate request) {
        var thingEntity = new ThingEntity(request.getFilmName(), request.getFilmGenre(), request.getFilmDescription());
        thingEntity = thingsRepository.save(thingEntity);
        return transformThingEntity(thingEntity);
    }

    public Thing update(Long id, ThingCreate request) {
        var thingEntityOptional = thingsRepository.findById(id);
        if (thingEntityOptional.isEmpty()) {
            return null;
        }

        var thingEntity = thingEntityOptional.get();
        thingEntity.setFilmDescription(request.getFilmDescription());
        thingEntity.setFilmGenre(request.getFilmGenre());
        thingEntity.setFilmName(request.getFilmName());
        thingEntity = thingsRepository.save(thingEntity);
        return transformThingEntity(thingEntity);
    }

    private Thing transformThingEntity(ThingEntity thingEntity) {
        return new Thing(
                thingEntity.getId(),
                thingEntity.getFilmName(),
                thingEntity.getFilmDescription(),
                thingEntity.getFilmGenre()
        );
    }

    public boolean deleteById(Long id) {
        if (!thingsRepository.existsById(id)) {
            return false;
        } thingsRepository.deleteById(id);
        return true;
    }
    }

