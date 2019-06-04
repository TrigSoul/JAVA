import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FibonacioSeka {
	
	public static void main(String[] args) throws Exception {
	   
		String thisLine = null;
		
		try {
			
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
			
			System.out.println ("Numeris: ?");
			
			String nr_str = br.readLine ();
			
			int nr = Integer.parseInt(nr_str);
			
			int ankst_2 = 1;
			int ankst_1 = 1;
			int f_sk = ankst_1;
			for (int i = 3; i <= nr; i++){
				
				f_sk = ankst_2 + ankst_1;
				ankst_2 = ankst_1;
				ankst_1 = f_sk;
	
			}
			
			System.out.print("Skaicius: " + f_sk);
			
			} catch( Exception e) {

			e.printStackTrace();
		}	
	}
}