package com.example.date;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    EditText sdate;
    EditText edate;
    TextView year,month,hour,day,mintues,seconds;
    int sYear,sMonth,sDay,eYear,eMonth,eDay;
    int sYear2,sMonth2,sDay2,eYear2,eMonth2,eDay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        year=(TextView) findViewById(R.id.textView2);
        month=(TextView) findViewById(R.id.textView4);
        hour=(TextView) findViewById(R.id.textView8);
        day=(TextView) findViewById(R.id.textView6);
        mintues=(TextView) findViewById(R.id.textView10);
        seconds=(TextView) findViewById(R.id.textView12);
        sdate=(EditText)findViewById(R.id.editTextDate);
        edate=(EditText)findViewById(R.id.editTextDate2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }


    public  void Date_difference() throws ParseException {
        Date startDate = null;// = // Set start date
        Date endDate = null;//  = // Set end date
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        startDate= format.parse(String.valueOf(sDay2)+"/"+String.valueOf(sMonth2+1)+"/"+String.valueOf(sYear2));
        System.out.println(String.valueOf(sDay2)+"/"+String.valueOf(sMonth2+1)+"/"+String.valueOf(sYear2));
        System.out.println(String.valueOf(eDay2)+"/"+String.valueOf(eMonth2+1)+"/"+String.valueOf(eYear2));
        endDate = format.parse(String.valueOf(eDay2)+"/"+String.valueOf(eMonth2+1)+"/"+String.valueOf(eYear2));
        long duration  = endDate.getTime() - startDate.getTime();

        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
        double years = diffInDays/365;
        double months = diffInDays/30.417;
        System.out.println(diffInDays+" "+diffInHours+" "+diffInMinutes+" "+diffInSeconds+" "+startDate+"  "+endDate);
        year.setText(String.valueOf(years));
        month.setText(String.valueOf(months));
        day.setText(String.valueOf(diffInDays));
        hour.setText(String.valueOf(diffInHours));
        seconds.setText(String.valueOf(diffInSeconds));
        mintues.setText(String.valueOf(diffInMinutes));
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
//    @Override
    public void onClick(View v) {

        if (v == button1) {

            // Get Current Date

            final Calendar c = Calendar.getInstance();
            sYear = c.get(Calendar.YEAR);
            sMonth = c.get(Calendar.MONTH);
            sDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            sdate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            sYear2=year;
                            sDay2=dayOfMonth;
                            sMonth2=monthOfYear;
                        }
                    }, sYear, sMonth, sDay);
            datePickerDialog.show();
        }
        if (v == button2) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            eYear = c.get(Calendar.YEAR);
            eMonth = c.get(Calendar.MONTH);
            eDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            edate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            eYear2=year;
                            eDay2=dayOfMonth;
                            eMonth2=monthOfYear;
                        }
                    }, eYear, eMonth, eDay);
            datePickerDialog.show();
        }
        if(v == button3)
        {
            try{
                Date_difference();
            }
            catch (ParseException e)
            {
                System.out.println("exception");
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
