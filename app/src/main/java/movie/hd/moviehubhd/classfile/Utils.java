package movie.hd.moviehubhd.classfile;

import android.app.ProgressDialog;
import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Utils {
    public static DatabaseReference actionMovie = FirebaseDatabase.getInstance().getReference("Action");
    public static DatabaseReference referenceFile = FirebaseDatabase.getInstance().getReference("File");
    public static DatabaseReference referenceVideo = FirebaseDatabase.getInstance().getReference("video");
    public static Context context;
    public static  ProgressDialog progressDialog;
}
