package com.gian.mascotasfinal.javamail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.gian.mascotasfinal.Contact;
import com.gian.mascotasfinal.R;
import com.google.android.material.snackbar.Snackbar;

public class SendMail extends AsyncTask<EnviarCorreo, Void, Void> {

    private ProgressDialog progressDialog;
    private Context context;
    private Contact act;
    private View v;


    public SendMail(Context context){
        this.context = context;
        this.act = (Contact) context;
    }


    @Override
    protected Void doInBackground(EnviarCorreo... params) {
        int count = params.length;
        for(int i = 0; i < count; i++){
            try{
                params[i].sendMail();
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        //super.onPreExecute();
        progressDialog = ProgressDialog.show(context, context.getString(R.string.sending_feedback_title),
                context.getString(R.string.sending_feedback),
                false, false);
    }



    protected void onPostExecute(Void aVoid) {
        //super.onPostExecute(aVoid);
        //Dismissing the progress dialog
        progressDialog.dismiss();
        //Showing a success message
        Toast.makeText(context, R.string.toast_complete, Toast.LENGTH_SHORT).show();
        act.finish();
    }




}
