package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvMain, tvShow;
    Button btnAdd, btnSub, btnMul, btnDiv;
    Button btn7, btn8, btn9, btnClr;
    Button btn4, btn5, btn6, btnDel;
    Button btn1, btn2, btn3, btnNav;
    Button btnDec, btn0, btnEql;

    StringBuilder sb=new StringBuilder();
    double n;
    char ch='0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain=findViewById(R.id.tvMain);
        tvShow=findViewById(R.id.tvShow);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnMul=findViewById(R.id.btnMul);
        btnDiv=findViewById(R.id.btnDiv);

        btnClr=findViewById(R.id.btnC);
        btnDel=findViewById(R.id.btnDel);
        btnNav=findViewById(R.id.btnNav);
        btnDec=findViewById(R.id.btnDec);
        btnEql=findViewById(R.id.btnEql);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("0");
                tvMain.append("0");
                tvShow.append("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("1");
                tvMain.append("1");
                tvShow.append("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("2");
                tvMain.append("2");
                tvShow.append("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("3");
                tvMain.append("3");
                tvShow.append("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("4");
                tvMain.append("4");
                tvShow.append("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("5");
                tvMain.append("5");
                tvShow.append("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("6");
                tvMain.append("6");
                tvShow.append("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("7");
                tvMain.append("7");
                tvShow.append("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("8");
                tvMain.append("8");
                tvShow.append("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append("9");
                tvMain.append("9");
                tvShow.append("9");
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.append(".");
                tvMain.append(".");
                tvShow.append(".");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prevOp();
                ch='+';

                tvMain.append("+");
                tvShow.append("+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prevOp();
                ch='-';

                tvMain.append("-");
                tvShow.append("-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prevOp();
                ch='x';

                tvMain.append("x");
                tvShow.append("x");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prevOp();
                ch='/';

                tvMain.append("/");
                tvShow.append("/");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String t=tvMain.getText().toString();
                if(!t.equals("")) {

                    char a=t.charAt(t.length()-1);
                    if(a=='+' || a=='-' || a=='x' || a=='/'){
                        ch='0';
                    }
                    tvMain.setText(t.substring(0, t.length() - 1));
                }

                t=tvShow.getText().toString();
                if(!t.equals("")) {

                    tvShow.setText( t.substring(0,t.length()-1) );
                }

                t=sb.toString();
                if(!t.equals("")){
                    sb.setLength(0);
                    sb.append( t.substring(0,t.length()-1) );
                }
            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=0;
                ch='0';
                sb.setLength(0);
                tvMain.setText("");
                tvShow.setText("");
            }
        });

        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevOp();

                if( n==(int)n ){
                    tvMain.setText("" + (int)n );
                    tvShow.append("=" + (int)n );
                }
                else{
                    tvMain.setText( "" + n );
                    tvShow.append("=" + n );
                }
            }
        });
    }
    public void prevOp(){

        if(sb.length()==0){
            return;
        }
        if(ch=='0'){
            n=Double.parseDouble(sb.toString());
        }
        else if(ch=='+'){
            n=n+Double.parseDouble(sb.toString());
        }
        else if(ch=='-'){
            n=n-Double.parseDouble(sb.toString());
        }
        else if(ch=='x'){
            n=n*Double.parseDouble(sb.toString());
        }
        else if(ch=='/'){
            if(Double.parseDouble(sb.toString())==0){
                Toast.makeText(MainActivity.this, "Invalid Operation", Toast.LENGTH_SHORT).show();
            }
            else {
                n=n/Double.parseDouble(sb.toString());
            }
        }
        ch='0';
        sb.setLength(0);
    }
}
