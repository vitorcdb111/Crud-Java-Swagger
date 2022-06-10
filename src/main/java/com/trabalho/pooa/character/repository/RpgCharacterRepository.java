package com.trabalho.pooa.character.repository;

import com.trabalho.pooa.character.model.RpgCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RpgCharacterRepository extends JpaRepository<RpgCharacter, Integer> {}
