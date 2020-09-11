
import java.util.*;

class SnakesAndLadders {

    public static class qEntry {
        int vert;
        int dist;
    }

    public int minThrows(int move[], int n) {
        int visited[] = new int[n+1];  //to avoid repetitions
        Queue<qEntry> mainQu = new LinkedList<>(); //queue because the problem is based on BFS
        qEntry quE = new qEntry();
        quE.vert = 0;
        quE.dist = 0;
        mainQu.add(quE);
        visited[0] = 1;

        while (!mainQu.isEmpty()) {
            quE = mainQu.remove();
            int vert = quE.vert;
            if (vert == n ) {
                break;
            }

            for (int j = vert + 1; j <= vert + 6 && j <= n; j++) {
                if (visited[j] == 0) {  // here one which is entered before willn't enter again
                    visited[j] = 1;
                    qEntry qE = new qEntry();
                    qE.dist = quE.dist + 1;
                    if (move[j] != -1) {
                        qE.vert = move[j];
                    } else
                        qE.vert = j;

                    mainQu.add(qE);

                }
            }

        }
        return quE.dist;
    }

    public static void main(String[] args) {
        SnakesAndLadders t = new SnakesAndLadders();
        int N = 30;
        int moves[] = new int[N+1];
        for (int i = 0; i <= N; i++)
            moves[i] = -1;

        // Ladders
        moves[3] = 34; 
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

    

        System.out.println("Min Dice throws required is " + t.minThrows(moves, N));

    }
}