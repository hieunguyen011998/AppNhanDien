package com.example.appnhandien;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imagePerson;
    private TextView txtName,txtSex,txtPhong;
    private Button btnCheckIn;
    int REQUEST_IMAGE_CAPTURE ;
    String name,sex,phong;
    ImageView imgBackgroud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
    public void addControls()
    {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_lam_mo_backgroud);
        imagePerson = (ImageView) findViewById(R.id.imagePerson);
        txtName = (TextView) findViewById(R.id.txtResultName);
        txtSex = (TextView) findViewById(R.id.txtResultSex);
        txtPhong  = (TextView) findViewById(R.id.txtResultPhong);
        btnCheckIn = (Button) findViewById(R.id.btnCheckIn);
        imgBackgroud = (ImageView) findViewById(R.id.imageViewBackgroud);
        imgBackgroud.startAnimation(animation);
    }
    public void addEvents()
    {
         btnCheckIn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                 startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
             }
         });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagePerson.setImageBitmap(imageBitmap);
            Dialog();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void Dialog()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông báo");
        alert.setIcon(R.drawable.ic_report_black_24dp);
        alert.setMessage("Bạn đã check in thành công ");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog a = alert.create();
        a.show();
    }
    public void infoPerson()
    {

    }
}
