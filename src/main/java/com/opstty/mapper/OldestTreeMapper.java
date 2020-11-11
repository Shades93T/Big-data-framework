package com.opstty.mapper;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;

import java.io.IOException;

import com.opstty.MapWritable;

public class OldestTreeMapper extends Mapper<Object, Text, LongWritable, MapWritable> {

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
    	LongWritable k = new LongWritable(1);
        String line[] = value.toString().split(";");
        if (!line[1].equals("ARRONDISSEMENT")) {
            try {
            	
                IntWritable arrondissement = new IntWritable(Integer.parseInt(line[1]));
                IntWritable age = new IntWritable(Integer.parseInt(line[5]));
                MapWritable MapValue = new MapWritable(arrondissement, age);
                context.write(k, MapValue);
                
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}