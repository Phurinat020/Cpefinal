package com.example.cpe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChemistryCalcutorActivity extends AppCompatActivity {

    private EditText editTextFormula;
    private Button buttonCalculate;
    private TextView textViewResult;
    Button backToVichaKme;



    private static final Map<String, Double> ATOMIC_WEIGHTS = new HashMap<>();

    static {
        // เพิ่มมวลอะตอมของธาตุที่พบบ่อย
        ATOMIC_WEIGHTS.put("H", 1.008);   // ไฮโดรเจน
        ATOMIC_WEIGHTS.put("C", 12.011);  // คาร์บอน
        ATOMIC_WEIGHTS.put("N", 14.007);  // ไนโตรเจน
        ATOMIC_WEIGHTS.put("O", 15.999);  // ออกซิเจน
        ATOMIC_WEIGHTS.put("Na", 22.990); // โซเดียม
        ATOMIC_WEIGHTS.put("Mg", 24.305); // แมกนีเซียม
        ATOMIC_WEIGHTS.put("P", 30.974);   // ฟอสฟอรัส
        ATOMIC_WEIGHTS.put("S", 32.06);   // กำมะถัน
        ATOMIC_WEIGHTS.put("Cl", 35.45);  // คลอรีน
        ATOMIC_WEIGHTS.put("K", 39.098);   // โพแทสเซียม
        ATOMIC_WEIGHTS.put("Ca", 40.078); // แคลเซียม
        ATOMIC_WEIGHTS.put("Fe", 55.845); // ไซเทียม
        ATOMIC_WEIGHTS.put("Al", 26.982); // อลูมิน
        ATOMIC_WEIGHTS.put("Cu", 63.546); //
        ATOMIC_WEIGHTS.put("Zn", 65.38);  //
        ATOMIC_WEIGHTS.put("Mn", 54.938); //
        ATOMIC_WEIGHTS.put("Ni", 58.693); //
        ATOMIC_WEIGHTS.put("Co", 58.933); //
        ATOMIC_WEIGHTS.put("Cr", 51.996); //
        ATOMIC_WEIGHTS.put("Ti", 47.867); //
        ATOMIC_WEIGHTS.put("Mo", 95.94);  //
        ATOMIC_WEIGHTS.put("Nb", 92.906); //
        ATOMIC_WEIGHTS.put("Ru", 101.07); //
        ATOMIC_WEIGHTS.put("Pd", 106.42); //
        ATOMIC_WEIGHTS.put("Rh", 102.905); //
        ATOMIC_WEIGHTS.put("Ag", 107.868); //
        ATOMIC_WEIGHTS.put("Cd", 112.411); //
        ATOMIC_WEIGHTS.put("Ba", 137.327); //
        ATOMIC_WEIGHTS.put("La", 138.905); //
        ATOMIC_WEIGHTS.put("Ce", 140.116); //
        ATOMIC_WEIGHTS.put("Pr", 140.908); //
        ATOMIC_WEIGHTS.put("Nd", 144.242); //
        ATOMIC_WEIGHTS.put("Sm", 150.36); //
        ATOMIC_WEIGHTS.put("Eu", 151.964); //
        ATOMIC_WEIGHTS.put("Gd", 157.25); //
        ATOMIC_WEIGHTS.put("Tb", 158.925); //
        ATOMIC_WEIGHTS.put("Dy", 162.5); //
        ATOMIC_WEIGHTS.put("Ho", 164.93); //
        ATOMIC_WEIGHTS.put("Er", 167.259); //
        ATOMIC_WEIGHTS.put("Tm", 168.934); //
        ATOMIC_WEIGHTS.put("Yb", 173.045); //
        ATOMIC_WEIGHTS.put("Lu", 174.967); //
        ATOMIC_WEIGHTS.put("Hf", 178.49); //
        ATOMIC_WEIGHTS.put("Ta", 180.947); //
        ATOMIC_WEIGHTS.put("W", 183.84); //
        ATOMIC_WEIGHTS.put("Re", 186.207); //
        ATOMIC_WEIGHTS.put("Os", 190.23); //
        ATOMIC_WEIGHTS.put("Ir", 192.217); //
        ATOMIC_WEIGHTS.put("Pt", 195.084); //
        ATOMIC_WEIGHTS.put("Au", 196.966); //
        ATOMIC_WEIGHTS.put("Hg", 200.59); //
        ATOMIC_WEIGHTS.put("Tl", 204.383); //
        ATOMIC_WEIGHTS.put("Pb", 207.2); //
        ATOMIC_WEIGHTS.put("Bi", 208.980); //
        ATOMIC_WEIGHTS.put("Po", 209.0); //
        ATOMIC_WEIGHTS.put("At", 210.0); //
        ATOMIC_WEIGHTS.put("Rn", 222.0); //
        ATOMIC_WEIGHTS.put("Fr", 223.0); //
        ATOMIC_WEIGHTS.put("Ra", 226.0); //
        ATOMIC_WEIGHTS.put("Ac", 227.0); //
        ATOMIC_WEIGHTS.put("Th", 232.038); //
        ATOMIC_WEIGHTS.put("Pa", 231.036); //
        ATOMIC_WEIGHTS.put("U", 238.029); //
        ATOMIC_WEIGHTS.put("Np", 237.0); //
        ATOMIC_WEIGHTS.put("Pu", 244.0); //
        ATOMIC_WEIGHTS.put("Am", 243.0); //
        ATOMIC_WEIGHTS.put("Cm", 247.0); //
        ATOMIC_WEIGHTS.put("Bk", 247.0); //
        ATOMIC_WEIGHTS.put("Cf", 251.0); //
        ATOMIC_WEIGHTS.put("Es", 252.0); //
        ATOMIC_WEIGHTS.put("Fm", 257.0); //
        ATOMIC_WEIGHTS.put("Md", 258.0); //
        ATOMIC_WEIGHTS.put("No", 259.0); //
        ATOMIC_WEIGHTS.put("Lr", 262.0); //
        ATOMIC_WEIGHTS.put("Rf", 267.0); //
        ATOMIC_WEIGHTS.put("Db", 268.0); //
        ATOMIC_WEIGHTS.put("Sg", 271.0); //
        ATOMIC_WEIGHTS.put("Bh", 270.0); //
        ATOMIC_WEIGHTS.put("Hs", 269.0); //
        ATOMIC_WEIGHTS.put("Mt", 278.0); //
        ATOMIC_WEIGHTS.put("Ds", 281.0); //
        ATOMIC_WEIGHTS.put("Rg", 281.0); //
        ATOMIC_WEIGHTS.put("Cn", 285.0); //
        ATOMIC_WEIGHTS.put("Nh", 286.0); //
        ATOMIC_WEIGHTS.put("Fl", 289.0); //
        ATOMIC_WEIGHTS.put("Mc", 289.0); //
        ATOMIC_WEIGHTS.put("Lv", 293.0); //
        ATOMIC_WEIGHTS.put("Ts", 294.0); //
        ATOMIC_WEIGHTS.put("Og", 294.0); //

        // สามารถเพิ่มธาตุอื่นๆ ได้ตามต้องการ
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry_calcutor);

        editTextFormula = findViewById(R.id.edit_text_formula);
        buttonCalculate = findViewById(R.id.button_calculate);
        textViewResult = findViewById(R.id.text_view_result);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formula = editTextFormula.getText().toString().trim();
                if (formula.isEmpty()) {
                    Toast.makeText(ChemistryCalcutorActivity.this, "กรุณากรอกสูตรเคมี", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    double molecularWeight = calculateMolecularWeight(formula);
                    // แสดงผลลัพธ์โดยจัดรูปแบบทศนิยม 3 ตำแหน่ง
                    textViewResult.setText(String.format("%.3f", molecularWeight));
                } catch (IllegalArgumentException e) {
                    Toast.makeText(ChemistryCalcutorActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    textViewResult.setText("-");
                }
            }
        });
        backToVichaKme = findViewById(R.id.button15);
        backToVichaKme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Back");
                Intent vichachamicalActivity = new Intent(getApplicationContext(), ViChaChemicalActivity.class);
                startActivity(vichachamicalActivity);
            }
        });
    }
    private double calculateMolecularWeight(String formula) throws IllegalArgumentException {
        // ใช้ Regular Expression เพื่อแยกธาตุและจำนวนอะตอม
        // ([A-Z][a-z]?) คือ ธาตุ (เช่น H, O, Cl, Na)
        // (\d*) คือ จำนวนอะตอม (อาจจะมีหรือไม่มีก็ได้)
        Pattern pattern = Pattern.compile("([A-Z][a-z]?)(\\d*)");
        Matcher matcher = pattern.matcher(formula);

        double totalWeight = 0;
        int lastMatchEnd = 0;

        while (matcher.find()) {
            lastMatchEnd = matcher.end();
            String element = matcher.group(1);
            String countStr = matcher.group(2);

            if (!ATOMIC_WEIGHTS.containsKey(element)) {
                throw new IllegalArgumentException("ไม่พบธาตุ '" + element + "' ในระบบ");
            }

            double atomicWeight = ATOMIC_WEIGHTS.get(element);
            int count = countStr.isEmpty() ? 1 : Integer.parseInt(countStr);

            totalWeight += atomicWeight * count;
        }

        // ตรวจสอบว่าสูตรที่กรอกมาถูกต้องทั้งหมดหรือไม่
        if (lastMatchEnd != formula.length()) {
            throw new IllegalArgumentException("รูปแบบสูตรเคมีไม่ถูกต้อง");
        }

        return totalWeight;
    }

}