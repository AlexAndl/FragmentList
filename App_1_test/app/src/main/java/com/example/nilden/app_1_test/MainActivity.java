package com.example.nilden.app_1_test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button button;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        editText1= (EditText)findViewById(R.id.editText1);
        editText2= (EditText)findViewById(R.id.editText2);
        button= (Button)findViewById(R.id.button);
        listView= (ListView)findViewById(R.id.listView);

        final ArrayList<String> NS = new ArrayList<String>();

        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, NS);
        listView.setAdapter(adapter);


        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.button:
                        if (editText1.getText().toString().isEmpty() && editText2.getText().toString().isEmpty()) {
                            Toast toast = Toast.makeText(MainActivity.this, "Заполните поля", Toast.LENGTH_SHORT);
                            toast.show();
                            break;
                        }
                        else
                        {
                            NS.add(0, editText1.getText().toString() + " " + editText2.getText().toString());
                            adapter.notifyDataSetChanged();
                            editText1.setText("");
                            editText2.setText("");
                            break;
                        }
                }
            }
        };

        button.setOnClickListener(onClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
