package com.example.competitions;

import com.example.competitions.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CompetitionsDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CompetitionsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean addPlayerToMysql(Player player) {
        String sql = "INSERT INTO players VALUES(null,?,?,?,?);";

        if ((jdbcTemplate.update(sql, new Object[] {
                player.getId_team(),
                player.getName(),
                player.getSurname(),
                player.getAge()
        })) == 1 ) {
            return true;
        } else
            return false;

    }

    public List<Player> showPlayersByAge () {

//        List<Map<String, Object>> mapList = new ArrayList<>();
        List<Player> mapList2 = new ArrayList<>();
        String sql = "SELECT * from players where age = 42;";

//         jdbcTemplate.queryForList(sql).addAll(mapList);
         jdbcTemplate.queryForList(sql, Player.class).addAll(mapList2);


        return mapList2;
    }


    // ma sie ona uruchomic w momencie startu. Jeśli aplikacja jest gotowa dostartu, wtedy odpali sie ta metoda
    @EventListener(ApplicationReadyEvent.class)
    public void DbInit() {

        String createTablePlayers = "CREATE TABLE IF NOT EXISTS players(id_player bigint unsigned auto_increment primary key, " +
                "id_team bigint unsigned, " +
                "name varchar(50), " +
                "surname varchar(50), " +
                "age int(10) unsigned);";

//        addPlayerToMysql(new Player(2,"Adam", "Kowalski", 30));
//        addPlayerToMysql(new Player(1,"Marcin", "Kowal", 42));
//        addPlayerToMysql(new Player(1,"Andrzej", "Nowak", 19));
//        addPlayerToMysql(new Player(2,"Marek", "Nowakowski", 26));

        jdbcTemplate.update(createTablePlayers);

    }

}
