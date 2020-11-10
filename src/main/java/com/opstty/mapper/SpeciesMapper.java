package com.opstty.mapper;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.NullWritable;

import java.io.IOException;

public class SpeciesMapper extends Mapper<Object, Text, Text, NullWritable> {

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        if(!line.contains("ESPECE")){
            Text species = new Text(line.split(";")[3]); //4th column "ESPECE" to write down the species
            context.write(species, NullWritable.get());
        }
    }
}