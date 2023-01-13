package ae.ogrenci_usulu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button a = (Button) findViewById(R.id.button);
        setContentView(R.layout.activity_test);
    }
}