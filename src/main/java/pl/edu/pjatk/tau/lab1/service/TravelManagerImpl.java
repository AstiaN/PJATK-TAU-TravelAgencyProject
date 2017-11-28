package pl.edu.pjatk.tau.lab1.service;

import pl.edu.pjatk.tau.lab1.domain.Travel;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class TravelManagerImpl implements TravelManager {

    private Map<Integer,Travel> travelDB = new TreeMap<Integer,Travel>();

    public int create(Travel travel) {
        return 0;
    }

    public List<Travel> readAll() {
        return null;
    }

    public Travel read(int id) {
        return null;
    }

    public void update(Travel travel, int id) throws IndexOutOfBoundsException {

    }

    public void delete(Travel travel, int id) {

    }
}
