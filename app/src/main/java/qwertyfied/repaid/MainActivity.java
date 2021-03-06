package qwertyfied.repaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText upi_id, amountField;
    Button pay_button;
    TextView charges, sumAmountField;

    float amount;
    String vpa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upi_id = findViewById(R.id.vpa_field);
        amountField = findViewById(R.id.amount_field);

        pay_button = findViewById(R.id.button_submit);

        charges = findViewById(R.id.charges);
        sumAmountField = findViewById(R.id.effective_amount);

        vpa = upi_id.getText().toString();


        amountField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (amountField.getText().toString().equals("")) {
                    amountField.setText("0");
                }
                amount = Float.valueOf(amountField.getText().toString());
                sumAmountField.setText("₹ " + amount * 0.02);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
