package util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberHandler {

    public String addZeros(int number) {
        int stringLength = 6;
        String numberAsString = Integer.toString(number);
        StringBuilder builder = new StringBuilder(numberAsString);
        String zero = "0";
        int count = stringLength - numberAsString.length();
        IntStream.range(0, count).forEach(character -> builder.insert(0, zero));
        return builder.toString();
    }

    public String nthLargestNumber(List<Integer> numbers, int nthNumber) {
        List<Integer> descendingList = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return descendingList.get(nthNumber - 1).toString();
    }
}
