package com.trabalho.pooa.character.controller;

import com.trabalho.pooa.character.model.RpgCharacter;
import com.trabalho.pooa.character.repository.RpgCharacterRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/character")
@Api(value="API REST RPG")
public class RpgCharacterController {

    private final RpgCharacterRepository repository;

    public RpgCharacterController(RpgCharacterRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value="Retorna uma lista de personagens do rpg")
    @GetMapping
    public List<RpgCharacter> findAllCharacters() {
        return repository.findAll();
    }

    @ApiOperation(value="Retorna um personagem pelo id")
    @GetMapping("/{CharacterId}")
    public RpgCharacter findCharacterById(@PathVariable Integer CharacterId) {
        return repository.findById(CharacterId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ApiOperation(value="Inserir um personagem passando seus atributos pelo corpo")
    @PostMapping
    public RpgCharacter createNewCharacter(@RequestBody RpgCharacter newCharacter) {
        return repository.save(newCharacter);
    }

    @ApiOperation(value="Atualizar um personagem, passando seu id no endereco")
    @PutMapping
    public RpgCharacter updateCharacter(@RequestBody RpgCharacter CharacterRequest) {
        if(repository.existsById(CharacterRequest.getId())) {
            return repository.save(CharacterRequest);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character id does not exists.");
    }

    @ApiOperation(value="Deletar um personagem, passando seu id no endereco")
    @DeleteMapping("/{CharacterId}")
    public void deleteMapping(@PathVariable Integer CharacterId) {
        if(repository.existsById(CharacterId)) {
            repository.deleteById(CharacterId);
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character id does not exists.");
    }

}
