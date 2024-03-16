import java.util.Arrays;
import java.util.Scanner;

public class Graph {

    int n;
    int[][] adjacencyMatrix;
    Node[] nodes;
    Game[][] game;

    public Graph(int n, double p) {
        this.n = n;

        adjacencyMatrix = new int[n][n];
        game = new Game[n][n];
        nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.random() < p) {
                    adjacencyMatrix[i][j] = 1;
                    adjacencyMatrix[j][i] = 1;
                    game[i][j] = new Game();
                    game[j][i] = new Game();
                }
            }
        }
    }

    public void iteration() {

        double[] pNodes = new double[n];

        for (int i = 0; i < n; i++) {

            double pSum = 0;
            double count = 0;

            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    game[i][j].mixedEquilibria();
                    double p = game[i][j].p;
                    count++;
                    pSum += p;
                }
            }

            double pAverage = pSum / count;
            pNodes[i] = pAverage;
        }

        // update the node, agree or disagree values

        for (int i = 0; i < n; i++) {
            nodes[i].agree = Math.random() < pNodes[i];
        }

        // update each of the game's payoff matrices

        for (int i = 0; i < n; i++) {

            int agreeCount = 0;
            int disagreeCount = 0;

            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    agreeCount += nodes[j].agree ? 1 : 0;
                    disagreeCount += !nodes[j].agree ? 1 : 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1) {

                    double new_player_agree = ((double) agreeCount) / (agreeCount + disagreeCount);
                    double new_player_disagree = ((double) disagreeCount) / (agreeCount + disagreeCount);

                    int index1;
                    int index2;

                    if (i < j) {
                        // i - a, c
                        index1 = 0;
                        index2 = 2;
                    } else {
                        // i - b, d
                        index1 = 1;
                        index2 = 3;
                    }

                    double old_sum = game[i][j].payoffMatrix[index1] + game[i][j].payoffMatrix[index2];

                    game[i][j].payoffMatrix[index1] *= new_player_agree;
                    game[i][j].payoffMatrix[index2] *= new_player_disagree;

                    // normalize the payoff matrix values

                    double new_sum = game[i][j].payoffMatrix[index1] + game[i][j].payoffMatrix[index2];

                    game[i][j].payoffMatrix[index1] *= old_sum / new_sum;
                    game[i][j].payoffMatrix[index2] *= old_sum / new_sum;
                }
            }
        }
    }

    public double agreeRatio() {
        int agreeCount = 0;

        for (int i = 0; i < n; i ++) {
            agreeCount += nodes[i].agree ? 1 : 0;
        }

        // calculate the distribution of agrees vs distribution

        return ((double) agreeCount) / n;
    }

    @Override
    public String toString() {
        // We want to print out the "agree" or "disagree" values for each of the nodes

        StringBuilder sb = new StringBuilder();

        int agreeCount = 0;

        for (int i = 0; i < n; i ++) {
            //sb.append(nodes[i].agree);
            agreeCount += nodes[i].agree ? 1 : 0;
            //sb.append(" ");
        }

        // calculate the distribution of agrees vs distribution

        sb.append(((double) agreeCount) / n);

        //sb.append('\n');

        int totalCounters = 0;
        int alignCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //sb.append(adjacencyMatrix[i][j]);

                //sb.append(" ");

                if (adjacencyMatrix[i][j] == 1) {
                    //sb.append("(" + nodes[i].agree + ", " + nodes[j].agree + ")");

                    if (nodes[i].agree.equals(nodes[j].agree)) {
                        alignCount++;
                    }

                    totalCounters++;

                    //sb.append(" ");
                }
            }

            //sb.append('\n');
        }

        //sb.append(((double) alignCount) / totalCounters);

        sb.append('\n');

        return sb.toString();
    }

    private class Node {
        Boolean agree;

        Node() {
            this.agree = null;
        }

        Node(boolean agree) {
            this.agree = agree;
        }
    }
}