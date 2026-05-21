package br.ulbra.sportpass;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgOpcoe;

    Button btCalcular;

    CheckBox cbCorrendo;

    EditText edPassos;

    TextView txRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rgOpcoe = findViewById(R.id.rgOpcoes);
        cbCorrendo = findViewById(R.id.cbCorrendo);
        edPassos = findViewById(R.id.edtPassos);
        txRes = findViewById(R.id.txtRes);
        btCalcular = findViewById(R.id.btnCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularPassos();
            }
        });
    }

    public void calcularPassos() {
        if (edPassos.getText().toString().isEmpty()) {
            Toast.makeText(this, "Iforme uma quantidade de passos que nao seja nula", Toast.LENGTH_SHORT).show();
        }else if(Double.parseDouble(edPassos.getText().toString()) < 0){
            Toast.makeText(this, "Iforme uma quantidade de passos acima de -1", Toast.LENGTH_SHORT).show();
    }else {
            double passos = Double.parseDouble(edPassos.getText().toString());
            double multi = 0;
            String res;
            int op = rgOpcoe.getCheckedRadioButtonId();
            if (op == R.id.rb50) {
                multi = multi + 0.5;
            } else if (op == R.id.rb80) {
                multi = multi + 0.8;
            } else {
                multi = multi + 1.1;
            }
            if (cbCorrendo.isChecked()) {
                multi = multi + 0.1;
            }
            DecimalFormat df = new DecimalFormat("0.00");
            double percorrido = passos * multi;
            double metros = percorrido / 100;
            res = "A quantidade em metros percorrida foi de : " + df.format(metros);
            txRes.setText(res);
        }
    }
}
