package virendra.interview;

public class NumbertoStingwords {
    // Example 10143 ans. ten thousand one hundread forty three
    private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
	    " seventy", " eighty", " ninety" };

    private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
	    " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
	    " seventeen", " eighteen", " nineteen" };
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
	Integer n = 10340;
	System.out.println(n.toString().length());
	convertingToWord(n);
	System.out.println(sb.toString());
    }

    public static String convertingToWord(Integer num) {
	Integer len = num.toString().length();
	// if(num /1000 >0 && num /1000 < 100){
	if (len == 5) {
	    if (num / 1000 >= 20) {
		int newnum = num / 1000;
		sb.append(tensNames[newnum / 10] + numNames[newnum % 10] + " thousand");
	    } else {
		sb.append(numNames[num / 1000] + " thousand");
	    }
	    convertingToWord(num % 1000);
	}
	// if(num /100 >0 && num/100 <10){
	if (len == 3) {
	    sb.append(numNames[num / 100] + " hundred");
	    convertingToWord(num % 100);
	}
	// if(num /10 >0 && num/10 <10){
	if (len == 2) {
	    sb.append(tensNames[num / 10] + numNames[num % 10]);
	}
	// 3 4 remainder 5, 3 remainder 45
	return null;
    }

}