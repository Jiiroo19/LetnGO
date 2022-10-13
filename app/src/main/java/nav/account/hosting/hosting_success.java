package nav.account.hosting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.letngo.R;

public class hosting_success extends AppCompatActivity {

    Button success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosting_success);

        success = findViewById(R.id.success);

        success.setOnClickListener(v -> {
            Intent intent = new Intent(hosting_success.this, Manage_Hosting.class);
            startActivity(intent);
        });
    }
}