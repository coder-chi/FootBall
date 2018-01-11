package people;

import java.util.List;

public class Team {
    private String name;
    private List<Player> playerList;

    public Team(String name, List<Player> playerList) {
        this.name = name;
        this.playerList = playerList;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
