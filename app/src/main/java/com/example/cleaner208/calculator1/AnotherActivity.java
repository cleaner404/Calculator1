package com.example.cleaner208.calculator1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);


        Switch swi=(Switch)findViewById(R.id.switch2);
//        swi.setChecked();
        swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked) {

                    //非选中时 do some thing

                    Intent intent=new Intent();
                    intent.setClass(AnotherActivity.this,MainActivity.class);
                    startActivity(intent);
                    //设置切换动画，从左边进入，右边退出
                    overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                    finish();

                } else {
                    //选中时 do some thing
                    return;

                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //下拉列表选择事件监听器
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>=0)
                    Toast.makeText(AnotherActivity.this,adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        TextView textView=(TextView)findViewById(R.id.txt_change);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonLength:
                if (checked)
                    textView.setText("当前选择为长度");
                break;
            case R.id.radioButtonTemperature:
                if (checked)
                    textView.setText("当前选择为温度");
                break;
            case R.id.radioButtonMass:
                if (checked)
                    textView.setText("当前选择为温度");
                break;
        }
    }

}
