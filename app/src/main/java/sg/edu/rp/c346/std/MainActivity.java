package sg.edu.rp.c346.std;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    Button btnAdd;
    Button btnClear;
    ListView lv1;
    ArrayList<String> arrayD;
    ArrayAdapter<String> arrTp;
    int selectedS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);
        btnAdd=findViewById(R.id.button);
        btnClear=findViewById(R.id.button2);


        lv1=findViewById(R.id.listView1);
        registerForContextMenu(lv1);
        arrayD=new ArrayList<String>();
        arrTp=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayD);
        arrTp.notifyDataSetChanged();
        lv1.setAdapter(arrTp);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code for the action
                String stringResponse=ed1.getText().toString();

                arrayD.add(stringResponse);
                arrTp.notifyDataSetChanged();


            }
        });


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed1.setText("");
                arrTp.notifyDataSetChanged();


            }
        });


    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        ListView lv = (ListView) v;
        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
        selectedS = acmi.position;

        menu.add(0,0,0,"Delete");
        menu.add(0,1,1,"Edit");

        // …

    }
    public boolean onContextItemSelected(MenuItem item) {
        // …

        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            arrayD.remove(selectedS);
            arrTp.notifyDataSetChanged();

            return true; //menu item successfully handled
        }else if(item.getItemId()==1) { //check whether the selected menu item ID is 0
            //code for action
            arrayD.remove(selectedS);
            arrayD.add(selectedS,ed1.getText().toString());
            arrTp.notifyDataSetChanged();

            return true; //menu item successfully handled
        }


        return super.onContextItemSelected(item);
    }
}
