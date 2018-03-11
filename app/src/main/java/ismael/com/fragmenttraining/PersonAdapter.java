package ismael.com.fragmenttraining;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ismael on 11-03-18.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private List<Person> personList;
    private int layout;
    private OnClickListener listener;

    public  PersonAdapter(List<Person> personList, int layout,OnClickListener listener){
        this.personList = personList;
        this.layout = layout;
        this.listener = listener;
    }

    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PersonAdapter.ViewHolder holder, int position) {
        holder.bind(personList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cardView)
        CardView cardView;
        @BindView(R.id.textView)
        TextView name;
        @BindView(R.id.textView2)
        TextView age;
        @BindView(R.id.textView3)
        TextView gender;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(final Person person, final OnClickListener listener){
            name.setText(person.getName());
            age.setText(person.getAge());
            gender.setText(person.getGender());

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.seePerson(person,getAdapterPosition());
                }
            });
        }
    }

    public interface OnClickListener{
        void seePerson(Person person, int position);
    }
}
