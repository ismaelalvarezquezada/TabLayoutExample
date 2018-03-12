package ismael.com.fragmenttraining;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonActivity extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String GENDER = "gender";

    public List<Person> personList;
    AdapterActivityPerson adapter;
    @BindView(R.id.recyclerViewPerson)
    RecyclerView recyclerViewPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ButterKnife.bind(this);

        Person person1 = new Person("persona 1", "21", "male");
        Person person2 = new Person("persona 2", "22", "fale");
        Person person3 = new Person("persona 3", "23", "male");
        Person person4 = new Person("persona 4", "24", "fale");
        Person person5 = new Person("persona 5", "25", "male");
        Person person6 = new Person("persona 6", "26", "fale");
        Person person7 = new Person("persona 7", "27", "male");
        Person person8 = new Person("persona 8", "28", "fale");
        Person person9 = new Person("persona 9", "29", "male");
        personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);
        personList.add(person8);
        personList.add(person9);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerViewPerson.setLayoutManager(llm);
        adapter = new AdapterActivityPerson(personList, R.layout.item_person, new AdapterActivityPerson.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void seePerson(Person person, int position, TextView name, TextView age, TextView gender) {


//                Intent intent = new Intent(PersonActivity.this, PersonSingleActivity.class);
//                intent.putExtra(PersonActivity.NAME, person.name);
//                intent.putExtra(PersonActivity.NAMETRANSITION, ViewCompat.getTransitionName(name));
//                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                        PersonActivity.this,
//                        name,
//                        ViewCompat.getTransitionName(name));
//                startActivity(intent, options.toBundle());

                Intent intent = new Intent(PersonActivity.this, PersonSingleActivity.class);
                intent.putExtra(PersonActivity.NAME, person.name);
                intent.putExtra(PersonActivity.AGE, person.age);
                intent.putExtra(PersonActivity.GENDER, person.gender);



                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Log.e("MASLOL","LIPOP");
                    Pair<View, String> p3 = Pair.create((View)gender, gender.getTransitionName());
                    Pair<View, String> p2 = Pair.create((View)age, age.getTransitionName());
                    Pair<View, String> p1 = Pair.create((View)name, name.getTransitionName());
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(PersonActivity.this, p1, p2, p3);
                    startActivity(intent, options.toBundle());
                }else {
                    startActivity(intent);
                }
            }
        });
        recyclerViewPerson.setAdapter(adapter);
    }
}
