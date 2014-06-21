public class Simple {


    public static String add(int x, String y) {
	String res = "";
	for (int i = y.length() - 1; i >= 0; i--) {
	    int v = Character.getNumericValue(y.charAt(i));
	    int z = x % 10 + v % 10;
	    res = z % 10 + res;
	    x = x / 10 + z / 10;
	}
	return x == 0 ? res : x + res;
    }

    public static void main(String[] args) {
	System.out.println(Simple.add(1, "999"));
	System.out.println(Simple.add(1234, "100"));
    }
}
