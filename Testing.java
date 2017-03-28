
public class Testing {

	public static void main(String[] args) {
		
		String  input = "cat cat";
		String REGEX = "\\bcat\\b";
		String x = "Intel Core i5-6500 Quad-Core Processor - Socket LGA1151, 3.2Ghz, 6MB L3 Cache, 14nm - (Retail Boxed) Gen6 (BX80662I56500) �	$275.00";
		Scrap test = new Scrap();
		test.cpu();
		//System.out.println(test.priceRegex("[$][0-9]+",x));
	}
		

}
