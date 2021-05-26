package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Login extends AppCompatActivity {

    private TextView textViewEmail;
    private TextView textViewPassword;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewEmail = findViewById(R.id.editTextEmail);
        textViewPassword = findViewById(R.id.editTextPassword);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = textViewEmail.getText().toString();
                String userPassword = textViewPassword.getText().toString();
                if (userEmail.isEmpty() || userPassword.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {

                    UserDataBase userDataBase = UserDataBase.getInstance(getApplicationContext());
                    UserDao userDao = userDataBase.getUserDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.checkLogin(userEmail, userPassword);
                            if (user == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Dados Inválidos!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                startActivity(new Intent(Login.this, MainActivity.class));
                            }
                        }
                    }).start();
                }
            }
        });
    }
}