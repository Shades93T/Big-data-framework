package com.opstty.mapper;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.DoubleWritable;

import java.io.IOException;

public class MaxHeightMapper extends Mapper<Object, Text, Text, DoubleWritable> {

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        String line[] = value.toString().split(";");
        if (!line[3].equals("ESPECE")) {
            Text species = new Text(line[3]);
            double h = Double.parseDouble(line[6]);
            DoubleWritable height = new DoubleWritable(h);
            context.write(species, height);
        }
    }
}