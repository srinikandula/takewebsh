package com.web.jaxb;

/**
 * Created by skandula on 4/20/16.
 */
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBJavaToXml {
    public static void main(String[] args) {

        // creating country object
        Country countryIndia=new Country();
        countryIndia.setCountryName("USA");
        countryIndia.setCountryPopulation(5000000);

        // Creating listOfStates
        ArrayList<State> stateList=new ArrayList<State>();
        State newYorkState=new State("New York",1000000);
        stateList.add(newYorkState);
        State newJerseyState =new State("New Jersey",2000000);
        stateList.add(newJerseyState);

        countryIndia.setListOfStates(stateList);

        try {

            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // for getting nice formatted output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //specify the location and name of xml file to be created
            File XMLfile = new File("countryRecord.xml");

            // Writing to XML file
            jaxbMarshaller.marshal(countryIndia, XMLfile);
            // Writing to console
            jaxbMarshaller.marshal(countryIndia, System.out);

        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }

    }
}