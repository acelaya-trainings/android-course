package com.empresa.model;

import java.io.Serializable;

/**
 * Created by cta on 16/04/2015.
 */
public class Country implements Serializable {
    private String name;
    private int population;
    private boolean belongsUe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean getBelongsUe() {
        return belongsUe;
    }

    public void setBelongsUe(boolean belongsUe) {
        this.belongsUe = belongsUe;
    }
}
