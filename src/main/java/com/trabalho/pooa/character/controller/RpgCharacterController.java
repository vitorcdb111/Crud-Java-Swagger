package com.trabalho.pooa.character.controller;

import com.trabalho.pooa.character.model.RpgCharacter;
import com.trabalho.pooa.character.repository.RpgCharacterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class RpgCharacterController {

    private final RpgCharacterRepository repository;

    public RpgCharacterController(RpgCharacterRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<RpgCharacter> findAllCharacters() {
        return repository.findAll();
    }

    @GetMapping("/{CharacterId}")
    public RpgCharacter findCharacterById(@PathVariable Integer CharacterId) {
        return repository.findById(CharacterId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public RpgCharacter createNewCharacter(@RequestBody RpgCharacter newCharacter) {
        return repository.save(newCharacter);
    }

    @PutMapping
    public RpgCharacter updateCharacter(@RequestBody RpgCharacter CharacterRequest) {
        if(repository.existsById(CharacterRequest.getId())) {
            return repository.save(CharacterRequest);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character id does not exists.");
    }

    @DeleteMapping("/{CharacterId}")
    public void deleteMapping(@PathVariable Integer CharacterId) {
        if(repository.existsById(CharacterId)) {
            repository.deleteById(CharacterId);
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character id does not exists.");
    }

}
