package programmers.level1.지폐접기;

public class Main {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        boolean isFinished = false;
        Wallet w = new Wallet(wallet[0],wallet[1]);

        while(!isFinished){
            isFinished = w.canInput(bill[0],bill[1]);
            if(!isFinished){
                answer++;

                int nextWidth = bill[0] > bill[1] ? bill[0] / 2 : bill[0];
                int nextHeight = bill[1] > bill[0] ? bill[1] / 2 : bill[1];

                bill[0] = nextWidth;
                bill[1] = nextHeight;
            }
        }
        return answer;
    }

    static class Wallet{

        private final int width;
        private final int height;


        public boolean canInput(int width, int height){
            return (this.width >= width && this.height >= height) || (this.width >= height && this.height >= width);
        }

        public Wallet(
                int width,
                int height
        ){
            this.width = width;
            this.height = height;
        }
    }
}
