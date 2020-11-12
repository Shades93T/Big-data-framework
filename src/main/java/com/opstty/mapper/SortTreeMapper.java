package com.opstty.mapper;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;

import java.io.IOException;

public class SortTreeMapper extends Mapper<Object, Text, DoubleWritable, NullWritable> {

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        String line[] = value.toString().split(";");
        if (!line[6].equals("HAUTEUR")) {
            DoubleWritable height = new DoubleWritable();
            String h = line[6];
            height.set(Double.parseDouble(h));
            context.write(height, NullWritable.get());
        }
    }
}