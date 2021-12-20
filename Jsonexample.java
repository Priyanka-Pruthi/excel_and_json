package persisitent.session;

import org.json.JSONArray;
import org.json.JSONObject;
import persisitent.session.model.Student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    JSONObject -> similar to java map like object,stores unordered key-value pairs
    JSONArray -> an ordered sequence of values similar to Java vectors/ array
    JSONException -> a standard exception thrown when there is problem to parse object to json or vice-versa
 */
public class Jsonexample {
    public static void main(String[] args) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("empId",1);
//        jsonObject.put("empName","Shelja");
//        jsonObject.put("empSal",89000);
//        //{empId:1,empName:"Shelja",empSal:89000}
//        System.out.println(jsonObject);
//
//        Map<String,Object> mapData = new HashMap<>();
//        mapData.put("name","Priyanka");
//        mapData.put("age",33);
//        mapData.put("Profession","Software Developer");
//
//        JSONObject jsonObject1 = new JSONObject(mapData);
//        System.out.println(jsonObject1);
//
//        JSONObject jsonObject2 = new JSONObject();
//        jsonObject2.put("employee",jsonObject);
//        System.out.println(jsonObject2);

        Set<Student> students = new HashSet<>();
        students.add(new Student(1,"Sreenith",90));
        students.add(new Student(2,"Sreejith",70));
        students.add(new Student(3,"Sreenath",80));
        students.add(new Student(4,"Sree",90));

        //{students:[{},{},{},{}]}
        JSONArray jsonArray = new JSONArray(students);
        JSONObject result = new JSONObject();
        result.put("students",jsonArray);
        System.out.println(result);

    }
}


