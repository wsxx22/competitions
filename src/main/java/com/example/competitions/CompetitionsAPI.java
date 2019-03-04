package com.example.competitions;

import com.example.competitions.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CompetitionsAPI {

    private CompetitionsDAO competitionsDAO;

    @Autowired
    public CompetitionsAPI(CompetitionsDAO competitionsDAO) {
        this.competitionsDAO = competitionsDAO;
    }

    @GetMapping("/showPlayers")
    public List<Player> showPlayerByAge () {
        return competitionsDAO.showPlayersByAge();
    }
}
