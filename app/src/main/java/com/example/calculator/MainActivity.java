package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    public EditText e1, e2;
    TextView t1;
    int num1, num2;

    public boolean getNumbers() {


        e1 = (EditText) findViewById(R.id.num1);


        e2 = (EditText) findViewById(R.id.num2);

        t1 = (TextView) findViewById(R.id.result);


        String s1 = e1.getText().toString();

        String s2 = e2.getText().toString();



        if(s1.equals("Введи первую цифру") && s2.equals(null))
        {
            String result = "Введи вторую цифру";
            e2.setText(result);
            return false;
        }
        if(s1.equals(null) && s2.equals("Введи вторую цифру"))
        {
            String result = "Введи первую цифру";
            e1.setText(result);
            return false;
        }
        if(s1.equals("Введи первую цифру") || s2.equals("Введи вторую цифру"))
        {
            return false;
        }

        if((!s1.equals(null) && s2.equals(null))|| (!s1.equals("") && s2.equals("")) ){

            String result = "Введи вторую цифру";

            e2.setText(result);
            return false;
        }
        if((s1.equals(null) && !s2.equals(null))|| (s1.equals("") && !s2.equals("")) ){

            String result = "Введи первую цифру";
            e1.setText(result);
            return false;
        }
        if((s1.equals(null) && s2.equals(null))|| (s1.equals("") && s2.equals("")) ){

            String result1 = "Введи первую цифру";
            e1.setText(result1);
            String result2 = "Введи вторую цифру";
            e2.setText(result2);
            return false;
        }

        else {

            num1 = Integer.parseInt(s1);


            num2 = Integer.parseInt(s2);


        }

        return true;
    }

    public void doSum(View v) {


        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(Integer.toString(sum));
        }
        else
        {
            t1.setText("Введи значения!");
        }

    }
    public void clearTextNum1(View v) {


        e1.getText().clear();
    }
    public void clearTextNum2(View v) {


        e2.getText().clear();
    }
    public void doPow(View v) {


        if (getNumbers()) {
            double sum = Math.pow(num1, num2);
            t1.setText(Double.toString(sum));
        }
        else
        {
            t1.setText("Введи значения!");
        }
    }


    public void doSub(View v) {

        if (getNumbers()) {
            int sum = num1 - num2;
            t1.setText(Integer.toString(sum));
        }
        else
        {
            t1.setText("Введи значения!");
        }
    }


    public void doMul(View v) {

        if (getNumbers()) {
            int sum = num1 * num2;
            t1.setText(Integer.toString(sum));
        }
        else
        {
            t1.setText("Введи значения!");
        }
    }


    public void doDiv(View v) {

        if (getNumbers()) {


            double sum = num1 / (num2 * 1.0);
            t1.setText(Double.toString(sum));
        }
        else
        {
            t1.setText("Введи значения!");
        }
    }


    public void doMod(View v) {

        if (getNumbers()) {
            double sum = num1 % num2;
            t1.setText(Double.toString(sum));
        }
        else
        {
            t1.setText("Введи значения!");
        }
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.num2);

        e2 = (EditText) findViewById(R.id.num2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
