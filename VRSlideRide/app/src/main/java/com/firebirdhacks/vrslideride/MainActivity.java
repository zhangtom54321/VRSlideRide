package com.firebirdhacks.vrslideride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonGo);
        text = (EditText) findViewById(R.id.plain_text_input);

        //text.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonGo){
            //Toast.makeText(MainActivity.this, "Button Pressed", Toast.LENGTH_SHORT).show();
            if(TextUtils.isEmpty(text.getText().toString())){
                Toast.makeText(MainActivity.this, "Please enter a code", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "VR Mode", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), SlideActivity.class));
                finish();
            }
        }
    }
}
