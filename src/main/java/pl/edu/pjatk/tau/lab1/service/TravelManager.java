package pl.edu.pjatk.tau.lab1.service;

import pl.edu.pjatk.tau.lab1.domain.Travel;

import java.util.List;

public interface TravelManager {

    public void create(Travel travel);
    public List<Travel> readAll();
    public Travel read(int id);
    public void update(Travel travel, int id) throws NullPointerException;
    public void delete(Travel travel);

}
