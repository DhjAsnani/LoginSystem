package com.example.gohan.loginsystem;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Freeware Sys on 17-Jun-16.
 */
// 3rd one is result and result in string so..
public class BackgroudTask extends AsyncTask<String,Void,String> {
    Context ctx;
    BackgroudTask(Context ctx)
    {
        this.ctx = ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        //reg_url for register
        String reg_url = "http://192.168.26.3:8080/Learn/webapp/register.php";
        String login_url = "http://127.0.0.7:8080/Learn/webapp/login.php";

        String method = params[0];
        //if reg then perform register
        if(method.equals("register"))
        {
            String name = params[1];
            String  username = params[2];
            String userpas = params[3];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                // as we are passing the info
                httpURLConnection.setDoOutput(true);
                // we need an output stream
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                //encode data before send it
                String data = URLEncoder.encode("user","UTF-8") + "=" + URLEncoder.encode(name,"UTF-8")+"&"+URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+
                        "&"+URLEncoder.encode("user_pass","UTF-8")+"="+URLEncoder.encode(userpas,"UTF-8");
                //write data to buffer necessary
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                // Now create inputstream to get response from the server
                // still no response required to work on

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success.....";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
    }
}
