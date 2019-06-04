import java.sql.*;

public class DbView {
																																										// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/turizmo_informacija";

																																										//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		
		try{

																																										//STEP 2: Register JDBC driver
			// Class.forName( "com.mysql.jdbc.Driver" );																				 // .newInstance();

																																										//STEP 3: Open a connection
			System.out.println( "Connecting to database..." );
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

																																										//STEP 4: Execute a query
			System.out.println( "Creating statement..." );
			stmt = conn.createStatement();
			String sql;
			sql = 
				"SELECT "
					+ "`id`"
					+ ", `pavadinimas`"
					+ ", `gyventoju_skaicius`"
					+ ", `plotas`"
					+ ", `platuma`"
					+ ", `ilguma` "
					+ ", `valstybe` "
				+ "FROM " 
					+ "`miestai`"
					;
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println ( "---------------------------------------------------------------------------------------" );
			System.out.println ( "| id |     miestas    |   gyv. sk.   |  plotas  |   platuma  |   ilguma   |  valstybe  |" );
			System.out.println ( "---------------------------------------------------------------------------------------" );

																																										//STEP 5: Extract data from result set
			while ( rs.next() ) {
				
																																										//Retrieve by column name
				int id  = rs.getInt("id");
				String pav = rs.getString ( "pavadinimas" );
				int gyv_sk = rs.getInt( "gyventoju_skaicius" );
				double plotas = rs.getDouble ( "plotas" );
				double platuma = rs.getDouble ( "platuma" );
				double ilguma = rs.getDouble ( "ilguma" );
				String valstybe = rs.getString ( "valstybe" );
																																										//Display values
				System.out.println ( 

					String.format (

						"| %2d | %14s | %12d | %8.2f | %10.7f | %10.7f | %6s |"
						, id 
						, pav
						, gyv_sk
						, plotas
						, platuma
						, ilguma
						, valstybe
					) 
				);
				System.out.println ( "----------------------------------------------------------------------------------" );
			}
																																										//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch ( SQLException se ) {
																																										//Handle errors for JDBC
			se.printStackTrace();
		} catch ( Exception e ) {
																																										//Handle errors for Class.forName
			e.printStackTrace();

		} finally {
																																										//finally block used to close resources
			try{
					if (stmt != null) {

						stmt.close();
					}

			}catch ( SQLException se2 ){

			}																																							// nothing we can do
			
			try{

				if ( conn!=null ) {

					conn.close();
				}

			} catch ( SQLException se ) {

				se.printStackTrace();
			}																																							//end finally try
		}																																								//end try
		System.out.println( "Goodbye!" );
	}																																								//end main
}																																									//end FirstExample