package ismael.com.fragmenttraining;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static ismael.com.fragmenttraining.PersonActivity.AGE;
import static ismael.com.fragmenttraining.PersonActivity.GENDER;
import static ismael.com.fragmenttraining.PersonActivity.NAME;

public class PersonSingleActivity extends AppCompatActivity {


    @BindView(R.id.textView)
    TextView name;
    @BindView(R.id.textView2)
    TextView age;
    @BindView(R.id.textView3)
    TextView gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_single);
        ButterKnife.bind(this);

        String personName = getIntent().getStringExtra(NAME);
        String personGender = getIntent().getStringExtra(GENDER);
        String personAge = getIntent().getStringExtra(AGE);

        name.setText(personName);
        age.setText(personGender);
        gender.setText(personAge);

        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            name.setTransitionName(getString(R.string.transition_name));
            age.setTransitionName(getString(R.string.transition_age));
            gender.setTransitionName(getString(R.string.transition_gender));
        }


//        String personName  = getIntent().getStringExtra("name");
//        String personAge  = getIntent().getStringExtra("age");
//        String personGender  = getIntent().getStringExtra("gender");
//
//
//        name.setText(personName);
//        age.setText(personAge);
//        gender.setText(personGender);
//
//        String nameTransitionName = getIntent().getStringExtra(PersonActivity.NAMETRANSITION);
//        name.setTransitionName(nameTransitionName);
//
//        String ageTransitionName = getIntent().getStringExtra(PersonActivity.AGETRANSITION);
//        age.setTransitionName(ageTransitionName);
//
//        String genderTransitionName = getIntent().getStringExtra(PersonActivity.GENDERTRANSITION);
//        gender.setTransitionName(genderTransitionName);

    }
}
