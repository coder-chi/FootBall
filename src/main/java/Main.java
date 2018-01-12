import people.Player;
import people.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        List<Player> playersA = new ArrayList<>();
        List<Player> playersB = new ArrayList<>();
        Team teamA = new Team("A",playersA);
        Team teamB = new Team("B",playersB);

        Player[] playerArray_A = new Player[5];
        Player[] playerArray_B = new Player[5];

        playerArray_A[0] = new Player("张致远",teamA,teamB);
        playerArray_A[1] = new Player("祝奔豪",teamA,teamB);
        playerArray_A[2] = new Player("刘子旋",teamA,teamB);
        playerArray_A[3] = new Player("张龙",teamA,teamB);
        playerArray_A[4] = new Player("高政然",teamA,teamB);


        playerArray_B[0] = new Player("刘欣",teamB,teamA);
        playerArray_B[1] = new Player("龚政",teamB,teamA);
        playerArray_B[2] = new Player("徐浩然",teamB,teamA);
        playerArray_B[3] = new Player("别克",teamB,teamA);
        playerArray_B[4] = new Player("张朔",teamB,teamA);

        playersA.add(playerArray_A[0]);
        playersA.add(playerArray_A[1]);
        playersA.add(playerArray_A[2]);
        playersA.add(playerArray_A[3]);
        playersA.add(playerArray_A[4]);

        playersB.add(playerArray_B[0]);
        playersB.add(playerArray_B[1]);
        playersB.add(playerArray_B[2]);
        playersB.add(playerArray_B[3]);
        playersB.add(playerArray_B[4]);

        playerArray_A[0].setContainBoll(true);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<5;i++){
            executorService.execute(playerArray_A[i]);
            executorService.execute(playerArray_B[i]);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("最终比分 " + teamA.getScore() + ":" + teamB.getScore());

    }
}
