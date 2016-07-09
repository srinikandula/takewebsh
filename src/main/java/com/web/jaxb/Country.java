package com.web.jaxb;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Below annotation defines root element of XML file
@XmlRootElement
//You can define order in which elements will be created in XML file
//Optional
@XmlType(propOrder = { "countryName", "countryPopulation", "listOfStates"})
public class Country {

    private String countryName;
    private double countryPopulation;

    private ArrayList<State> listOfStates;
    public Country() {

    }
    public String getCountryName() {
        return countryName;
    }
    @XmlElement
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public double getCountryPopulation() {
        return countryPopulation;
    }

    @XmlElement
    public void setCountryPopulation(double countryPopulation) {
        this.countryPopulation = countryPopulation;
    }


    public ArrayList<State> getListOfStates() {
        return listOfStates;
    }

    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "stateList")
    // XmlElement sets the name of the entities in collection
    @XmlElement(name = "state")
    public void setListOfStates(ArrayList<State> listOfStates) {
        this.listOfStates = listOfStates;
    }

}