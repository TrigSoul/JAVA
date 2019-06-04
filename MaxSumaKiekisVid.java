import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MaxSumaKiekisVid {
	
	public static void main(String[] args) throws Exception {
	   
		String thisLine = null;
		
		try {
																									// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader( new FileReader( "skaiciai.csv" ) );
			
			System.out.println ( "duomenų failo turinys:" );
			
			double[] skaiciai = new double[10000];
			int kiekis = 0;
			double suma = 0, vid = 0;
		 
			while ( ( thisLine = br.readLine() ) != null ) {
			 
				
				System.out.println( thisLine );
				String[] skaiciu_strs = thisLine.split ( "," );
				
				
				for ( int i=0; i < skaiciu_strs .length; i++ ) { 
				
					skaiciai [ kiekis ] = 
					
						Double.parseDouble (  skaiciu_strs [ i ] );
					kiekis++;
				}
			} 
			System.out.println( "Nuskaityta " + kiekis + " skaiciu." );
			
			if ( kiekis > 0 ) {
			
				double max = skaiciai [ 0 ];
				
				for ( int i = 0; i<kiekis; i++ ) {
					
					suma += skaiciai [ i ];
				
					if ( max < skaiciai [ i ] ) {
					
						max = skaiciai [ i ]; 
					}
				}
				
				System.out.println ( "Maksimali reiksme skaiciu sekoje: " + max );
				System.out.println ( "Skaiciu suma: " + suma );
				vid = suma / kiekis;
				System.out.println ( "Vidurkis: " + vid );				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}