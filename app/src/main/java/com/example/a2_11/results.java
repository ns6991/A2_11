package com.example.a2_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class results extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView tvX1,  tvD ,  tvN,  tvSn ;
    ListView lv;
    Button returni;
    Intent gi;
    String[] series = new String[20];
    String[] seriesSum = new String[20];
    double x1;
    double d;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        tvD = (TextView)findViewById(R.id.tvD);
        tvX1 = (TextView)findViewById(R.id.tvX1);
        tvN = (TextView)findViewById(R.id.tvN);
        tvSn = (TextView)findViewById(R.id.tvSn);
        lv = (ListView)findViewById(R.id.lv);
        returni = (Button)findViewById(R.id.returni);
        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, series);
        lv.setAdapter(adapter);
        gi = getIntent();
        x1 = gi.getDoubleExtra("x1",224);
        d = gi.getDoubleExtra("d",5353);
        type = gi.getIntExtra("type",798799);

        if (type==0) heshbonit(x1,d,series,seriesSum);
        else handasit(x1,d,series,seriesSum);
        tvD.setText("d = " +d);
        tvX1.setText("X1 = " +x1);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvN.setText("N = " + series[position]);
        tvSn.setText("Sn = " +seriesSum[position]);
    }
    public static void heshbonit(double x1,double d,String[] series,String[] seriesSum){
        series[0] = x1+"";
        double sum = x1;
        seriesSum[0] = x1+"";
        double nextN = x1;
        for (int i=1;i<20;i++){
            nextN+=d;
            sum+=nextN;
            series[i] = nextN+"";
            seriesSum[i] = sum+"";

        }
    }
    public static void handasit(double x1,double d,String[] series,String[] seriesSum){
        series[0] = x1+"";
        double sum = x1;
        seriesSum[0] = x1+"";
        double nextN = x1;
        for (int i=1;i<20;i++){
            nextN*=d;
            sum+=nextN;
            series[i] = nextN+"";
            seriesSum[i] = sum+"";

        }
    }

    public void onClick(View view) {
        tvX1.setText("");
        tvD.setText("");
        tvN.setText("");
        tvSn.setText("");

        Intent wi = getIntent();
        wi.putExtra("X1",x1);
        wi.putExtra("d", d);

        setResult(RESULT_OK,wi);
        finish();
    }
}