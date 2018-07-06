package sharmashivam.com.sikh_directory_dashboard;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity  implements  AdapterView.OnItemSelectedListener {

    private Spinner spinner_lastName, spinner_relation, spinner_occupation, spinner_state, spinner_district, spinner_Village, spinner_tehsil;
    private RadioGroup rg_yes_no;
    private RadioButton rb_yes, rb_no;
    private Spinner spinner_blood;
    private ArrayAdapter<String> bloodAdapter;

    //Adapters
    private ArrayAdapter<String> lastNameAdapter;
    private String[] blood_groups;
    //Adapters
    private ArrayAdapter<String> relationAdapter,occupationAdapter, stateAdapter, districtAdapter, villageAdapter, tehsilAdapter ;
    //String resources
    String[] relations, occupations, states, districts, villages, tehsils;
    String relation = "", name = "", occupation = "" , state = "", district = "", village = "", tehsil = "", houseNo = "", gali = "", pinCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();

        spinner_relation.setOnItemSelectedListener(this);
        spinner_occupation.setOnItemSelectedListener(this);
        spinner_state.setOnItemSelectedListener(this);
        spinner_district.setOnItemSelectedListener(this);
        spinner_Village.setOnItemSelectedListener(this);
        spinner_tehsil.setOnItemSelectedListener(this);
        }


    private void initViews() {
        spinner_blood = findViewById(R.id.spinner_blood);
        rg_yes_no = findViewById(R.id.rg_yes_no);
        rb_yes = findViewById(R.id.rb_yes);
        rb_no = findViewById(R.id.rb_no);

        //Adapter
        blood_groups = getResources().getStringArray(R.array.blood_groups);
        bloodAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, blood_groups);
        bloodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_blood.setAdapter(bloodAdapter);

        spinner_lastName = findViewById(R.id.spinner_lastName);
        spinner_relation = findViewById(R.id.spinner_relation);
        spinner_occupation = findViewById(R.id.spinner_occupation);

        spinner_state = findViewById(R.id.spinner_state);
        spinner_district = findViewById(R.id.spinner_district);
        spinner_Village = findViewById(R.id.spinner_Village);
        spinner_tehsil = findViewById(R.id.spinner_tehsil);

        //resources
        relations = getResources().getStringArray(R.array.relations);
        occupations = getResources().getStringArray(R.array.occupations);
        states = getResources().getStringArray(R.array.states);
        districts = getResources().getStringArray(R.array.districts);
        villages = getResources().getStringArray(R.array.villages);
        tehsils = getResources().getStringArray(R.array.tehsils);


        String[] lastNames = getResources().getStringArray(R.array.last_name);
        lastNameAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lastNames);
        spinner_lastName.setAdapter(lastNameAdapter);


        //spinner Adapters
        relationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, relations);
        relationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        occupationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, occupations);
        occupationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        stateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);
        stateAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        districtAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        villageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, villages);
        villageAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        tehsilAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tehsils);
        tehsilAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);


        spinner_relation.setAdapter(relationAdapter);
        spinner_occupation.setAdapter(occupationAdapter);
        spinner_state.setAdapter(stateAdapter);
        spinner_district.setAdapter(districtAdapter);
        spinner_Village.setAdapter(villageAdapter);
        spinner_tehsil.setAdapter(tehsilAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_profile, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.nav_done:
                Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        switch (spinner.getId()) {
            case R.id.spinner_relation:
                relation = parent.getItemAtPosition(position).toString();
                Log.i("onItemSelected", relation);
                break;

            case R.id.spinner_occupation:
                occupation = parent.getItemAtPosition(position).toString();
                Log.i("onItemSelected", occupation);
                break;

            case R.id.spinner_state:
                state = parent.getItemAtPosition(position).toString();
                Log.i("onItemSelected", state);
                break;

            case R.id.spinner_district:
                district = parent.getItemAtPosition(position).toString();
                Log.i("onItemSelected", district);
                break;

            case R.id.spinner_Village:
                village = parent.getItemAtPosition(position).toString();
                Log.i("onItemSelected", village);
                break;

            case R.id.spinner_tehsil:
                tehsil = parent.getItemAtPosition(position).toString();
                Log.i("onItemSelected", tehsil);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
