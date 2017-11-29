package pl.edu.pjatk.tau.lab1.service;

import pl.edu.pjatk.tau.lab1.domain.Travel;

import java.util.List;
import java.util.ArrayList;


public class TravelManagerImpl implements TravelManager {

    List<Travel> travelList = new ArrayList<Travel>();

    public void create(Travel travel) {
        travelList.add(travel);
    }

    public List<Travel> readAll() {
        return null;
    }


    public Travel read(int travelId) {
        for(Travel travel : travelList) {
            if(travel.getId() == travelId)
                return travel;
        }
        return null;
    }

    public void update(Travel travel, int id) {
        Travel t = read(travel.getId());
        if(t != null) {
            t.setFrom(travel.getFrom());
            t.setDirection(travel.getDirection());
            t.setPrice(travel.getPrice());
        }
    }

    public void delete(Travel travel) {
        travelList.remove(travel);
    }
}
