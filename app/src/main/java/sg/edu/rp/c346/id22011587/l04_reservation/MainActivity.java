package sg.edu.rp.c346.id22011587.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayReserve;
    Button btnDisplayReset;
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayReserve = findViewById(R.id.reservebtn);
        btnDisplayReset = findViewById(R.id.resetbtn);
        tvDisplay = findViewById(R.id.textViewDisplay);

        btnDisplayReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the current date and time
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                Date date = calendar.getTime();

                //Format the time as "hh:mm a"
                SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
                String time = format.format(calendar.getTime());

                //Format the date as "D/M/Y"
                SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/y", Locale.getDefault());
                String dateString = dateFormat.format(date);

                //Set the date to a textView with "Date is" prefix
                //Set the time to a TextView
                TextView textView = findViewById(R.id.textViewDisplay);
                String displayText = "Date is " + dateString + " " + "Time is " + time;
                textView.setText(displayText);

            }
        });
        btnDisplayReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(2020, Calendar.JUNE, 1);

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePicker dp = findViewById(R.id.datePicker);
                dp.updateDate(year, month, day);

                TimePicker tp = findViewById(R.id.timePicker);
                tp.setHour(19);  // 7 PM
                tp.setMinute(30);
            }
        });

    }
}
