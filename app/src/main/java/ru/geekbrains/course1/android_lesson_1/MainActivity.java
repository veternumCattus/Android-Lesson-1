package ru.geekbrains.course1.android_lesson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumberEditText;
    private EditText secondNumberEditText;
    private Button actionButton;
    private TextView resultTextView;

    //private ResultClickListener resultClickListener = new ResultClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //actionButton.setOnClickListener(resultClickListener);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "тост" - дает выпадающую надпись-справку
                Toast.makeText(MainActivity.this, "button is pressed", Toast.LENGTH_SHORT).show();
                resultTextView.setText(getSumFromView());
            }
        });
    }

    // Метод производит преобразование строк из вьюшек в числа, их сууммирование и проеобразование суммы к строке
    private String getSumFromView() {
        String firstNumberStr = firstNumberEditText.getText().toString();
        String secondNumberStr = secondNumberEditText.getText().toString();

        String result;
        try {

            int firstNumber = Integer.parseInt(firstNumberStr);
            int secondNumber = Integer.parseInt(secondNumberStr);
            int sum = firstNumber + secondNumber;
            result = String.valueOf(sum);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            result = "Err";
        }

        return result;

    }

    // Метод устанавливант значения для вьюшек по их id
    private void initView() {
        firstNumberEditText = (EditText) findViewById(R.id.first_input_edit_text);
        secondNumberEditText = findViewById(R.id.second_input_edit_text);
        actionButton = findViewById(R.id.action_button);
        resultTextView = findViewById(R.id.result_text_view);
    }

    /*
    private class ResultClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "button is pressed", Toast.LENGTH_SHORT).show();
            resultTextView.setText(firstNumberEditText.getText().toString()+secondNumberEditText.getText().toString());
        }
     */

}