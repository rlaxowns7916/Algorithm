package programmers.level3.다단계칫솔판매;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
        static Map<String, Unit> relationShip = new LinkedHashMap<>();

        static class Unit {
            int profit;
            String parent;

            public Unit(String parent) {
                this.profit = 0;
                this.parent = parent;
            }
        }

        public int[] solution(String[] enrolls, String[] referrals, String[] sellers, int[] amount) {
            int duty = 0, profit = 0;
            int[] profits = new int[enrolls.length];
            for (int i = 0; i < enrolls.length; i++)
                relationShip.put(enrolls[i], new Unit(referrals[i]));
            for (int i = 0; i < sellers.length; i++)
                divide(sellers[i], amount[i] * 100);
            for (int i = 0; i < enrolls.length; i++)
                profits[i] = relationShip.get(enrolls[i]).profit;

            return profits;
        }

        public void divide(String currentPeople, int profit) {
            Unit info = relationShip.get(currentPeople);
            int duty = (int) (profit * 0.1);
            info.profit += profit - duty;

            if (!info.parent.equals("-") && duty != 0)
                divide(info.parent, duty);

        }
}
