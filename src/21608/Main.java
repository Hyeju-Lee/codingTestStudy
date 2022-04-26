

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Seat implements Comparable<Seat> {
        int x,y;
        int likeCnt;
        int emptyCnt;

        Seat(int x, int y, int likeCnt, int emptyCnt) {
            this.x = x;
            this.y = y;
            this.likeCnt = likeCnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Seat seat) {
            if (this.likeCnt > seat.likeCnt) return -1;
            else if (this.likeCnt == seat.likeCnt) {
                if (this.emptyCnt > seat.emptyCnt) return -1;
                else if (this.emptyCnt == seat.emptyCnt) {
                    if (this.x < seat.x) return -1;
                    else if (this.x == seat.x) {
                        if (this.y < seat.y) return -1;
                    }
                }
            }
            return 1;
        }
    }
    static int[][] map;
    static int[][] dir = {{-1,0}, {1,0},{0,-1},{0,1}};
    static int[][] friends;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        friends = new int[n*n+1][4];
        for (int i = 0; i < n*n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                friends[order][j] = Integer.parseInt(st.nextToken());
            }
            setSeat(order);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                int num = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i+dir[k][0];
                    int ny = j+dir[k][1];
                    if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                        if (friends[num][0] == map[nx][ny] ||
                                friends[num][1] == map[nx][ny] ||
                                friends[num][2] == map[nx][ny] ||
                                friends[num][3] == map[nx][ny]) {
                            cnt++;
                        }
                    }
                }

                if (cnt==1) answer += 1;
                else if (cnt==2) answer += 10;
                else if (cnt==3) answer += 100;
                else if (cnt==4) answer += 1000;

            }
        }
        System.out.println(answer);

    }

    public static void setSeat(int num) {
        ArrayList<Seat> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 0) continue;

                int emptyCount = 0;
                int likeCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];

                    if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                        if (friends[num][0] == map[nx][ny] ||
                                friends[num][1] == map[nx][ny] ||
                                friends[num][2] == map[nx][ny] ||
                                friends[num][3] == map[nx][ny]) {
                            likeCount++;
                        }
                        else if (map[nx][ny] == 0)
                            emptyCount++;
                    }
                }
                list.add(new Seat(i,j,likeCount,emptyCount));
            }
        }

        Collections.sort(list);
        Seat seat = list.get(0);  //정렬 후 가장 앞에 있는 자리에 앉힘
        map[seat.x][seat.y] = num; //맵에 위치를 표시
    }


}