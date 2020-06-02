package com.example.prov;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends AppCompatActivity  implements  ZXingScannerView.ResultHandler{


    //private Button btnAbrir;
    private ZXingScannerView escaneaQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btnAbrir = (Button) findViewById(R.id.button);

        /*btnAbrir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EscanerQR();
            }
        });*/


        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA);
        if(permissionCheck == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)){
            }else{
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA}, 1);
            }
        }



    }
    public void EscanerQR (View c){
        escaneaQR = new ZXingScannerView(this);
        setContentView(escaneaQR);
        escaneaQR.setResultHandler(this);
        escaneaQR.startCamera();



        //
    }

    @Override
    public void handleResult(Result result) {
        /*Log.e("inicio valor qr", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("bienvenido");
        builder.setMessage();
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        escaneaQR.resumeCameraPreview(this);*/

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(result.getText())));
        finish();
    }
}
