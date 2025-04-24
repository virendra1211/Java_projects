package virendra.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumberToWordsConverter {

    private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
	    " seventy", " eighty", " ninety" };

    private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
	    " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
	    " seventeen", " eighteen", " nineteen" };

    private static final Map<Integer, String> scaleNames = new LinkedHashMap<>();

    static {
	// Add Indian numbering system scales
	scaleNames.put(10000000, " crore");
	scaleNames.put(100000, " lakh");
	scaleNames.put(1000, " thousand");
	scaleNames.put(100, " hundred");
    }

    public static void main(String[] args) {
	int number = 12345;
	String word = convert(number).trim();
	System.out.println(word); // twelve million three hundred forty five thousand six hundred seventy eight
    }

    public static String convert(int number) {
	if (number == 0)
	    return "zero";

	StringBuilder result = new StringBuilder();

	for (Map.Entry<Integer, String> entry : scaleNames.entrySet()) {
	    int scale = entry.getKey();
	    String scaleName = entry.getValue();

	    if (number >= scale) {
		int scaleValue = number / scale;
		number %= scale;

		result.append(convertBelowThousand(scaleValue)).append(scaleName).append(" ");
	    }
	}

	if (number > 0) {
	    result.append(convertBelowThousand(number));
	}

	return result.toString();
    }

    private static String convertBelowThousand(int num) {
	StringBuilder sb = new StringBuilder();

	if (num >= 100) {
	    sb.append(numNames[num / 100]).append(" hundred ");
	    num %= 100;
	}

	if (num >= 20) {
	    sb.append(tensNames[num / 10]).append(numNames[num % 10]);
	} else {
	    sb.append(numNames[num]);
	}

	return sb.toString();
    }
}
