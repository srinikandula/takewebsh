package com.web.jaxb;

/**
 * Created by skandula on 4/20/16.
 */
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBXMLToJava {
    public static void main(String[] args) {
        try {
            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // specify the location and name of xml file to be read
            File XMLfile = new File("countryRecord.xml");

            // this will create Java object - country from the XML file
            Country country = (Country) jaxbUnmarshaller.unmarshal(XMLfile);

            System.out.println("Country Name: " + country.getCountryName());
            System.out.println("Country Population: " + country.getCountryPopulation());

            ArrayList<State> listOfStates=country.getListOfStates();

            int i=0;
            for(State state:listOfStates)
            {
                i++;
                System.out.println("State:"+i+" "+state.getStateName());
                //USE the DAO to save the entries

            }

        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }

    }
}