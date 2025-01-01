package programmers.level1.신규아이디추천;


public class Main {
    public String solution(String new_id) {
        String phase1 = phase1(new_id);
        String phase2 = phase2(phase1);
        String phase3 = phase3(phase2);
        String phase4 = phase4(phase3);
        String phase5 = phase5(phase4);
        String phase6 = phase6(phase5);

        return phase7(phase6);
    }

    public String phase1(String new_id){
        return new_id.toLowerCase();
    }

    public String phase2(String phase1){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<phase1.length();i++){
            char character = phase1.charAt(i);

            if(('a' <= character && character <= 'z')
                || ('0' <= character && character <= '9')
                || character == '-'
                || character == '_'
                || character == '.'
            ){
                sb.append(character);
            }
        }
        return sb.toString();
    }

    public String phase3(String phase2){
        String before = "";
        String after = phase2;

        do{
            before = after;
            after = after.replace("..",".");
        }while (!before.equals(after));


        return after;
    }

    public String phase4(String phase3){
        int startIndex = phase3.charAt(0) == '.' ? 1 : 0;
        int endIndex = phase3.charAt(phase3.length() - 1)  == '.' ? phase3.length() -1 : phase3.length();

        return startIndex >= endIndex ? "" : phase3.substring(startIndex,endIndex);

    }

    public String phase5(String phase4){
        return phase4.isBlank() ? "a" : phase4;
    }

    public String phase6(String phase5){
        String phase6 = phase5.length() >= 16 ? phase5.substring(0,15) : phase5;
        return phase6.charAt(phase6.length()-1) == '.' ? phase6.substring(0,phase6.length()-1) : phase6;
    }

    public String phase7(String phase6){
        if(phase6.length() >= 3){
            return phase6;
        }

        StringBuilder phase7 = new StringBuilder(phase6);

        while(phase7.length() != 3){
            phase7.append(phase7.charAt(phase7.length() - 1));
        }
        return phase7.toString();
    }

}
