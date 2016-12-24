package malviya.com.studentregistration_customviews.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dell1 on 12/22/2016.
 */

public class Student implements Parcelable {
    private String Name;
    private int Age;
    private String Branch;
    private int AverageMarks;
    private String Course;
    private String Grade;
    private String Strength;

    public Student(String name, int age, String branch, int averageMarks, String course, String grade, String strength) {
        Name = name;
        Age = age;
        Branch = branch;
        AverageMarks = averageMarks;
        Course = course;
        Grade = grade;
        Strength = strength;
    }

    protected Student(Parcel in) {
        Name = in.readString();
        Age = in.readInt();
        Branch = in.readString();
        AverageMarks = in.readInt();
        Course = in.readString();
        Grade = in.readString();
        Strength = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getBranch() {
        return Branch;
    }

    public int getAverageMarks() {
        return AverageMarks;
    }

    public String getCourse() {
        return Course;
    }

    public String getGrade() {
        return Grade;
    }

    public String getStrength() {
        return Strength;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeInt(Age);
        parcel.writeString(Branch);
        parcel.writeInt(AverageMarks);
        parcel.writeString(Course);
        parcel.writeString(Grade);
        parcel.writeString(Strength);
    }
}
