package programmers.level1.붕대감기;

public class Main {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHp = health;
        int beforeAttackedTime = -1;

        for(int[] attack: attacks){
            int time = attack[0];
            int damage = attack[1];

            if(health <= 0){break;}
            health -= damage;

            if(beforeAttackedTime != -1){
                int gap = time - beforeAttackedTime;
                health = Math.min (maxHp,health + gap * bandage[1]) ;
                health = Math.min (maxHp, health + (gap / bandage[0] * bandage[2]));
            }
            System.out.println(health);
            beforeAttackedTime = time;
        }

        return health <= 0 ? -1 : health;
    }
}
