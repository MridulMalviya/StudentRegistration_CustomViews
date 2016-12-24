package malviya.com.studentregistration_customviews.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import malviya.com.studentregistration_customviews.R;
import malviya.com.studentregistration_customviews.utils.DataStore;
import malviya.com.studentregistration_customviews.utils.NavigateClass;

public class RegistrationActivity extends AppCompatActivity {
    EditText name, age, grade, marks, strength, branch, course;


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
        branch = (EditText) findViewById(R.id.branch);
        marks = (EditText) findViewById(R.id.avgmarks);
        course = (EditText) findViewById(R.id.course);
        strength = (EditText) findViewById(R.id.strength);

    }

    public void onBackClick(View v) {
        navigationMethod();
    }

    public void methodSubmit(View v) {
        dataStore();
    }

    private void dataStore() {
        try {
            DataStore.addData(name, age, branch, marks, course, grade, strength);
            navigationMethod();
            clearAllEditText();
        } catch (Exception e) {
            Toast.makeText(this, "Age and Marks field should not be empty", Toast.LENGTH_SHORT).show();
            e.getMessage();
        }

    }

    public void methodExit(View v) {
        exitDialog();
    }

    public void navigationMethod() {
        NavigateClass.navigateTo(this, Dashboard.class);
    }

    @Override
    public void onBackPressed() {
        exitDialog();
    }

    private void exitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        RegistrationActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void clearAllEditText() {
        name.setText("");
        age.setText("");
        grade.setText("");
        marks.setText("");
        strength.setText("");
        branch.setText("");
        course.setText("");
        ;
    }

}
