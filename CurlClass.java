import java.io.*;
import java.util.Scanner;
public class CurlClass {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		String cont = "y";
		String input;

		ProcessBuilder pb;

		do {
			System.out.println("Try a url: ");
			input = scanner.nextLine();
			
			pb = new ProcessBuilder(
				"curl", "-g", input);
			pb.redirectErrorStream(true);
			Process p = pb.start();
			InputStream is = p.getInputStream();

			System.out.println(converter(is));

			System.out.println("\nYou entered: \n\t" + input +
				"\n\ncontinue? (y/n) ");
			cont = scanner.nextLine();
		} while (!(cont.equalsIgnoreCase("N")));
			
	}

	public static String converter(InputStream is) {
		Scanner s = new Scanner(is).useDelimiter("\\A");
		String result = s.hasNext() ? s.next() : "";
		return result;
	}
}