package movie.hd.moviehubhd.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.model.MovieModel;

import static movie.hd.moviehubhd.classfile.Utils.actionMovie;

public class FirebaseSetup extends AppCompatActivity {
    EditText titleTxt, linkTxt, lengthTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_setup);

        initView();
    }

    private void saveData() {
        MovieModel fmodelClass = new MovieModel();

        String title, link, length;
        title = titleTxt.getText().toString().trim();
        link = linkTxt.getText().toString().trim();
        length = lengthTxt.getText().toString().trim();

        if (title.isEmpty()) {
            titleTxt.setError("pls enter titile");
            titleTxt.requestFocus();
            return;
        }
        if (link.isEmpty()) {
            linkTxt.setError("empty");
            linkTxt.requestFocus();
            return;
        }
        if (length.isEmpty()) {
            lengthTxt.setError("empty");
            lengthTxt.requestFocus();
            return;
        }

        String key_id = actionMovie.push().getKey();
        int i = 0;
        MovieModel modelData = new MovieModel(i, title, link, length, key_id);
        actionMovie.child(key_id).setValue(modelData).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(FirebaseSetup.this, "save Data", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(FirebaseSetup.this, "Error save Data", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        titleTxt = findViewById(R.id.titleEtdID);
        linkTxt = findViewById(R.id.lengthEtdID);
        lengthTxt = findViewById(R.id.lengthEtdID);
    }


    public void viewData(View view) {
       // startActivity(new Intent(this, MainActivity.class));
    }

    public void save(View view) {
        saveData();
    }
}
