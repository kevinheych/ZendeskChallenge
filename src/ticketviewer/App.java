package ticketviewer;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;

public class App { public static void main(String[] args) {
    String csvData = "INDIA, UK, USA";

    //Case 1: CSV to JSON Array 
    JSONArray jsonArray = CDL.rowToJSONArray(new JSONTokener(csvData));        
    System.out.println(jsonArray);

    //Case 2: JSONArray to CSV        
    System.out.println(CDL.rowToString(jsonArray));

    //Case 3: CSV to JSONArray of Objects
    csvData = "empId, name, age \n" +
       "1, Mark, 22 \n" +
       "2, Robert, 35 \n" +
       "3, Julia, 18";
    System.out.println(CDL.toJSONArray(csvData));

    //Case 4: CSV without header        
    jsonArray = new JSONArray();
    jsonArray.put("empId");
    jsonArray.put("name");
    jsonArray.put("age");
    csvData = "1, Mark, 22 \n" + "2, Robert, 35 \n" + "3, Julia, 18";
    System.out.println(CDL.toJSONArray(jsonArray,csvData));
 }
}
