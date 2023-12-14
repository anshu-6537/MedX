package com.example.medx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Self_test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self_test)


        val back=findViewById<ImageButton>(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this,home_page1::class.java)
            startActivity(intent)
        }

        val symptom = arrayOf("Headache","Fever","Nausea","Stomach ache","Cough","None","Nasal congestion","stuffy nose","Nosebleed","Dizziness"
        ,"Breathlessness","Chest pain","Vomitting","Skin rash","Itching","Diarrhoea")

        val spinnerSymp1=findViewById<Spinner>(R.id.spin1)
        val spinnerSymp2=findViewById<Spinner>(R.id.spin2)
        val spinnerSymp3=findViewById<Spinner>(R.id.spin3)
        val spinnerSymp4=findViewById<Spinner>(R.id.spin4)
        var symp1=""
        var symp2=""
        var symp3=""
        var symp4=""
        var disease=""

        val arrayAdapSymp1 =ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, symptom)
        val arrayAdapSymp2 =ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, symptom)
        val arrayAdapSymp3 =ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, symptom)
        val arrayAdapSymp4 =ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, symptom)
        spinnerSymp1.adapter= arrayAdapSymp1
        spinnerSymp2.adapter= arrayAdapSymp2
        spinnerSymp3.adapter= arrayAdapSymp3
        spinnerSymp4.adapter= arrayAdapSymp4

        spinnerSymp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                symp1 = symptom[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        spinnerSymp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                symp2 = symptom[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        spinnerSymp3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                symp3 = symptom[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        spinnerSymp4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                symp4 = symptom[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        //        Migraine: Headache, nausea.
//        Influenza (Flu): Fever, headache, cough, and sometimes nausea.
//        Gastroenteritis: Nausea, stomach ache.
//        COVID-19: Fever, cough, headache, and sometimes stomach ache.
//        Appendicitis: Fever, stomach ache, nausea.
//        Tension Headache: Headache, stomach ache.

        val predict=findViewById<Button>(R.id.predict)
        predict.setOnClickListener {
//            if(symp1=="Headache" && symp2=="Nausea" && symp3=="None" && symp4=="None")
//            {
//                disease="Migraine"
//            }
//            else if (symp1=="Fever" && symp2=="Headache" && symp3=="Cough" && symp4=="Nausea")
//            {
//                disease="Influenza"
//            }
//            else if (symp1=="Nausea" && symp2=="Stomach ache" && symp3=="None" && symp4=="None")
//            {
//                disease="Gastroentritis"
//            }
//            else if (symp1=="Fever" && symp2=="Cough" && symp3=="Headache" && symp4=="Stomach ache")
//            {
//                disease="Covid-19"
//            }
//            else if (symp1=="Fever" && symp2=="Stomach ache" && symp3=="Nausea" && symp4=="None")
//            {
//                disease="Appendicitis"
//            }
//            else {
//                disease="Nothing will happen to you!!!"
//            }
            if(symp1=="Headache" && symp2=="Nausea" && symp3=="None" && symp4=="None")
            {
                disease="Migraine"
            }
            else if (symp1=="Fever" && symp2=="Headache" && symp3=="Cough" && symp4=="Nausea")
            {
                disease="Influenza"
            }
            else if (symp1=="Nausea" && symp2=="Stomach ache" && symp3=="None" && symp4=="None")
            {
                disease="Gastroentritis"
            }
            else if (symp1=="Fever" && symp2=="Cough" && symp3=="Headache" && symp4=="Stomach ache")
            {
                disease="Covid-19"
            }
            else if (symp1=="Fever" && symp2=="Stomach ache" && symp3=="Nausea" && symp4=="None")
            {
                disease="Appendicitis"
            }
            else if (symp1=="Nasal congestion" && symp2=="stuffy nose" && symp3=="Coughing" && symp4=="Headache")
            {
                disease="Sinusitis"
            }
            else if (symp1=="Headache" && symp2=="Nosebleed" && symp3=="Dizziness" && symp4=="Chest pain")
            {
                disease="Hypertension"
            }
            else if (symp1=="Wheezing" && symp2=="Coughing" && symp3=="Breathlessness" && symp4=="Fatigue")
            {
                disease="Asthma"
            }
            else if (symp1=="Joint pain" && symp2=="Chills" && symp3=="vomiting" && symp4=="Fever")
            {
                disease="Dengue"
            }
            else if (symp1=="Skin rash" && symp2=="Fever" && symp3=="Itching" && symp4=="Loss of appetite")
            {
                disease="Chicken pox"
            }
            else if (symp1=="Fever" && symp2=="Diarrhoea" && symp3=="Nausea" && symp4=="Vomiting")
            {
                disease="Malaria"
            }
            else if (symp1=="Fever" && symp2=="Diarrhoea" && symp3=="Constipation" && symp4=="Abdominal pain")
            {
                disease="Typhoid"
            }
            else if (symp1=="Vomiting" && symp2=="Diarrhoea" && symp3=="Yellowing of eyes" && symp4=="Dark urine")
            {
                disease="Hepatitis A"
            }
            else {
                disease="Prioritizing health through balanced nutrition, regular exercise, and self-care cultivates a foundation for lifelong well-being."
            }

            Toast.makeText(this,disease,Toast.LENGTH_SHORT).show()
            val intent = Intent(this, disease_predicted::class.java)
            intent.putExtra("predict", disease)
            startActivity(intent)
        }
    }
}