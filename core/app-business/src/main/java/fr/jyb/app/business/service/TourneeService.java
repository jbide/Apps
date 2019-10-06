package fr.jyb.app.business.service;

import fr.jyb.app.business.model.Tournee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@Service
public class TourneeService {

    public List<Tournee> getAllTournees() {
        Tournee tourneee = new Tournee();
        tourneee.setTitle("totootooo");
        return Arrays.asList(tourneee);
    }

    public Tournee registerTournee(Tournee tournee) {
        return tournee;
    }
}
