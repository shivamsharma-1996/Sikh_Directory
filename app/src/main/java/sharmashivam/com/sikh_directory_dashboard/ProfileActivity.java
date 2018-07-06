package sharmashivam.com.sikh_directory_dashboard;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    FloatingActionButton fab_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        initViews();
    }

    private void initViews()
    {
        fab_edit = findViewById(R.id.fab_edit);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        fab_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent editprofile_intent = new Intent(ProfileActivity.this, EditProfile.class);
                startActivity(editprofile_intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.reset_pwd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.nav_pwdreset:
                Toast.makeText(this, "Reset Password", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}
