package people;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Player implements Runnable{

    Logger LOGGER = LoggerFactory.getLogger(Player.class);
    int huihe = 50;

    Random passRandom = new Random();
    Random scoreRandom = new Random();
    Random chooseRandom = new Random();

    private String name;
    private Team team;
    private Team hostility;
    private boolean containBoll;


    public Player(String name, Team team, Team hostility) {
        this.name = name;
        this.team = team;
        this.hostility = hostility;
    }

    private void pass(Player teammate){
        if(containBoll){
            containBoll = false;
            teammate.containBoll = true;
            LOGGER.info(team.getName() + " " + name + "传球给了 " + teammate.name);
        }
    }

    private void shoot(){
        if(containBoll){
            LOGGER.info(team.getName() + " " + name + "一脚爆射");
            containBoll = false;
            if(scoreRandom.nextInt(10)>5){
                LOGGER.info("球进啦！");
                LOGGER.info(this.name + "打进了一球");
                team.goal();
            } else {
                LOGGER.info("这打的是个毛啊。");
            }
            giveBallToOppnent();
        }
    }

    private synchronized void steal(Player opponent){
        if(!containBoll && opponent.containBoll){
            containBoll = true;
            opponent.containBoll = false;
            LOGGER.info(team.getName() + " " + name + "断掉了" + opponent.name + "的球");
        }
    }

    private void giveBallToOppnent(){
        hostility.getPlayerList().get(0).setContainBoll(true);
    }

    @Override
    public void run() {
        while (--huihe > 0){
            int r = chooseRandom.nextInt(5);
            //有球
            if(containBoll){
                if(r>3){
                    shoot();
                }
                else {
                    Player teammate = team.getPlayerList().get(r);
                    if (teammate == this){
                        teammate = team.getPlayerList().get((r+1)%5);
                    }
                    pass(teammate);
                }
            }
            //无球
            else {
                if (r > 2){
                    steal(hostility.getPlayerList().get(chooseRandom.nextInt(5)));
                }
            }
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public boolean isContainBoll() {
        return containBoll;
    }

    public void setContainBoll(boolean containBoll) {
        this.containBoll = containBoll;
    }

}
