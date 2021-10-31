package org.stroganoff.entities;

/*
Name - Наименование камня
    Preciousness - Может быть драгоценным, либо полудрагоценным
    Origin - Место добычи
    Visual parameters (несколько для каждого камня) - Цвет (несколько вариантов), Прозрачность (в процентах от 0 до 100), Способ огранки (количество граней)
    Value - Вес камня в каратах
 */

public class Gem {

    private String name;
    private Preciousness preciousness;
    private String miningLocation;
    private VisualParameters visualParameters;
    private double stoneWeight;

    public Gem(String name, Preciousness preciousness, String miningLocation, VisualParameters visualParameters, double stoneWeight) {
        this.name = name;
        this.preciousness = preciousness;
        this.miningLocation = miningLocation;
        this.visualParameters = visualParameters;
        this.stoneWeight = stoneWeight;
    }

    public String getName() {
        return name;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public String getMiningLocation() {
        return miningLocation;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public double getStoneWeight() {
        return stoneWeight;
    }


    @Override
    public String toString() {
        return "Gem{" +
                "name='" + name + '\'' +
                ", preciousness=" + preciousness +
                ", miningLocation='" + miningLocation + '\'' +
                ", visualParameters=" + visualParameters +
                ", stoneWeight=" + stoneWeight +
                '}';
    }
}
