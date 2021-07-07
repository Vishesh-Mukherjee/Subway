package com.gdgu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Nutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nutritionName;
    private int nutritionValue;

    @ManyToOne
    private MenuSandwich menuSandwich;

    public Nutrition(String nutritionName, int nutritionValue, MenuSandwich menuSandwich) {
        this.nutritionName = nutritionName;
        this.nutritionValue = nutritionValue;
        this.menuSandwich = menuSandwich;
    }
}
