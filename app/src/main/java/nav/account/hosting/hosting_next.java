package nav.account.hosting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.letngo.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.HashMap;

public class hosting_next extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner kindPlace,placeDescription, spaceDescription;
    EditText street, city, state, zipCode;
    TextView guest, bed, room, bathroom, back, next;
    CountryCodePicker country;
    CheckBox pool, jaccuzi,patio, bbq, fit, table, indoor, outdoor,exercise,
            wifi, tv, aircon, kitchen, washer, freePark, paidPark, workspace, shower,
            kit, extinguisher, alarm, carbon;

    ImageView gMinus, gAdd,bMinus, bAdd,rMinus, rAdd, brMinus, brAdd;
    int countGuest = 0, countBed = 0, countRoom = 0, countBathroom = 0;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("Host_Account").child("Host_Place");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosting_next);

        //SETTING INITIALIZATIONS
        kindPlace = findViewById(R.id.spinner_kind_place);
        placeDescription = findViewById(R.id.spinner_describe);
        spaceDescription = findViewById(R.id.spinner_space);
        street = findViewById(R.id.ed_street);
        city = findViewById(R.id.ed_city);
        state = findViewById(R.id.ed_state);
        zipCode = findViewById(R.id.ed_zip);
        country = findViewById(R.id.ccp_country);
        //TEX VIEW
        guest = findViewById(R.id.tv_guest_result);
        bed = findViewById(R.id.tv_bed_result);
        room = findViewById(R.id.tv_room_result);
        bathroom = findViewById(R.id.tv_bathroom_result);
        //1ST SET CHECKBOX
        pool = findViewById(R.id.chk_pool);
        jaccuzi = findViewById(R.id.chk_jaccuzi);
        patio = findViewById(R.id.chk_patio);
        bbq = findViewById(R.id.chk_grill);
        fit = findViewById(R.id.chk_fire_fit);
        table = findViewById(R.id.chk_pool_table);
        indoor = findViewById(R.id.chk_fire_place);
        outdoor = findViewById(R.id.chk_dining);
        exercise = findViewById(R.id.chk_equipment);
        //2ND SET CHECKBOX
        wifi = findViewById(R.id.chk_wifi);
        tv = findViewById(R.id.chk_tv);
        aircon = findViewById(R.id.chk_air_con);
        kitchen = findViewById(R.id.chk_kitchen);
        washer = findViewById(R.id.chk_washer);
        freePark = findViewById(R.id.chk_parking);
        paidPark = findViewById(R.id.chk_paid_parking);
        workspace = findViewById(R.id.chk_workspace);
        shower = findViewById(R.id.chk_shower);
        //3RD SET CHECKBOX
        kit = findViewById(R.id.chk_kit);
        extinguisher = findViewById(R.id.chk_extinguisher);
        alarm = findViewById(R.id.chk_alarm);
        carbon = findViewById(R.id.chk_carbon_alarm);
        //BACK/NEXT
        back = findViewById(R.id.tv_back);
        next = findViewById(R.id.tv_next);


        //CALLING SPINNER METHODS
        spinnerKind_ofPlace();
        spinnerPlaceDescription();
        spinnerSpaceDescription();
        //END


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //STRINGS
                String h_street = street.getText().toString();
                String h_city = city.getText().toString();
                String h_state = state.getText().toString();
                String h_zip = zipCode.getText().toString();

                //------------------------------------------------------------------//

                //CALLING VALIDATION METHODS
                if (TextUtils.isEmpty(h_street)){
                    Toast.makeText(hosting_next.this, "Please enter your street.", Toast.LENGTH_LONG).show();
                    street.setError("Street Address is required");
                    street.requestFocus();
                }
                else if (TextUtils.isEmpty(h_city)){
                    Toast.makeText(hosting_next.this, "Please enter your city.", Toast.LENGTH_LONG).show();
                    city.setError("City is required");
                    city.requestFocus();
                }
                else if (TextUtils.isEmpty(h_state)){
                    Toast.makeText(hosting_next.this, "Please enter your state.", Toast.LENGTH_LONG).show();
                    state.setError("State is required");
                    state.requestFocus();
                }
                else if (TextUtils.isEmpty(h_zip)){
                    Toast.makeText(hosting_next.this, "Please enter your zip code.", Toast.LENGTH_LONG).show();
                    zipCode.setError("Zip Code is required");
                    zipCode.requestFocus();
                }
                else if(!pool.isChecked() && !jaccuzi.isChecked() && !patio.isChecked() && !bbq.isChecked() && !fit.isChecked() && !table.isChecked() && !indoor.isChecked() && !outdoor.isChecked() && !exercise.isChecked())
                {
                    Toast.makeText(hosting_next.this, "You haven't selected any Amenities.", Toast.LENGTH_LONG).show();
                }
                else if(!wifi.isChecked() && !tv.isChecked() && !aircon.isChecked() && !kitchen.isChecked() && !washer.isChecked() && !freePark.isChecked() && !paidPark.isChecked() && !workspace.isChecked() && !shower.isChecked())
                {
                    Toast.makeText(hosting_next.this, "You haven't selected any.", Toast.LENGTH_LONG).show();
                }
                else if(!kit.isChecked() && !extinguisher.isChecked() && !alarm.isChecked() && !carbon.isChecked())
                {
                    Toast.makeText(hosting_next.this, "You haven't selected any safety items.", Toast.LENGTH_LONG).show();
                }
                else {
                    hostRegistration();
                    Intent intent = new Intent(hosting_next.this, hosting_final_description.class);
                    startActivity(intent);
                }
            }
        });

        back.setOnClickListener(v -> onBackPressed());
    }

    //-------------------------------------------ALL METHODS STARTS HERE---------------------------------------------------//

    //HOST PLACE REGISTRATION METHOD
    public void hostRegistration()
    {
        //STRINGS
        String h_kind = kindPlace.getSelectedItem().toString();
        String h_place = placeDescription.getSelectedItem().toString();
        String h_space = spaceDescription.getSelectedItem().toString();

        String h_street = street.getText().toString();
        String h_city = city.getText().toString();
        String h_state = state.getText().toString();
        String h_zip = zipCode.getText().toString();
        String h_country = country.getSelectedCountryName();

        String h_guest = guest.getText().toString();
        String h_bed = bed.getText().toString();
        String h_room = room.getText().toString();
        String h_bathroom = bathroom.getText().toString();

        String h_pool = pool.getText().toString();
        String h_jaccuzi = jaccuzi.getText().toString();
        String h_patio = patio.getText().toString();
        String h_bbq = bbq.getText().toString();
        String h_fit = fit.getText().toString();
        String h_table = table.getText().toString();
        String h_indoor = indoor.getText().toString();
        String h_outdoor = outdoor.getText().toString();
        String h_ex = exercise.getText().toString();

        String h_wifi = wifi.getText().toString();
        String h_tv = tv.getText().toString();
        String h_ac = aircon.getText().toString();
        String h_kitchen = kitchen.getText().toString();
        String h_washer = washer.getText().toString();
        String h_free = freePark.getText().toString();
        String h_paid = paidPark.getText().toString();
        String h_workspace = workspace.getText().toString();
        String h_shower = shower.getText().toString();

        String h_kit = kit.getText().toString();
        String h_exting = extinguisher.getText().toString();
        String h_alarm = alarm.getText().toString();
        String h_carbon = carbon.getText().toString();

        //------------------------------------------------------------------//

        //HASH MAP
        HashMap<String, String> hostMap = new HashMap<>();
        hostMap.put("Place Type", h_kind);
        hostMap.put("Place Description", h_place);
        hostMap.put("Space Description", h_space);

        hostMap.put("Street", h_street);
        hostMap.put("City", h_city);
        hostMap.put("State", h_state);
        hostMap.put("Zip Code", h_zip);
        hostMap.put("Country", h_country);

        hostMap.put("Guest", h_guest);
        hostMap.put("Bed", h_bed);
        hostMap.put("Room", h_room);
        hostMap.put("Bathroom", h_bathroom);

        //HashMap<String, String> amenities = new HashMap<>();

        //IF-ELSE STATEMENT FOR AMENITIES CHECK BOX
        if(pool.isChecked())
        {
            hostMap.put("Amenities", h_pool);
        }
        else if(jaccuzi.isChecked())
        {
            hostMap.put("Amenities", h_jaccuzi);
        }
        else if(patio.isChecked())
        {
            hostMap.put("Amenities", h_patio);
        }
        else if(bbq.isChecked())
        {
            hostMap.put("Amenities", h_bbq);
        }
        else if(fit.isChecked())
        {
            hostMap.put("Amenities", h_fit);
        }
        else if(table.isChecked())
        {
            hostMap.put("Amenities", h_table);
        }
        else if(indoor.isChecked())
        {
            hostMap.put("Amenities", h_indoor);
        }
        else if(outdoor.isChecked())
        {
            hostMap.put("Amenities", h_outdoor);
        }
        else if(exercise.isChecked())
        {
            hostMap.put("Amenities", h_ex);
        }
        //IF-ELSE STATEMENT FOR OTHER SET CHECK BOX
        else if(wifi.isChecked())
        {
            hostMap.put("Appliances", h_wifi);
        }
        else if(tv.isChecked())
        {
            hostMap.put("Appliances", h_tv);
        }
        else if(aircon.isChecked())
        {
            hostMap.put("Appliances", h_ac);
        }
        else if(kitchen.isChecked())
        {
            hostMap.put("Appliances", h_kitchen);
        }
        else if(washer.isChecked())
        {
            hostMap.put("Appliances", h_washer);
        }
        else if(freePark.isChecked())
        {
            hostMap.put("Appliances", h_free);
        }
        else if(paidPark.isChecked())
        {
            hostMap.put("Appliances", h_paid);
        }
        else if(workspace.isChecked())
        {
            hostMap.put("Appliances", h_workspace);
        }
        else if(shower.isChecked())
        {
            hostMap.put("Appliances", h_shower);
        }
        //IF-ELSE STATEMENT FOR SAFETY ITEMS CHECK BOX
        else if(kit.isChecked())
        {
            hostMap.put("Appliances", h_kit);
        }
        else if(extinguisher.isChecked())
        {
            hostMap.put("Appliances", h_exting);
        }
        else if(alarm.isChecked())
        {
            hostMap.put("Appliances", h_alarm);
        }
        else if(carbon.isChecked())
        {
            hostMap.put("Appliances", h_carbon);
        }

        reference.push().setValue(hostMap);
        Toast.makeText(hosting_next.this, "SAVED!", Toast.LENGTH_SHORT).show();


    }

    // SPINNER METHODS
    //SPINNER KIND OF PLACE METHOD START
    public void spinnerKind_ofPlace()
    {
        Spinner spinner = findViewById(R.id.spinner_kind_place);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.kind_of_place_description, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    //SPINNER PLACE DESCRIPTION METHOD START
    public void spinnerPlaceDescription()
    {
        Spinner spinner = findViewById(R.id.spinner_describe);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.place_description, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    //SPINNER SPACE DESCRIPTION METHOD START
    public void spinnerSpaceDescription()
    {
        Spinner spinner = findViewById(R.id.spinner_space);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.space_description, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    // DON'T DELETE THIS METHOD
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    // DON'T DELETE THIS METHOD
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //INCREMENT METHOD
    public void incrementGuest(View v)
    {
        gAdd = findViewById(R.id.img_guest_add);

        countGuest++;
        guest.setText("" + countGuest);
    }

    public void incrementBed(View v)
    {
        bAdd = findViewById(R.id.img_bed_add);

        countBed++;
        bed.setText("" + countBed);
    }

    public void incrementRoom(View v)
    {
        rAdd = findViewById(R.id.img_room_add);

        countRoom++;
        room.setText("" + countRoom);

    }

    public void incrementBathroom(View v)
    {
        brAdd = findViewById(R.id.img_bathroom_add);

        countBathroom++;
        bathroom.setText("" + countBathroom);
    }


    //DECREMENT METHOD
    public void decrementGuest(View v)
    {
        gMinus = findViewById(R.id.img_guest_minus);

        if (countGuest <= 0) {
            countGuest = 0;
            Toast.makeText(hosting_next.this, "QUANTITY CANNOT BE LOWER THAN ZERO", Toast.LENGTH_LONG).show();
        }
        else {
            countGuest--;
            guest.setText("" + countGuest);
        }
    }

    public void decrementBed(View v)
    {
        bMinus = findViewById(R.id.img_bed_minus);

        if (countBed <= 0) {
            countBed = 0;
            Toast.makeText(hosting_next.this, "QUANTITY CANNOT BE LOWER THAN ZERO", Toast.LENGTH_LONG).show();
        }
        else {
            countBed--;
            bed.setText("" + countBed);
        }
    }

    public void decrementRoom(View v)
    {
        rMinus = findViewById(R.id.img_room_minus);

        if (countRoom <= 0) {
            countRoom = 0;
            Toast.makeText(hosting_next.this, "QUANTITY CANNOT BE LOWER THAN ZERO", Toast.LENGTH_LONG).show();
        }
        else {
            countRoom--;
            room.setText("" + countRoom);
        }
    }

    public void decrementBathroom(View v)
    {
        brMinus = findViewById(R.id.img_bathroom_minus);

        if (countBathroom <= 0) {
            countBathroom = 0;
            Toast.makeText(hosting_next.this, "QUANTITY CANNOT BE LOWER THAN ZERO", Toast.LENGTH_LONG).show();
        }
        else {
            countBathroom--;
            bathroom.setText("" + countBathroom);
        }
    }
}