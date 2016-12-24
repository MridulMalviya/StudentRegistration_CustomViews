package malviya.com.studentregistration_customviews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import malviya.com.studentregistration_customviews.R;
import malviya.com.studentregistration_customviews.utils.DataStore;
import malviya.com.studentregistration_customviews.utils.NavigateClass;

public class RegistrationActivity extends AppCompatActivity {
    EditText name, age, grade, marks, stregth, brach, course;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        grade = (EditText) findViewById(R.id.grade);
        brach = (EditText) findViewById(R.id.branch);
        marks = (EditText) findViewById(R.id.avgmarks);
        course = (EditText) findViewById(R.id.course);
        stregth = (EditText) findViewById(R.id.strength);

    }

    public void onBackClick(View v) {
        navigationMethod();
    }

    public void methodSubmit(View v) {
        dataStore();
    }

    private void dataStore() {
        DataStore.addData(name, age, brach, marks, course, grade, stregth);
        navigationMethod();
    }

    public void methodExit(View v) {
        navigationMethod();
    }

    public void navigationMethod() {
        NavigateClass.navigateTo(this, Dashboard.class);
    }

}
