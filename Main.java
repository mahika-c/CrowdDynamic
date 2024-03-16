import java.util.*;
import java.io.*;

import com.opencsv.CSVWriter;


public class Main {

    static double[] INITIAL_PAYOFF_MATRIX = new double[] {200, 200, 2, 2};

    public static void main(String[] args) {

        int n = 1000;
        double pVal = 0.5;

        Graph g = new Graph(n, pVal);

        List<String[]> list = new ArrayList<>();
        String[] header = {"Iteration Number", "Nodes", "P-Value", "Agree Ratio", "Initial Payoff Matrix"};
        list.add(header);

        for (int i = 0; i < 100; i++) {
            g.iteration();
            System.out.println(g);

            String[] record1 = {String.valueOf(i + 1), String.valueOf(n), String.valueOf(pVal), String.valueOf(g.agreeRatio()), Arrays.toString(INITIAL_PAYOFF_MATRIX)};
            list.add(record1);
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("experiment1.csv"))) {
            writer.writeAll(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // TODO: show the visualization of the graph - https://graphstream-project.org/
    }
}