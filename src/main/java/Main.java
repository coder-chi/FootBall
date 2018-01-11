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

        Player zhangzhiyuan = new Player("张致远",teamA,teamB);
        Player zhanglong = new Player("张龙",teamA,teamB);
        Player zhubenhao = new Player("祝奔豪",teamA,teamB);
        Player liuzixuan = new Player("刘子旋",teamA,teamB);
        Player gaozhengran = new Player("高政然",teamA,teamB);

        Player liuxin = new Player("刘欣",teamB,teamA);
        Player gongzheng = new Player("龚政",teamB,teamA);
        Player xuhaoran = new Player("徐浩然",teamB,teamA);
        Player bieke = new Player("别克",teamB,teamA);
        Player zhangshuo = new Player("张朔",teamB,teamA);
        
        playersA.add(zhangzhiyuan);
        playersA.add(zhanglong);
        playersA.add(zhubenhao);
        playersA.add(liuzixuan);
        playersA.add(gaozhengran);
        playersB.add(liuxin);
        playersB.add(gongzheng);
        playersB.add(xuhaoran);
        playersB.add(bieke);
        playersB.add(zhangshuo);
        zhangzhiyuan.setContainBoll(true);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(zhangzhiyuan);
        executorService.execute(zhanglong);
        executorService.execute(zhubenhao);
        executorService.execute(liuzixuan);
        executorService.execute(gaozhengran);
        executorService.execute(liuxin);
        executorService.execute(gongzheng);
        executorService.execute(xuhaoran);
        executorService.execute(bieke);
        executorService.execute(zhangshuo);
        executorService.shutdown();
    }
}
