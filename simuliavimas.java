import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class simuliavimas {
	
	public static String laikas (double laikas_val) {
		
		double laikas_sek_viso = laikas_val * 3600;
		int laikas_sek_viso_1st = (int) laikas_sek_viso;
		int laikas_h = laikas_sek_viso_1st / 3600;
		int laikas_min = ( laikas_sek_viso_1st - laikas_h * 3600 ) / 60;
		int laikas_sek = laikas_min % 60;																	// % - dalybos liekana
			
		String laikas_str = " " + laikas_h + ":" + ( laikas_min < 10 ? "0" : "" ) + laikas_min + ":" + ( laikas_sek < 10 ? "0" : "" ) + laikas_sek;
			
		return laikas_str;
		
	}	
	
	public static void main(String[] args) throws Exception {
	String thisLine = null;
      
		try {

			BufferedReader br = new BufferedReader(new FileReader("procesu_simuliavimas.txt"));
		 
			double[] skaiciai = new double[100];
			int kiekis = 0;
			 
				while ( ( thisLine = br.readLine() ) != null ) {
				 
					System.out.println( thisLine );
					String[] skaiciu_strs = thisLine.split ( " " );
					
					
					for ( int i=0; i < skaiciu_strs .length; i++ ) {
					
						skaiciai [ kiekis ] = 
					
							Double.parseDouble ( skaiciu_strs [ i ] );
							kiekis++;
					}
				} 
				System.out.println( "Nuskaityta " + kiekis + " skaiciai: " + "\n");	
				
				double s_gal = skaiciai [ 0 ];
				double s_tarp = skaiciai [ 1 ];
				double v_gr = skaiciai [ 2 ];
						
				System.out.println("Tarpine stotele: " + s_tarp + "\nGalutinis kelias: " + s_gal + "\nGreitis: " + v_gr + "\n"); 
				
				double t_gal = s_gal / v_gr;
				double t_tarp = s_tarp / v_gr;
				double dt = t_gal / 19;
				
				System.out.println("Galutinis laikas: " + t_gal);
				System.out.println("dt: " + dt + "\n");
				
				boolean flag_nebuvo_pravaziuota_stotele = true;
				
				for (double t = 0; t < (t_gal + dt); t+=dt) {
					
					double s = v_gr * t;
					
					if (s >= s_tarp){
						
						if(flag_nebuvo_pravaziuota_stotele) {
							
							System.out.println( laikas ( t_tarp ) + "     " + String.format ("%5.2f", s_tarp ) + "*");
							flag_nebuvo_pravaziuota_stotele = false;
							
						}	
					}	
					
					System.out.println( laikas ( t ) + "     " + String.format("%5.2f", s ));	
					
				}
				
					
					
				
		} catch(Exception e) {
			
			e.printStackTrace();
		
		}	
	}
}

