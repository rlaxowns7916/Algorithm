package 백준.신입사원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int ans = 1;
            ArrayList<Applicant> applicants = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int documentScore = Integer.parseInt(st.nextToken());
                int meetingRank = Integer.parseInt(st.nextToken());

                applicants.add(new Applicant(documentScore, meetingRank));
            }

            Collections.sort(applicants);
            int topRank = applicants.get(0).documentRank;
            for (int i = 1; i < n; i++) {
                if (applicants.get(i).documentRank < topRank) {
                    topRank = applicants.get(i).documentRank;
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}

class Applicant implements Comparable<Applicant> {
    int documentRank;
    int meetingRank;

    public Applicant(int documentRank, int meetingRank) {
        this.documentRank = documentRank;
        this.meetingRank = meetingRank;
    }

    @Override
    public int compareTo(Applicant o) {
        return this.meetingRank - o.meetingRank;
    }
}