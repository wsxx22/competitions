package com.example.competitions;

import com.example.competitions.model.Player;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route
public class AgeGui extends VerticalLayout {

    CompetitionsDAO competitionsDAO;

    TextArea textAreaPlayers;
    TextField textFieldAge;

    Button button;

    public AgeGui(CompetitionsDAO competitionsDAO) {
        this.competitionsDAO = competitionsDAO;
        this.textAreaPlayers = new TextArea();
        this.textFieldAge = new TextField();
        this.button = new Button("Pokaz graczy");

        button.addClickListener(buttonClickEvent -> {
            List<Player> playerList = competitionsDAO.showPlayersByAge();
            playerList.forEach(player -> {
                System.out.println(player.getId_team() + " " + player.getName());
            });
            textAreaPlayers.setValue(playerList.toString());

        });

        add(textAreaPlayers, textFieldAge, button);

    }



}
