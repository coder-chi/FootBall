package people;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Team {

    private String name;
    private List<Player> playerList;
    private AtomicInteger score;

    public Team(String name, List<Player> playerList) {
        this.name = name;
        this.playerList = playerList;
        init();
    }

    private void init(){
        score = new AtomicInteger(0);
    }

    public void goal(){
        score.getAndIncrement();
    }

    public int getScore() {
        return score.get();
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
