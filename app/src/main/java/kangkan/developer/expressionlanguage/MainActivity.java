package kangkan.developer.expressionlanguage;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kangkan.developer.expressionlanguage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding=
                DataBindingUtil.setContentView(this,R.layout.activity_main);


        binding.setAStudent(new student("Kangkan",22));
        binding.setHandler(new EventHandler());
        binding.setHandler2(new EventHandler2());

        student a =new student("ami",22);
        List<student> students=new ArrayList<>();
        students.add(a);

        Map<String,Integer>nameVsAge=new HashMap<>();
        nameVsAge.put(a.getName(),a.getAge());


        binding.setStudents(students);
        binding.setNameVsAge(nameVsAge);


        binding.setShowstar(true);

    }

    public class EventHandler{
        public void handleClick(View view){
            Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
        }
    }

    public class EventHandler2{
        public void handleClick2(String name){
            Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
        }
    }

    public class student{
        private String name;
        private int age;


        public student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
