package fga.mds.gpp.trezentos.Controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import fga.mds.gpp.trezentos.Controller.Util.SortStudentsUtil;
import fga.mds.gpp.trezentos.DAO.GetFirstGrades;
import fga.mds.gpp.trezentos.DAO.RetrieveGroups;
import fga.mds.gpp.trezentos.DAO.SaveGroupsRequest;
import fga.mds.gpp.trezentos.Exception.UserException;
import fga.mds.gpp.trezentos.Model.Exam;
import fga.mds.gpp.trezentos.Model.Student;
import fga.mds.gpp.trezentos.Model.UserClass;

public class GroupController {
    private Integer groupSize = 0;
    private Integer totalStudents = 0;
    private Exam exam = new Exam();
    private UserClass userClass = new UserClass();
    private static HashMap<String, Double> firstGrades = new HashMap<>();
    private static HashMap<String, Integer> groups = new HashMap<>();

    public GroupController () {

    }

    private static HashMap<String, Double> convertToHashMapDouble(String value) {

        if (value.length() < 2) return null;

        value = value.substring(1, value.length()-1);           //remove curly brackets
        String[] keyValuePairs = value.split(",");              //split the string to creat key-value pairs
        HashMap<String, Double> map = new HashMap<>();

        for(String pair : keyValuePairs) {                      //iterate over the pairs
            String[] entry = pair.split("=");                   //split the pairs to get key and value
            map.put(entry[0].trim(),
                    Double.valueOf(entry[1].trim()));           //add them to the hashmap and trim whitespaces
        }

        return map;
    }

    private static HashMap<String, Integer> convertToHashMapInt(String value) {

        if (value.length() < 2) return null;

        value = value.substring(1, value.length()-1);           //remove curly brackets
        String[] keyValuePairs = value.split(",");              //split the string to creat key-value pairs
        HashMap<String,Integer> map = new HashMap<>();

        for(String pair : keyValuePairs) {                      //iterate over the pairs
            String[] entry = pair.split("=");                   //split the pairs to get key and value
            map.put(entry[0].trim(),
                    Integer.valueOf(entry[1].trim()));          //add them to the hashmap and trim whitespaces
        }

        return map;
    }

    public static HashMap<String, Double> getFirstGrades (String name, String userClassName,
                                                          String classOwnerEmail) {
        GetFirstGrades getFirstGrades = new GetFirstGrades(name, userClassName, classOwnerEmail);

        String serverResponse = getFirstGrades.get();
        firstGrades = convertToHashMapDouble(serverResponse);

        return firstGrades;
    }

    public static HashMap<String, Integer> getGroups (String name, String userClassName,
                                                      String classOwnerEmail) {

        String serverResponse = new RetrieveGroups(name, userClassName, classOwnerEmail).get();
        groups = convertToHashMapInt(serverResponse);

        return groups;
    }

    public boolean sortAndSaveGroups(HashMap<String, Double> grades, UserClass userClass, String email, Exam exam) {

        Map<String, Integer> sortedGroups = SortStudentsUtil.sortGroups(grades,
                userClass.getSizeGroups(), userClass.getStudents().size());
        Log.d("sorted students", sortedGroups.toString());

        boolean success = saveGroups(sortedGroups.toString(), userClass, email, exam);

        return success;
    }

    private boolean saveGroups(String groups, UserClass userClass, String email, Exam exam) {

        String response = "false";

        try {
            response = new SaveGroupsRequest(email, userClass.getClassName(), exam.getNameExam(),
                    groups).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return response.equals("true");
    }

    public static ArrayList<Student> setSpecificGroupAndGrades (String userEmail,
                                                                HashMap<String, Double> firstGrades,
                                                /* HashMap<String, Double> secondGrades,*/
                                                 HashMap<String, Integer> groups){

        ArrayList<Student> groupAndGrades = new ArrayList<>();
        Integer userNumberGroup = groups.get(userEmail);

        int it = 0;

        for (Map.Entry<String, Integer> entry : groups.entrySet()){
            if (entry.getValue().equals(userNumberGroup)){
                Student student = new Student();

                student.setStudentEmail(entry.getKey());

                groupAndGrades.add(it, student);
                it++;
            }
        }

        int groupsAndGradesSize = it;

        it = 0;

        for (int i = 0; i < groupsAndGradesSize; i++){

            Student studentGroup = groupAndGrades.get(i);

            for (Map.Entry<String, Double> entry : firstGrades.entrySet()){
                if (studentGroup.getStudentEmail().equals(entry.getKey())){
                    studentGroup.setFirstGrade(entry.getValue());

                    groupAndGrades.set(it, studentGroup);
                    it++;
                }
            }
        }

        it = 0;

/*
        for (Student studentGroup : groupAndGrades){
            for (Map.Entry<String, Double> entry : secondGrades.entrySet()){
                if (studentGroup.getStudentEmail().equals(entry.getKey())){
                    studentGroup.setSecondGrade(entry.getValue());

                    groupAndGrades.add(it, studentGroup);
                    it++;
                }
            }
        }
*/

        return groupAndGrades;
    }
}