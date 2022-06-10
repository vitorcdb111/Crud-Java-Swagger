package com.trabalho.pooa.character.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RpgCharacter {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String ability;
    private String race;
    private String level;

}
