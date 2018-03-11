package ismael.com.fragmenttraining;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String GENDER = "gender";
    Unbinder unbinder;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    PersonAdapter adapter;
    List<Person> personList;

    public FirstFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        unbinder = ButterKnife.bind(this,view);
        Person person1 = new Person("persona 1","21","male");
        Person person2 = new Person("persona 2","22","fale");
        Person person3 = new Person("persona 3","23","male");
        Person person4 = new Person("persona 4","24","fale");
        Person person5 = new Person("persona 5","25","male");
        Person person6 = new Person("persona 6","26","fale");
        Person person7 = new Person("persona 7","27","male");
        Person person8 = new Person("persona 8","28","fale");
        Person person9 = new Person("persona 9","29","male");
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
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        adapter = new PersonAdapter(personList, R.layout.item_person, new PersonAdapter.OnClickListener() {
            @Override
            public void seePerson(Person person, int position) {
                Intent intent = new Intent(getActivity(),PersonActivity.class);
                intent.putExtra(NAME,person.getName());
                intent.putExtra(AGE,person.getAge());
                intent.putExtra(GENDER,person.getGender());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
