package com.example.appp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText txt1,txt2;
    Button btn1,btn2;
    String s1,s2;

    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=(EditText) findViewById(R.id.tx1);
        txt2=(EditText) findViewById(R.id.tx2);
        btn1=(Button) findViewById(R.id.button);
        btn2=(Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=txt1.getText().toString();
                s2=txt2.getText().toString();
                int k=s1.compareTo(s2);
                if(k==0)
                    Toast.makeText(MainActivity.this, "Both Fields Are Empty", Toast.LENGTH_SHORT).show();
                else if(k>0)
                {
                    boolean cond=false;
                    for(int i=0;i<s1.length();i++)
                        if((s1.charAt(i)>=48 && s1.charAt(i)<=57) || (s1.charAt(i)>=97 && s1.charAt(i)<=122))
                            cond=true;
                    if(!cond)
                    {
                        int sum=0;
                        for(int i=0;i<s1.length();i++)
                        {
                            int k1=value(s1.charAt(i));
                            if(i+1<s1.length())
                            {
                                int k2=value(s1.charAt(i+1));
                                if(k1>=k2)
                                {
                                    sum+=k1;
                                }
                                else
                                {
                                    sum+=(k2-k1);
                                    i++;
                                }
                            }
                            else
                            {
                                sum+=k1;
                            }
                        }
                        String s=Integer.toString(sum);
                        txt2.setText(s);
                        Toast.makeText(MainActivity.this, "Converted from Roman to Integer", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Wrong Data Entered", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(k<0)
                {
                    boolean cond=false;
                    for(int i=0;i<s2.length();i++)
                        if(!(s2.charAt(i)>=48 && s2.charAt(i)<=57))
                            cond=true;
                    if(!cond)
                    {
                        char[] arr;
                        arr=new char[13];
                        String romans[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
                        int value[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
                        int num=Integer.parseInt(s2);
                        int seqSize = romans.length;
                        int idx = seqSize - 1;
                        String ans = "";
                        while(num>0) {
                            while (value[idx] <= num) {
                                ans += romans[idx];
                                num -= value[idx];
                            }
                            idx--;
                        }
                        txt1.setText(ans);
                        Toast.makeText(MainActivity.this, "Converted from Integer to Roman", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Wrong Data Entered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText("");
                txt2.setText("");
            }
        });
        }
}