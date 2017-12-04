package com.example.santicovi.listacarta;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.io.Serializable;



/**
 * Created by SantiCovi on 04/12/2017.
 */

@Entity
public class Carta implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String manaCost;
    private int cmc;
    private String type;
    private String rarity;
    private String power;
    private String toughness;
    private String layout;
    private String imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "name='" + name + '\'' +
                ", manaCost='" + manaCost + '\'' +
                ", cmc=" + cmc +
                ", type='" + type + '\'' +
                ", rarity='" + rarity + '\'' +
                ", power='" + power + '\'' +
                ", toughness='" + toughness + '\'' +
                ", layout='" + layout + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
