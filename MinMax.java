import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MinMax {
	
	public static  void parodyti ( double[] skaiciai, int kiek ) {
		
		for ( int i = 0; i < kiek;  i++ )  {
		
			System.out.print ( " " + skaiciai [ i ] );
		}
		System.out.println ();		
	}	
	
	public static void main(String[] args) throws Exception {
	   
		String thisLine = null;
		
		try {
																									// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader( new FileReader( "skaiciai_netvarkingi.csv" ) );
			
			System.out.println ( "duomenu failo turinys:" );
			
			double[] skaiciai = new double[1000];
			int kiekis = 0;
		 
			while ( ( thisLine = br.readLine() ) != null ) {
			 
				
				System.out.println( thisLine );
				String[] skaiciu_strs = thisLine.split ( "," );
				
				
				for ( int i=0; i < skaiciu_strs .length; i++ ) {
				
					skaiciai [ kiekis ] = 
					
						Double.parseDouble (  skaiciu_strs [ i ] );
					kiekis++;
				}
			} 
			System.out.println( "Nuskaityta " + kiekis + " skaiciu: " );
			parodyti ( skaiciai, kiekis );			
			
			if ( kiekis > 0 ) {
			
				for (int i = 0; i < ( kiekis - 1) ; i++ ) {

					double max = skaiciai [ i ];
					int max_i = i;
				
					for  ( int k = i + 1; k < kiekis; k++ ) {
					
						if ( skaiciai [ k ] > max ) { 
						
							max = skaiciai [ k ];
							max_i = k;
						}
					}
							
					double tarp = skaiciai [ i ];
					skaiciai [ i ] = skaiciai [ max_i  ];
					skaiciai [ max_i ] = tarp;
					
					// if ( i == 0 ) {
					
					//	System.out.println ( "max: "  + max + " max_i " + max_i ); 						
					// 	parodyti ( skaiciai, kiekis );
					// }
				}
				
				System.out.println ( "Surikiuoti skaiciai: " );
				
				parodyti ( skaiciai, kiekis );
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}