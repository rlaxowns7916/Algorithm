package programmers.level3.단속카메라;

import java.util.Arrays;

public class Solution {
    /**
     * 종료지점을 기준으로 오름차순 정렬한다.
     * 종료지점을 기준으로, 시작지점이 종료지점 보다 앞인 자동차는 한 카메라에 찍히게되는 것
     * [-20,-15], [-18,-13]. [-14,-5], [-5,-3]
     */
    public int solution(int[][] routes) {
        int cameraCount = 0, camera = 0;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        cameraCount = 1;
        camera = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            int[] current = routes[i];

            if (camera < current[0]) {
                cameraCount++;
                camera = current[1];
            }
        }

        return cameraCount;
    }
}
