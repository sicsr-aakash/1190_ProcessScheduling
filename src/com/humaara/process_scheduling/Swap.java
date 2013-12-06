package com.humaara.process_scheduling;

public class Swap {

float temp;
    
    Swap()
    {
        System.out.println("Initializing...");
    }
    public void swapper(float[] burst_time,int index1,int index2)
    {
        temp = burst_time[index1];
        burst_time[index1] = burst_time[index2];
        burst_time[index2] = temp;
    }
    
    String string_temp="";
    
    public void swapper_string(String[] array,int index1,int index2)
    {
        string_temp = array[index1];
        array[index1] = array[index2];
        array[index2] = string_temp;
    }
}
