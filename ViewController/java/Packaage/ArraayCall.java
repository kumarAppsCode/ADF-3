CREATE TYPE array_table AS TABLE OF VARCHAR2 (50); -- Array of String

CREATE TYPE array_int AS TABLE OF NUMBER;          -- Array of integers

Next, Create a procedure which takes an array as an input parameter and returns an array as its OUT parameter. An example of one such procedure is shown below, which has 2 parameters –
an array of String as its IN parameter – p_array
an array of Integers as OUT parameter – p_arr_int
******
CREATE OR REPLACE PROCEDURE SchemaName.proc1 (p_array     IN     array_table,
                                              len            OUT NUMBER,
                                              p_arr_int      OUT array_int)
AS
   v_count   NUMBER;
BEGIN
   p_arr_int := NEW array_int ();
   p_arr_int.EXTEND (10);
   len := p_array.COUNT;
   v_count := 0;

   FOR i IN 1 .. p_array.COUNT
   LOOP
      DBMS_OUTPUT.put_line (p_array (i));
      p_arr_int (i) := v_count;
      v_count := v_count + 1;
   END LOOP;
END;
/
**********
java:
Create a java class which makes a call to the procedure proc1, created before. Below is an example which contains the whole flow from creating a connection with the database, to making a call to the stored procedure, passing an array to Oracle procedure, retrieving an array from an Oracle procedure and displaying the result.
  
  import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor; 

public class TestDatabase {
	
	public static void passArray()
	{
		try{
		
			Class.forName("oracle.jdbc.OracleDriver");			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:url ","UserName","Password");;
			
			String array[] = {"one", "two", "three","four"}; 
			
			ArrayDescriptor des = ArrayDescriptor.createDescriptor("SchemaName.ARRAY_TABLE", con);
			ARRAY array_to_pass = new ARRAY(des,con,array);
			
			CallableStatement st = con.prepareCall("call SchemaName.proc1(?,?,?)");

			// Passing an array to the procedure - 
			st.setArray(1, array_to_pass);

			st.registerOutParameter(2, Types.INTEGER);
			st.registerOutParameter(3,OracleTypes.ARRAY,"SchemaName.ARRAY_INT");
			st.execute();
			
			System.out.println("size : "+st.getInt(2));

			// Retrieving array from the resultset of the procedure after execution -
			ARRAY arr = ((OracleCallableStatement)st).getARRAY(3);
			 BigDecimal[] recievedArray = (BigDecimal[])(arr.getArray());

			for(int i=0;i<recievedArray.length;i++)
				System.out.println("element" + i + ":" + recievedArray[i] + "\n");
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String args[]){
		passArray();
	}
}


Brief Explanations:
Class.forName() – Returns the Class object associated with the class or interface with the given string name.
DriverManager.getConnection() – Attempts to establish a connection to the given database URL.
oracle.sql.ArrayDescriptor – Describes an array class
ArrayDescriptor.createDescriptor() – Descriptor factory. Lookup the name in the database, and determine the characteristics of this array.
oracle.sql.ARRAY – An Oracle implementation for generic JDBC Array interface.
CallableStatement – The interface used to execute SQL stored procedures.
  
  

