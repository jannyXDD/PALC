package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Login extends AppCompatActivity {

    private TextView textViewEmail;
    private TextView textViewPassword;
    private FloatingActionButton button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewEmail = findViewById(R.id.editTextEmail);
        textViewPassword = findViewById(R.id.editTextPassword);
        button = findViewById(R.id.floatingActionButton);


    }
}