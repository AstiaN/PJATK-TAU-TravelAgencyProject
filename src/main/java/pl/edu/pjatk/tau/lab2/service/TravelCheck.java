package pl.edu.pjatk.tau.lab2.service;

import pl.edu.pjatk.tau.lab1.domain.Travel;
import pl.edu.pjatk.tau.lab1.service.TravelManager;

import java.util.List;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class TravelCheck {
    private TravelManager travelManager;

    public void setData(TravelManager data) {
        this.travelManager = data;
    }

    public List<Travel> findRecordsByRegex(String regexString) {
        if (regexString == null) {
            throw new IllegalArgumentException("Error");
        }

        List<Travel> matches = new ArrayList<Travel>();
        List<Travel> list = travelManager.readAll();
        if (list == null) {
            return matches;
        }

        Pattern p = Pattern.compile(regexString);
        for (Travel s : list) {
            if (p.matcher(s.getDirection()).matches()) {
                matches.add(s);
            }
        }

        return matches;
    }


    public void deleteRecords(List<Travel> travelsToRemove){
        for (Travel travel: travelsToRemove) {
            travelManager.delete(travel);
        }
    }


    /*public List<Travel> findRecordsByRegex2(String regexToFind) throws NoSuchFieldException{
        List<Travel> listOfTravels = new ArrayList<>();
        Pattern regexPattern = Pattern.compile(regexToFind);

        for (Travel travel: travelManager.read()) {
            if(regexPattern.matcher(travel.getFrom()).find())
                listOfTravels.add(travel);
        }

        if(listOfTravels.isEmpty())
            throw new NoSuchFieldException();

        return listOfTravels;
    }*/

}


