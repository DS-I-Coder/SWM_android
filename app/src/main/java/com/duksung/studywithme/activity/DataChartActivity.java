package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.duksung.studywithme.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.Arrays;

public class DataChartActivity extends AppCompatActivity {

    PieChart pieChart;
    private ArrayList<String> dataList
            = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_chart);

        int[] colorArray = new int[] {getResources().getColor(R.color.chart1),
                getResources().getColor(R.color.chart2),
                getResources().getColor(R.color.chart3),
                getResources().getColor(R.color.chart4)};


        pieChart = findViewById(R.id.chart_cct);
        pieChart.getDescription().setEnabled(false);
        pieChart.getDescription().setText("");
        pieChart.setEntryLabelTextSize(13f);
        pieChart.setUsePercentValues(true);
        pieChart.getLegend().setEnabled(false);
        pieChart.animateY(1000, Easing.EaseInOutCubic);

        PieDataSet dataSet = new PieDataSet(getData(dataList),"");
        dataSet.setColors(colorArray);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(15f);
        data.setValueFormatter(new PercentFormatter(pieChart));
        pieChart.setData(data);
    }

    private ArrayList<PieEntry> getData(ArrayList name) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        System.out.println(name);
        entries.add(new PieEntry(50, "10시간 이상"));
        entries.add(new PieEntry(20, "7시간 이상"));
        entries.add(new PieEntry(20, "4시간 이상"));
        entries.add(new PieEntry(10, "4시간 미만"));
        return entries;
    }
}