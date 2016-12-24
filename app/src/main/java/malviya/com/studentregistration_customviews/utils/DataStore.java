package malviya.com.studentregistration_customviews.utils;

import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import malviya.com.studentregistration_customviews.model.Student;

/**
 * Created by Prafulla on 12/24/2016.
 */

public class DataStore {
    private static Student student = null;
   private static List<Student> mArrayList = new ArrayList<>();

    public static List<Student> addData(EditText name, EditText age, EditText branch,
                                        EditText marks, EditText course, EditText grade, EditText strength) {

        student = new Student(name.getText().toString(),
                (Integer.parseInt(age.getText().toString())==0)?0:Integer.parseInt(age.getText().toString()),
                branch.getText().toString(),
                (Integer.parseInt(marks.getText().toString())==0)?0:Integer.parseInt(marks.getText().toString()),
                course.getText().toString(),
                grade.getText().toString(), strength.getText().toString());
        mArrayList.add(student);
        return mArrayList;
    }

    public static List<Student> returnListInstance() {
        List<Student> obj = null;
        if (mArrayList != null) {
            obj = mArrayList;
        }
        return obj;
    }


}
