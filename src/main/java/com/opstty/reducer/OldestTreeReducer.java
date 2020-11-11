package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import com.opstty.MapWritable;

public class OldestTreeReducer extends Reducer<LongWritable, MapWritable, NullWritable, MapWritable> {

    public void reduce(LongWritable key, Iterable<MapWritable> values, Context context)
            throws IOException, InterruptedException {

        MapWritable MapValue = new MapWritable();

        for (MapWritable value : values) {

            if (value.getVal2().get() < MapValue.getVal2().get()) {

            	MapValue.setVal(new IntWritable(value.getVal().get()));              
            	MapValue.setVal2(new IntWritable(value.getVal2().get()));               
            }
        }
        context.write(NullWritable.get(), MapValue);
     }
}