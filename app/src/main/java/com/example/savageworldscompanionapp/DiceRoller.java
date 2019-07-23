package com.example.savageworldscompanionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class DiceRoller extends AppCompatActivity {
    // UI Objects
    private Switch explodeDiceSwitch;
    private Switch wildDieSwitch;
    private EditText modifierTextBox;
    private TextView calculationView;
    private TextView resultView;
    private Button increaseD4Button;
    private Button increaseD6Button;
    private Button increaseD8Button;
    private Button increaseD10Button;
    private Button increaseD12Button;
    private Button decreaseD4Button;
    private Button decreaseD6Button;
    private Button decreaseD8Button;
    private Button decreaseD10Button;
    private Button decreaseD12Button;
    private TextView d4CountView;
    private TextView d6CountView;
    private TextView d8CountView;
    private TextView d10CountView;
    private TextView d12CountView;
    private Button rollAllButton;
    private Button rollD20Button;
    private Button rollD100Button;
    private Button clearButton;
    private Button rerollButton;

    // Additional Values
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);

        // Bind UI Objects
        rand = new Random();
        bindUIObjects();
        clearInput();
        setListeners();
    }

    private void bindUIObjects(){
        explodeDiceSwitch = findViewById(R.id.diceRollerExplodeSwitch);
        wildDieSwitch = findViewById(R.id.diceRollerWildDieSwitch);
        modifierTextBox = findViewById(R.id.diceRollerModifierInputBox);
        calculationView = findViewById(R.id.calculationTextView);
        resultView = findViewById(R.id.resultTextView);
        increaseD4Button = findViewById(R.id.diceRollerIncrementD4);
        increaseD6Button = findViewById(R.id.diceRollerIncrementD6);
        increaseD8Button = findViewById(R.id.diceRollerIncrementD8);
        increaseD10Button = findViewById(R.id.diceRollerIncrementD10);
        increaseD12Button = findViewById(R.id.diceRollerIncrementD12);
        decreaseD4Button = findViewById(R.id.diceRollerDecrementD4);
        decreaseD6Button = findViewById(R.id.diceRollerDecrementD6);
        decreaseD8Button = findViewById(R.id.diceRollerDecrementD8);
        decreaseD10Button = findViewById(R.id.diceRollerDecrementD10);
        decreaseD12Button = findViewById(R.id.diceRollerDecrementD12);
        d4CountView = findViewById(R.id.diceRollerD4CountView);
        d6CountView = findViewById(R.id.diceRollerD6CountView);
        d8CountView = findViewById(R.id.diceRollerD8CountView);
        d10CountView = findViewById(R.id.diceRollerD10CountView);
        d12CountView = findViewById(R.id.diceRollerD12CountView);
        rollAllButton = findViewById(R.id.rollAllButton);
        rollD20Button = findViewById(R.id.rollD20Button);
        rollD100Button = findViewById(R.id.rollD100Button);
        clearButton = findViewById(R.id.diceRollerClearButton);
        rerollButton = findViewById(R.id.diceRollerRerollButton);
    }

    private void setListeners(){
        increaseD4Button.setOnClickListener(new diceClickListener(true, d4CountView));
        increaseD6Button.setOnClickListener(new diceClickListener(true, d6CountView));
        increaseD8Button.setOnClickListener(new diceClickListener(true, d8CountView));
        increaseD10Button.setOnClickListener(new diceClickListener(true, d10CountView));
        increaseD12Button.setOnClickListener(new diceClickListener(true, d12CountView));
        decreaseD4Button.setOnClickListener(new diceClickListener(false, d4CountView));
        decreaseD6Button.setOnClickListener(new diceClickListener(false, d6CountView));
        decreaseD8Button.setOnClickListener(new diceClickListener(false, d8CountView));
        decreaseD10Button.setOnClickListener(new diceClickListener(false, d10CountView));
        decreaseD12Button.setOnClickListener(new diceClickListener(false, d12CountView));
        rollAllButton.setOnClickListener(new rollDiceListener());
        rollD20Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice(20);
            }
        });
        rollD100Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice(100);
            }
        });
        rerollButton.setOnClickListener(new rollDiceListener());
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInput();
            }
        });
    }

    /*
    upOrDown: True for incrementing count, False for decrementing dice count
    countView: TextView to be changed after count is changed
    diceCount: int to be changed
    */
    private class diceClickListener implements View.OnClickListener{
        boolean upOrDown;
        TextView diceCountView;
        int diceCount;
        private diceClickListener(final boolean upDown, final TextView tv){
            upOrDown = upDown;
            diceCountView = tv;
        }

        @Override
        public void onClick(View view){
            diceCount = Integer.parseInt(diceCountView.getText().toString());
            if (upOrDown)
                // If upOrDown is true, increment value
                ++diceCount;
            else if (diceCount > 0)
                // Else if diceCount > 0, decrement
                --diceCount;

            // Update countView
            diceCountView.setText(String.format("%d", diceCount));
        }
    }

    /*
    private View.OnClickListener alterDiceCount = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            if (upOrDown)
                // If upOrDown is true, increment value
                ++diceCount;
            else if (diceCount > 0)
                // Else if diceCount > 0, decrement
                --diceCount;
            else
                // Else return to prevent subtracting from 0
                return null;

            // Update countView
            countView.setText(String.format("%d", diceCount));
        }
    }
    */

    // For rolling all currently selected dice
    private class rollDiceListener implements View.OnClickListener {
        public void rollDiceListener(){}

        @Override
        public void onClick(View view) {
            boolean exploding = explodeDiceSwitch.isChecked();

            int d4Count = Integer.parseInt(d4CountView.getText().toString());
            int d6Count = Integer.parseInt(d6CountView.getText().toString());
            int d8Count = Integer.parseInt(d8CountView.getText().toString());
            int d10Count = Integer.parseInt(d10CountView.getText().toString());
            int d12Count = Integer.parseInt(d12CountView.getText().toString());
            int result = 0;
            int temp;

            // Roll all D4s
            for (int i = 0; i < d4Count; ++i)
                result += rollSingleDie(4, exploding);

            // Roll all D6s
            for (int i = 0; i < d6Count; ++i)
                result += rollSingleDie(6, exploding);

            // Roll all D8s
            for (int i = 0; i < d8Count; ++i)
                result += rollSingleDie(8, exploding);

            // Roll all D10s
            for (int i = 0; i < d10Count; ++i)
                result += rollSingleDie(10, exploding);

            // Roll all D12s
            for (int i = 0; i < d12Count; ++i)
                result += rollSingleDie(12, exploding);

            // Handle wild die
            if (wildDieSwitch.isChecked()) {
                temp = rollSingleDie(6, exploding);
                if (temp > result)
                    result = temp;
            }

            // Set textbox to result + modifier
            resultView.setText(String.format("%d", (result + Integer.parseInt(modifierTextBox.getText().toString()))));
        }
    }

    // Overload for only rolling a D20 or D100
    private View.OnClickListener rollDice(final int max){
        resultView.setText(String.format("%d", rand.nextInt(max) + 1 ));
        return null;
    }

    // Function to simulate single die roll
    private int rollSingleDie(final int dieType, final boolean exploding){
        int result = 0;
        int temp;

        do{ // Generate random value from 1 to dieType and add to result
            temp = rand.nextInt(dieType) + 1;
            result += temp;
            // Repeat when necessary
        }while(temp == dieType && explodeDiceSwitch.isChecked());

        return result;
    }

    protected void clearInput(){
        explodeDiceSwitch.setChecked(true);
        wildDieSwitch.setChecked(true);
        modifierTextBox.setText("0");
        calculationView.setText("");
        resultView.setText("");
        d4CountView.setText("0");
        d6CountView.setText("0");
        d8CountView.setText("0");
        d10CountView.setText("0");
        d12CountView.setText("0");
    }
}
