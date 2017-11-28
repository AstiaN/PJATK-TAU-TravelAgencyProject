package pl.edu.pjatk.tau.lab1.service;

import pl.edu.pjatk.tau.lab1.domain.Travel;

import java.util.List;

public interface TravelManager {

    public void Create(Travel travel);
    public List<Travel> readAll();
    public Travel Read(int id);
    public void Update(Travel travel, int id) throws IndexOutOfBoundsException;;
    public void Delete(Travel travel, int id);
}
