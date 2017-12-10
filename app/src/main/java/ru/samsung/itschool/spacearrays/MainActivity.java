package ru.samsung.itschool.spacearrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        ImageView image = (ImageView) findViewById(R.id.myImage); image.setAlpha(150);
    }

    public void doIt(View view) {
        Toast.makeText(this, "HelloAstronauts!", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        doIt(view);
    }
}