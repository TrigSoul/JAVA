import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GrupiuSumosIrVid {
	
	public static void main(String[] args) throws Exception {
	   
		String thisLine = null;
		
		try {
																									// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader( new FileReader( "skaiciu_grupes.csv" ) );
			
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
			System.out.println( "Nuskaityta " + kiekis + " skaiciu." );
			
			if ( kiekis > 0 ) {
			
				double suma = 0, suma_sumu = 0, vid = 0, vid_grupiu_sumu = 0;
																										// double[] sumos_grupiu = new double [500];
																										// int[] kiekiai_grupeje = new kiekiai_grupeje [ 500];
				int kiekis_grupeje =0, kiekis_grupiu= 0;
				
				for ( int i = 0; i<kiekis; i++ ) {
					
					if ( skaiciai [ i ] == 0 ) {
																										// sumos_grupiu [ kiekis_grupiu ] = suma;
																										// kiekiai_grupeje [ kiekis_grupiu ] = kiekis_grupeje;
						suma_sumu += suma;
						kiekis_grupiu++;
						
						System.out.println ( kiekis_grupiu + ". grupe: \n\tsuma: " + suma + "\n\tkiekis: " + kiekis_grupeje );
						suma = 0;
						kiekis_grupeje = 0;
						
					} else {
						
						suma += skaiciai [ i ];
						kiekis_grupeje++;
					}
				}
				
				System.out.println ( "Grupiu sumu suma: " + suma_sumu );
				System.out.println ( "Grupiu kiekis: "  + kiekis_grupiu );
				vid_grupiu_sumu = suma_sumu / kiekis_grupiu;
				System.out.println ( "Grupiu Sumu vidurkis: " + vid_grupiu_sumu  );
				vid = suma_sumu / ( kiekis - kiekis_grupiu );
				System.out.println ( "Bendras vidurkis: " + vid  );				

			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}