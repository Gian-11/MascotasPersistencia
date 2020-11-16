package com.gian.mascotasfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gian.mascotasfinal.javamail.EnviarCorreo;
import com.gian.mascotasfinal.javamail.SendMail;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class Contact extends AppCompatActivity {

    TextView titulo;
    private EditText etNombre;
    private EditText etMail;
    private EditText etMsj;
    private Button btnEnviar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etMail = (EditText) findViewById(R.id.etMail);
        etMsj = (EditText) findViewById(R.id.etMsj);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                if (!wifiManager.isWifiEnabled()) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
                    Snackbar.make(v, R.string.enable_wifi_msg, Snackbar.LENGTH_LONG).show();
                } else if (etNombre.length() == 0){
                   etNombre.setError(getString(R.string.error_name));
                } else if (etMail.length() < 3) {
                    etMail.setError(getString(R.string.error_email));
                } else if (etMsj.length() == 0){
                    etMsj.setError(getString(R.string.error_feedback));
                } else {
                    try {
                        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
                        enviarCorreo();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        });


        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionBarContacto);
        titulo = (TextView) findViewById(R.id.toolbar_title);
        titulo.setText(R.string.activityContacto_title);

        setSupportActionBar(miActionbar);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void enviarCorreo () throws Exception {
        String nombre = etNombre.getText().toString().trim();
        String email = etMail.getText().toString().trim();
        String mensaje = etMsj.getText().toString().trim();

        try {
            EnviarCorreo sender = new EnviarCorreo(getString(R.string.email), getString(R.string.email_password));
            sender.sendMail("Test", getString(R.string.email_body) + " " + nombre + "\n\n"
                            + getString(R.string.email_2) + " " + email + "\n\n"
                            + getString(R.string.mensaje) + " " +mensaje,
                    getString(R.string.email) , "Enter the recipients");

            SendMail sm = new SendMail(this);
            sm.execute(sender);
            //sm.get();
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
    }




}