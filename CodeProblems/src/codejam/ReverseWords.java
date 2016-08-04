package codejam;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) throws IOException {
		File inputFile = new File("resources/ReverseWords/B-large-practice.in");
		File outputFile = new File("resources/ReverseWords/result");
		Scanner sc = new Scanner(inputFile);
		PrintWriter pw = new PrintWriter(outputFile);
		int N = Integer.parseInt(sc.nextLine());
		for(int i = 0;i<N;i++){
			String[] strings = sc.nextLine().split(" ");
			pw.print("Case #"+(i+1)+": ");
			for(int j = strings.length-1;j>=0;j--){
				pw.print(strings[j]+" ");
			}
			pw.println();
		}
		sc.close();
		pw.close();
	}

}
