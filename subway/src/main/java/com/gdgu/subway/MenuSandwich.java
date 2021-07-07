package com.gdgu.subway;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MenuSandwich {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private String image;
    @OneToMany(mappedBy = "menuSandwich", fetch = FetchType.EAGER)
    private List<Nutrition> nutritionInformation;   
    
    private double price;

}
