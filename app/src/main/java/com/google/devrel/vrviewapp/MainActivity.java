package com.google.devrel.vrviewapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.exception.DropboxUnlinkedException;
import com.dropbox.client2.session.AppKeyPair;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private EditText text;

    final static private String APP_KEY = "lpockvr9197gefb";
    final static private String APP_SECRET = "h4drmb3ebhfb8vt";

    // In the class declaration section:
    private DropboxAPI<AndroidAuthSession> mDBApi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonGo);
        text = (EditText) findViewById(R.id.plain_text_input);

        text.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonGo){
            if(TextUtils.isEmpty(text.getText().toString())){
                Toast.makeText(MainActivity.this, "Please enter a code", Toast.LENGTH_SHORT).show();
            }
            else if(!text.getText().toString().trim().matches("\\d+(?:\\.\\d+)?")){
                Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
            }
            else{
                //Toast.makeText(MainActivity.this, "VR Mode", Toast.LENGTH_SHORT).show();

                AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
                AndroidAuthSession session = new AndroidAuthSession(appKeys);
                mDBApi = new DropboxAPI<AndroidAuthSession>(session);
                try {
                    // Required to complete auth, sets the access token on the session
                    mDBApi.getSession().finishAuthentication();

                    String accessToken = mDBApi.getSession().getOAuth2AccessToken();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }

                // MyActivity below should be your activity class name

                /*
                // INPUT
                File file = new File("Powerpoint.pptx");
                FileInputStream inputStream = null;


                try {
                    inputStream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                DropboxAPI.Entry response = null;


                try {
                    response = mDBApi.putFile("/stored.pptx", inputStream, file.length(), null, null);
                } catch (DropboxException e) {
                    e.printStackTrace();
                }*/

                // OUTPUT
                /*File file = new File("OutPPT.pptx");
                FileOutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                DropboxAPI.DropboxFileInfo info = null;
                try {
                    info = mDBApi.getFile("/stored.pptx", null, outputStream, null);
                } catch (DropboxException e) {
                    e.printStackTrace();
                }*/


                //Toast.makeText(MainActivity.this, info.toString(), Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this,  info.toString(), Toast.LENGTH_LONG).show();

                finish();
                startActivity(new Intent(getApplicationContext(), VRActivity.class));

            }
        }
    }
    /*protected void onResume() {
        super.onResume();

        if (mDBApi.getSession().authenticationSuccessful()) {
            try {
                // Required to complete auth, sets the access token on the session
                mDBApi.getSession().finishAuthentication();

                String accessToken = mDBApi.getSession().getOAuth2AccessToken();
            } catch (IllegalStateException e) {
                Log.i("DbAuthLog", "Error authenticating", e);
            }
        }
    }*/

    /*public Image[] getDropBoxFile() {


        return new Image();
    }*/
}