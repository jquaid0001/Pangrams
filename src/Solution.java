import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

class Result {

    /* The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        // Trim the whitespace, convert all to lowercase, create an IntStream of chars, map the ints to chars
        // then collect into a set which doesn't allow dupes
        Set<Character> alphaArray = s
                .toLowerCase()
                .replace(" ", "")
                .chars().mapToObj(x -> (char)x)
                .collect(Collectors.toSet());

        // If alphaArray.size() == 26 then it contains all 26 letters of the alphabet
        return alphaArray.size() == 26 ? "pangram" : "not pangram";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);
        System.out.println(result);

        bufferedReader.close();
    }
}