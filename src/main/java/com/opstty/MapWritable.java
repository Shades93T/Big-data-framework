package com.opstty;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

public class MapWritable implements Writable {
    private IntWritable val;
    private IntWritable val2;

    public MapWritable() {
        this.val = new IntWritable(-1);
        this.val2 = new IntWritable(Integer.MAX_VALUE);
    }
    public MapWritable(IntWritable val1, IntWritable val2) {
        this.val = val1;
        this.val2 = val2;
    }
    
    //GETTER AND SETTER
    
    public IntWritable getVal() {
    	return this.val;    
    }
    public void setVal(IntWritable val) {       
    	this.val = val;   
    }    
    public IntWritable getVal2() {        
    	return this.val2;    
    }
    public void setVal2(IntWritable val2) {       
    	this.val2 = val2;    
    }
    
    @Override
    public void readFields(DataInput in) throws IOException {
        val.readFields(in);
        val2.readFields(in);
    }
    @Override
    public void write(DataOutput out) throws IOException {
        val.write(out);
        val2.write(out);
    }
    @Override
    public String toString() {
        return val.toString() + ";" + val2.toString();
    }
}