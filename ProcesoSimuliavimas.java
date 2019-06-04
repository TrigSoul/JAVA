
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcesoSimuliavimas {
	
		public static String laikas ( double laikas_val ) {
			
			double laikas_sek_viso = laikas_val * 3600;
			int laikas_sek_viso_1st = 	( int ) laikas_sek_viso;													// _1st - vienos sekundes tikslumu
			int laikas_h = laikas_sek_viso_1st / 3600;
			int laikas_min = ( laikas_sek_viso_1st - laikas_h * 3600 ) / 60;
			int laikas_sek = laikas_min % 60;																// % - dalybos liekana
			
			String laikas_str = "" + laikas_h + ":" + ( laikas_min < 10 ? "0" : "" ) + laikas_min + ":" + ( laikas_sek < 10 ? "0" : "" ) + laikas_sek;
			
			return laikas_str;
		}
	
		public static void main(String[] args) throws Exception {
	   
		String thisLine = null;
		
		try {
																									// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader( new FileReader( "proceso_simuliavimas.csv" ) );
			
			System.out.println ( "duomenu failo turinys:" );
			
			double[] skaiciai = new double[100];
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
			
			if ( kiekis < 3 ) {
			
				System.out.println ( "nepakanka duomenu" );
				
			} else {
				
				double s_gal = skaiciai [ 0 ];
				double s_tarp = skaiciai [ 1 ];				
				double v = skaiciai [ 2 ];
				
				System.out.println ( "Pradiniai duomenys : " );
				System.out.println ( "s_gal : " + s_gal );
				System.out.println ( "s_tarp : " + s_tarp );
				System.out.println ( "v : " + v );
				
				double t_gal = s_gal / v;
				double dt = t_gal / 19;
				
				System.out.println ();				
				System.out.println ( "Apskaiciuotos reiksmes : " );
				
				System.out.println ( "t_gal : " + t_gal + " (" + laikas ( t_gal ) + ") " );
				
				System.out.println ( "dt : " + dt  + " (" + laikas ( dt ) + ") ");
				
				System.out.println ( "  t, sek  s, km" );
				
				for (double t = 0; t < ( t_gal + dt ); t += dt ) {
				
					double s = v * t;
					
					System.out.println (  " " + laikas ( t ) + " " + String.format ( "%5.2f", s )  );
				}				
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}