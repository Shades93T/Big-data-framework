package com.opstty.reducer;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class SortTreeReducer extends Reducer<DoubleWritable, Iterable<DoubleWritable>, DoubleWritable, NullWritable> {

	public void reduce(Iterable<DoubleWritable> key, NullWritable values, Context context)
            throws IOException, InterruptedException {
    	
    	ArrayList<DoubleWritable> trees = new ArrayList<DoubleWritable>(); 
    	DoubleWritable height = new DoubleWritable();
        for (DoubleWritable val : key) {
            String line[] = val.toString().split(";");
           	height.set(Double.parseDouble(line[0]));
            trees.add(height);
        }

        Collections.sort(trees);
        for (DoubleWritable t : trees) {
            context.write(t, NullWritable.get());
        }
    }
}