package com.example.codebox.basemaster;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView display,upperDisplay;
    Spinner ip,op;
    Button one,two,three,four,five,six,seven,eight,nine,zero,a,b,c,d,e,f,and,or,not,xor;
    ImageView del;
    HorizontalScrollView scr,uscr;

    String binary = "01";
    String octal = "01234567";
    String decimal = "0123456789";
    String hexadecimal = "0123456789abcdef";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scr = (HorizontalScrollView) findViewById(R.id.s);
        uscr = (HorizontalScrollView) findViewById(R.id.uscr);

        ip = (Spinner) findViewById(R.id.ip);
        op = (Spinner) findViewById(R.id.op);

        ip.setSelection(0);
        op.setSelection(0);

        display = (TextView) findViewById(R.id.display);
        upperDisplay = (TextView) findViewById(R.id.upperDisplay);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);

        del = (ImageView) findViewById(R.id.del);

        and = (Button) findViewById(R.id.and);
        or = (Button) findViewById(R.id.or);
        not = (Button) findViewById(R.id.not);
        xor = (Button) findViewById(R.id.xor);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);

        del.setOnClickListener(this);

        and.setOnClickListener(this);
        or.setOnClickListener(this);
        xor.setOnClickListener(this);

        //input output
        ip.setOnItemSelectedListener(this);
        op.setOnItemSelectedListener(this);

        //Delete button long click.
        del.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                display.setText("");
                upperDisplay.setText("");
                scr.postDelayed(new Runnable(){
                    public void run(){
                        uscr.fullScroll(HorizontalScrollView.FOCUS_LEFT);
                    }
                }, 30L);
                return false;
            }
        });

        //Not button long press.
        not.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               try{
                   operationfix();
                   Operation o = new Operation();
                   if(!display.getText().toString().isEmpty()){
                       if(display.getText().toString().indexOf("&") != -1 || display.getText().toString().indexOf("v") != -1 || display.getText().toString().indexOf("x") != -1)
                           return true;

                       upperDisplay.setText("NOT");
                       display.setText(o.binaryNot(display.getText().toString()));
                   }
               }finally {
                   return true;
               }
            }
        });

        //And button long press.
        and.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try{
                    Operation o = new Operation();
                    String[] part = display.getText().toString().split("&");
                    display.setText(o.and(display.getText().toString()));
                    upperDisplay.setText(part[0]+" AND "+part[1]);
                }finally {
                    return true;
                }
            }
        });

        //Or button long press.
        or.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               try{
                   Operation o = new Operation();
                   String[] part = display.getText().toString().split("v");
                   display.setText(o.or(display.getText().toString()));
                   upperDisplay.setText(part[0]+" OR "+part[1]);
               }finally {
                   return true;
               }
            }
        });

        //Xor button long press.
        xor.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try{
                    Operation o = new Operation();
                    String[] part = display.getText().toString().split("x");
                    display.setText(o.xor(display.getText().toString()));
                    upperDisplay.setText(part[0]+" XOR "+part[1]);
                }finally {
                    return true;
                }
            }
        });
    }

    //Onclick buttons
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.zero:
                updateDisplay("0");
                if(inputCheck())
                    convert();
                break;

            case R.id.one:
                updateDisplay("1");
                if(inputCheck())
                    convert();
                break;

            case R.id.two:
                if (check("2")){
                    showToast();
                    break;
                }
                updateDisplay("2");
                convert();
                break;

            case R.id.three:
                if(check("3")){
                    showToast();
                    break;
                }
                updateDisplay("3");
                convert();
                break;

            case R.id.four:
                if(check("4")){
                    showToast();
                    break;
                }
                updateDisplay("4");
                convert();
                break;

            case R.id.five:
                if(check("5")){
                    showToast();
                    break;
                }
                updateDisplay("5");
                convert();
                break;

            case R.id.six:
                if(check("6")){
                    showToast();
                    break;
                }
                updateDisplay("6");
                convert();
                break;

            case R.id.seven:
                if(check("7")){
                    showToast();
                    break;
                }
                updateDisplay("7");
                convert();
                break;

            case R.id.eight:
                if(check("8")){
                    showToast();
                    break;
                }
                updateDisplay("8");
                convert();
                break;

            case R.id.nine:
                if(check("9")){
                    showToast();
                    break;
                }
                updateDisplay("9");
                convert();
                break;

            case R.id.a:
                if(check("a")){
                    showToast();
                    break;
                }
                updateDisplay("A");
                convert();
                break;

            case R.id.b:
                if(check("b")){
                    showToast();
                    break;
                }
                updateDisplay("B");
                convert();
                break;

            case R.id.c:
                if(check("c")){
                    showToast();
                    break;
                }
                updateDisplay("C");
                convert();
                break;

            case R.id.d:
                if(check("d")){
                    showToast();
                    break;
                }
                updateDisplay("D");
                convert();
                break;

            case R.id.e:
                if(check("e")){
                    showToast();
                    break;
                }
                updateDisplay("E");
                convert();
                break;

            case R.id.f:
                if(check("f")){
                    showToast();
                    break;
                }
                updateDisplay("F");
                convert();
                break;

            case R.id.del:
                delete(display.getText().toString());
                break;


            //AND OR NOT XOR buttons
            case R.id.and:
                operationfix();
                if (!display.getText().toString().isEmpty()){
                    display.setText(display.getText().toString().concat("&"));
                    upperDisplay.setText("AND");
                    break;
                }
                break;

            case R.id.or:
               operationfix();
                if (!display.getText().toString().isEmpty()){
                    display.setText(display.getText().toString().concat("v"));
                    upperDisplay.setText("OR");
                    break;
                }
                break;

            case R.id.xor:
                operationfix();
                if (!display.getText().toString().isEmpty()){
                    display.setText(display.getText().toString().concat("x"));
                    upperDisplay.setText("XOR");
                    break;
                }
                break;

            default:
                break;
        }
    }
    public void showToast(){
        Toast.makeText(this.getApplicationContext(),ip.getSelectedItem().toString()+" Input Only", Toast.LENGTH_SHORT).show();
    }
    private boolean check(String input){
        if(ip.getSelectedItemPosition() == 0 && binary.indexOf(input) != -1){
            //message = "Binary Input Only";
            return false;
        }

        if(ip.getSelectedItemPosition() == 1 && octal.indexOf(input) != -1){
           // message = "Octal Input Only";
            return false;
        }

        if(ip.getSelectedItemPosition() == 2 && decimal.indexOf(input) != -1){
           // message = "Decimal Input Only";
            return false;
        }

        if(ip.getSelectedItemPosition() == 3 && hexadecimal.indexOf(input) != -1){
           // message = "Octal Input Only";
            return false;
        }

        return true;
    }

    private boolean inputCheck() {
        String s = display.getText().toString();
        if (s.indexOf("&") != -1){
            ip.setSelection(0);
            op.setSelection(0);
            return false;
        }

        if (s.indexOf("v") != -1){
            ip.setSelection(0);
            op.setSelection(0);
            return false;
        }

        if (s.indexOf("x") != -1){
            ip.setSelection(0);
            op.setSelection(0);
            return false;
        }
        return true;
    }

    //AND OR NOT XOR fix for Octal and Hexadecimal.
    private void operationfix(){
        if (ip.getSelectedItemPosition() == 1 || ip.getSelectedItemPosition() == 2 || ip.getSelectedItemPosition() == 3){
            Toast.makeText(this, "Hex Oct Dec not supported", Toast.LENGTH_SHORT).show();
            ip.setSelection(0);
            op.setSelection(0);
            display.setText("");
            upperDisplay.setText("");
        }
    }

    //Base convert method.
    private void convert(){
        //Toast.makeText(this,op.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
        try {
            if (ip.getSelectedItem().toString().equals(op.getSelectedItem().toString())){
                upperDisplay.setText(display.getText().toString());
                return;
            }

            //Object creation of convert class.
            Convert c = new Convert();

            //Binary to all System
            if (ip.getSelectedItemPosition() == 0) {
                //Binary to Octal.
                if (op.getSelectedItemPosition() == 1) {
                    //Toast.makeText(this,"working",Toast.LENGTH_LONG).show();
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText(c.binaryToOctal(display.getText().toString()));
                    return;
                }
                //Binary to Decimal.
                if (op.getSelectedItemPosition() == 2) {
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText("" + c.binaryToDecimal(display.getText().toString()));
                    return;
                }
                //Binary to Hexadecimal.
                if (op.getSelectedItemPosition() == 3) {
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText(c.binaryToHexadecimal(display.getText().toString()).toUpperCase());
                    return;
                }
            }

            //Octal to all System
            if (ip.getSelectedItemPosition() == 1) {
                //Octal to Binary.
                if (op.getSelectedItemPosition() == 0) {
                    //Toast.makeText(this,"working",Toast.LENGTH_LONG).show();
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText(c.octalToBinary(display.getText().toString()));
                    return;
                }
                //Octal to Decimal.
                if (op.getSelectedItemPosition() == 2) {
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText("" + c.octalToDecimal(display.getText().toString()));
                    return;
                }
                //Octal to Hexadecimal.
                if (op.getSelectedItemPosition() == 3) {
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText(c.octalToHexadecimal(display.getText().toString()).toUpperCase());
                    return;
                }
            }

            //Decimal to all System
            if (ip.getSelectedItemPosition() == 2) {
                //Decimal to Binary.
                if (op.getSelectedItemPosition() == 0) {
                    //Toast.makeText(this,"working",Toast.LENGTH_LONG).show();
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText(c.decimalToBinary(display.getText().toString()));
                    return;
                }
                //Decimal to Octal.
                if (op.getSelectedItemPosition() == 1) {
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText(c.decimalToOctal(display.getText().toString()));
                    return;
                }
                //Decimal to Hexadecimal.
                if (op.getSelectedItemPosition() == 3) {
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText(c.decimalToHexadecimal(display.getText().toString()).toUpperCase());
                    return;
                }
            }


            //Hexadecimal to all System
            if (ip.getSelectedItemPosition() == 3) {
                //Hexadecimal to Binary.
                if (op.getSelectedItemPosition() == 0) {
                    //Toast.makeText(this,"working",Toast.LENGTH_LONG).show();
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText(c.hexadecimalToBinary(display.getText().toString()));
                    return;
                }
                //Hexadecimal to Octal.
                if (op.getSelectedItemPosition() == 1) {
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText(c.hexadecimalToOctal(display.getText().toString()));
                    return;
                }
                //Hexadecimal to Decimal.
                if (op.getSelectedItemPosition() == 2) {
                    //upperDisplay.setText(display.getText().toString());
                    upperDisplay.setText("" + c.hexadecimalToDecimal(display.getText().toString()));
                    return;
                }
            }

        }
        catch(NumberFormatException e){
            Toast.makeText(this, "Number is too large", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){}

    }

    //Delete method.
    private void delete(String s){
        if(!s.isEmpty()) {
            display.setText(s.substring(0, s.length() - 1));
            if (display.getText().toString().isEmpty())
                upperDisplay.setText("");
            else
                convert();
        }

        //AutoScroll.
        scr.postDelayed(new Runnable(){
            public void run(){
                scr.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
            }
        }, 30L);

        //scr.fullScroll(HorizontalScrollView.FOCUS_LEFT);
    }

    //Update screen by input.
    private void updateDisplay(String number){
        display.setText(display.getText().toString() + number);

        scr.postDelayed(new Runnable(){
            public void run(){
                scr.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
            }
        }, 30L);
    }

    //Hint text setup.
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String s = ip.getSelectedItem().toString();
        if(!display.getText().toString().isEmpty())
            convert();

        display.setHint(ip.getSelectedItem().toString());
        upperDisplay.setHint(op.getSelectedItem().toString());
//        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}