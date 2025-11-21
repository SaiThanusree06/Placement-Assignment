import java.io.FileReader;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Main {

    public static long decodeBaseValue(String value, int base) {
        return Long.parseLong(value, base);
    }

    public static void main(String[] args) {

        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(new FileReader("input.json"));

            JSONObject keys = (JSONObject) json.get("keys");
            long n = (long) keys.get("n");
            long k = (long) keys.get("k");

            List<Long> X = new ArrayList<>();
            List<Long> Y = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                String key = String.valueOf(i);

                if (json.containsKey(key)) {
                    JSONObject rootObj = (JSONObject) json.get(key);
                    int base = Integer.parseInt((String) rootObj.get("base"));
                    String value = (String) rootObj.get("value");

                    long yDecoded = decodeBaseValue(value, base);

                    X.add((long) i);
                    Y.add(yDecoded);
                }
            }

            long C = computeConstantTerm(X, Y);

            System.out.println(C);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long computeConstantTerm(List<Long> X, List<Long> Y) {

        int k = Y.size();
        double[][] diff = new double[k][k];

        for (int i = 0; i < k; i++)
            diff[i][0] = Y.get(i);

        for (int j = 1; j < k; j++) {
            for (int i = 0; i < k - j; i++) {
                diff[i][j] = diff[i + 1][j - 1] - diff[i][j - 1];
            }
        }

        return (long) diff[0][0];
    }
}
