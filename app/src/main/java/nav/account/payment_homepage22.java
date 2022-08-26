package nav.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.letngo.R;

public class payment_homepage22 extends AppCompatActivity {
    ImageButton back;
    Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_homepage22);

        back = findViewById(R.id.back);
        select = findViewById(R.id.button);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment_homepage22.this, payment_homepage23.class);
                startActivity(intent);
            }
        });


        back.setOnClickListener(v -> onBackPressed());

    }
}