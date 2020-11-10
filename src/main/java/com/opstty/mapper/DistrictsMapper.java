package com.opstty.mapper;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.NullWritable;

import java.io.IOException;

public class DistrictsMapper extends Mapper<Object, Text, Text, NullWritable> {

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        if(!line.contains("ARRONDISSEMENT")){
            Text district = new Text(line.split(";")[1]);//2nd column "ARRONDISSEMENT" to write down the districts
            context.write(district, NullWritable.get());
        }
    }
}