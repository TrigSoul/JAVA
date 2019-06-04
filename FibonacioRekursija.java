import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FibonacioRekursija {
	
	public static int fibSk (int nr){
	
		int fib_sk = 0;
		
		if((nr == 1) || (nr == 2)){
			
			fib_sk = 1;
			
		}else{
				
			fib_sk = fibSk (nr - 2) + fibSk(nr - 1);
		}
		
		return fib_sk;
	}			
		public static void main(String[] args) throws Exception {
		   
			String thisLine = null;
			
			try {
				
				BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
				
				System.out.println ("Numeris: ?");
				
				String nr_str = br.readLine ();
				
				int nr = Integer.parseInt(nr_str);
				
				System.out.print("Fibonacio skaicius: " + fibSk (nr ) );
				
			} catch( Exception e) {

				e.printStackTrace();
			}	
		}
	}
