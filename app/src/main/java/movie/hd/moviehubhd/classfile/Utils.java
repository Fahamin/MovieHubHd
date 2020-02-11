package movie.hd.moviehubhd.classfile;

import android.app.ProgressDialog;
import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Utils {

    public static DatabaseReference actionF = FirebaseDatabase.getInstance().getReference("Action");
    public static DatabaseReference adventureF = FirebaseDatabase.getInstance().getReference("Advnture");
    public static DatabaseReference animationF = FirebaseDatabase.getInstance().getReference("Animation");
    public static DatabaseReference comedyF = FirebaseDatabase.getInstance().getReference("Comedy");
    public static DatabaseReference crimeF = FirebaseDatabase.getInstance().getReference("Crime");
    public static DatabaseReference horrorF = FirebaseDatabase.getInstance().getReference("Horror");
    public static DatabaseReference romanceF = FirebaseDatabase.getInstance().getReference("Romance");
    public static DatabaseReference sportF = FirebaseDatabase.getInstance().getReference("Sport");
    public static DatabaseReference thillerF = FirebaseDatabase.getInstance().getReference("Thiller");
    public static DatabaseReference warF = FirebaseDatabase.getInstance().getReference("warMovie");



    public static Context context;
    public static  ProgressDialog progressDialog;
}
