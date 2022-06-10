package com.trabalho.pooa.character;

import com.trabalho.pooa.character.model.RpgCharacter;
import com.trabalho.pooa.character.repository.RpgCharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class RpgCharacterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpgCharacterApplication.class, args);
	}

}

@Component
class InitialData implements CommandLineRunner {

	private final RpgCharacterRepository characterRepository;

	InitialData(RpgCharacterRepository characterRepository) {
		this.characterRepository = characterRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		RpgCharacter character1 = new RpgCharacter(null,
				"Han of Taro",
				"Eat sunflower seeds",
				"Beast",
				"14"
		);

		RpgCharacter character2 = new RpgCharacter(null,
				"Rafsten Luthrum",
				"Laser beam",
				"Elf",
				"42"
		);

		characterRepository.saveAll(Arrays.asList(character1, character2));
	}
}
