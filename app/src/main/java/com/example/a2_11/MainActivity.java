package com.example.a2_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button nextButton;
    Switch aSwitch;
    EditText a1ET , dET;
    double a1ET1 , dET1;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextButton = (Button)findViewById(R.id.button);
        aSwitch = (Switch)findViewById(R.id.switch1);
        a1ET = (EditText)findViewById(R.id.edA1);
        dET = (EditText)findViewById(R.id.edD);

    }

    public void clickNext(View view) {
        Intent si = new Intent(this, results.class);
        if(aSwitch.isChecked()) type=1;
        else type=0;
        a1ET1 =0;

        boolean b = false;
        try {
            a1ET1 = Double.parseDouble(a1ET.getText().toString());
            dET1 = Double.parseDouble(dET.getText().toString());
        }
        catch (Exception e){
            b = true;
            Toast.makeText(this, "Invalid value, please verify that the value you entered is a valid, integer or decimal number", Toast.LENGTH_SHORT).show();
        }
        if (!b){
            si.putExtra("type",type);
            si.putExtra("x1", a1ET1);
            si.putExtra("d", dET1);
            startActivityForResult(si,1);
        }
    }


}