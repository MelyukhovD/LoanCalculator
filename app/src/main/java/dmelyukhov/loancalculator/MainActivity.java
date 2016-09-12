package dmelyukhov.loancalculator;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private EditText loanAmountEdit;
    private EditText numberOfYearsEdit;
    private EditText yearlyInterestRateEdit;
    private TextView monthlyOut;
    private TextView totalOut;
    private TextView interestOut;

    private double loan;
    private int years;
    private double interest;


    public void onCalculate(View view) {

        loanAmountEdit = (EditText) findViewById(R.id.amount);
        numberOfYearsEdit = (EditText) findViewById(R.id.duration);
        yearlyInterestRateEdit = (EditText) findViewById(R.id.interest);

        loan = Double.parseDouble(loanAmountEdit.getText().toString());
        years = Integer.parseInt(numberOfYearsEdit.getText().toString());
        interest = Double.parseDouble(yearlyInterestRateEdit.getText().toString());

        LoanCalculator calc = new LoanCalculator(loan, years, interest);

        monthlyOut = (TextView) findViewById(R.id.monthlyPay);
        totalOut = (TextView) findViewById(R.id.totalPay);
        interestOut = (TextView) findViewById(R.id.totalInterest);

        monthlyOut.setText(calc.getMonthlyPayment()+"");
        totalOut.setText(calc.getTotalCostOfLoan()+"");
        interestOut.setText(calc.getTotalInterest()+"");

    }

    public void onClear(View view){

        loanAmountEdit = (EditText) findViewById(R.id.amount);
        numberOfYearsEdit = (EditText) findViewById(R.id.duration);
        yearlyInterestRateEdit = (EditText) findViewById(R.id.interest);

        loanAmountEdit.setText("");
        numberOfYearsEdit.setText("");
        yearlyInterestRateEdit.setText("");

        monthlyOut = (TextView) findViewById(R.id.monthlyPay);
        totalOut = (TextView) findViewById(R.id.totalPay);
        interestOut = (TextView) findViewById(R.id.totalInterest);

        monthlyOut.setText("");
        totalOut.setText("");
        interestOut.setText("");
    }

}
