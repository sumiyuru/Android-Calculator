package com.example.cicra.cal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdel,bequal,bplus,bminus,bbracket,bclear,bmulti,bdividion,bpercent,bdot;
    TextView tvInput,tvOutput;
    String process;
    boolean checkBraket =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0=findViewById(R.id.zero);
        b1=findViewById(R.id.one);
        b2=findViewById(R.id.two);
        b3=findViewById(R.id.three);
        b4=findViewById(R.id.four);
        b5=findViewById(R.id.five);
        b6=findViewById(R.id.six);
        b7=findViewById(R.id.seven);
        b8=findViewById(R.id.eight);
        b9=findViewById(R.id.nine);

        bclear=findViewById(R.id.clear);
        bdel=findViewById(R.id.delete);

        bdot=findViewById(R.id.dot);
        bbracket=findViewById(R.id.bracket);
        bpercent=findViewById(R.id.percent);
        bequal=findViewById(R.id.equal);

        bplus=findViewById(R.id.plus);
        bminus=findViewById(R.id.minus);
        bmulti=findViewById(R.id.multiplication);
        bdividion=findViewById(R.id.division);

        tvInput=findViewById(R.id.tvInput);
        tvOutput=findViewById(R.id.tvOutput);



        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"0");

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"1");

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"2");

            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"3");

            }
        });



        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"4");

            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"5");

            }
        });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"6");

            }
        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"7");

            }
        });


        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"8");

            }
        });


        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"9");

            }
        });

        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+".");

            }
        });



        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"+");

            }
        });


        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"-");

            }
        });


        bmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"×");

            }
        });


        bdividion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"÷");

            }
        });


        bpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"%");

            }
        });

        bbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBraket){
                    process=tvInput.getText().toString();
                    tvInput.setText(process+")");
                    checkBraket=false;
                }else {
                    process=tvInput.getText().toString();
                    tvInput.setText(process+"(");
                    checkBraket=true;
                }

            }
        });


        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                process= process.replaceAll("×","*");
                process= process.replaceAll("%","/100");
                process= process.replaceAll("÷","/");

                org.mozilla.javascript.Context rhino = org.mozilla.javascript.Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult="";

                try {
                    Scriptable scriptable= rhino.initStandardObjects();
                    finalResult =rhino.evaluateString(scriptable,process,"javascript",1,null).toString();

                }catch (Exception e){
                    finalResult="0";
                }
                tvOutput.setText(finalResult);
            }
        });



    }
}
