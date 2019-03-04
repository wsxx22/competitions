package com.example.competitions;

import com.example.competitions.model.Player;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route
public class PlayerGui extends VerticalLayout {

    private TextField textFieldIdTeam;
    private TextField textFieldName;
    private TextField textFieldSurname;
    private TextField textFieldAge;

    Button button;

    CompetitionsDAO competitionsDAO;

    public PlayerGui(CompetitionsDAO competitionsDAO) {
        this.textFieldIdTeam = new TextField();
        this.textFieldName = new TextField();
        this.textFieldSurname = new TextField();
        this.textFieldAge = new TextField();
        this.button = new Button("Dodaj");
        this.competitionsDAO = competitionsDAO;

        button.addClickListener(buttonClickEvent -> {
            Player player = new Player(
                    Integer.valueOf(textFieldIdTeam.getValue()),
                    textFieldName.getValue(),
                    textFieldSurname.getValue(),
                    Integer.valueOf(textFieldAge.getValue()));

            if (competitionsDAO.addPlayerToMysql(player)) {
                Notification.show("Dodan").setPosition(Notification.Position.MIDDLE);
            } else {
                Notification.show("Error").setPosition(Notification.Position.MIDDLE);
            }
        });

        add(textFieldIdTeam, textFieldName, textFieldSurname, textFieldAge, button);

    }
}
