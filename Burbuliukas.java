import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Burbuliukas {
	
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
			
				boolean flag_buvo_sukeitimu = true;

				while ( flag_buvo_sukeitimu ) {
					
					flag_buvo_sukeitimu = false;
				
					for  ( int i = 0; i < kiekis - 1; i ++ ) {
					
						if ( skaiciai [ i ] < skaiciai [ i + 1 ] ) { 
							
							double tarp = skaiciai [ i ];
							skaiciai [ i ] = skaiciai [ i  + 1 ];
							skaiciai [ i +1 ] = tarp;
							flag_buvo_sukeitimu = true;
						}
					}
					// System.out.println ( "iskelimas: " );
					// parodyti ( skaiciai, kiekis);
				}
				
				System.out.println ( "Surikiuoti skaiciai: " );
				
				parodyti ( skaiciai, kiekis );
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}