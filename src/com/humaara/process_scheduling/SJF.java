package com.humaara.process_scheduling;

public class SJF {
	
	
	String[] p_name;
	float[] arrival_time,burst_time;
	
	SJF(String[] p_name,float[] arrival_time2,float[] burst_time2)
	{
		this.p_name = p_name;
		this.arrival_time = arrival_time2 ;
		this.burst_time = burst_time2;
	}
	
	Swap swap = new Swap();

	public void setSequence()
	{
		
		System.out.println(p_name[0]+" "+p_name[1]+" "+p_name[2]);
        System.out.println(arrival_time[0]+" "+arrival_time[1]+" "+arrival_time[2]);
        System.out.println(burst_time[0]+" "+burst_time[1]+" "+burst_time[2]);
        
        
        //case 1 if arrival times of process 0 and 2 are same
        if(arrival_time[0] == arrival_time[2])
        {
           
            if(burst_time[2]<burst_time[0])
            {
             
                swap.swapper(burst_time, 0, 2);
                swap.swapper_string(p_name, 0, 2);
            } 
            
            if(arrival_time[1]>arrival_time[2])
            {
                swap.swapper_string(p_name, 1, 2);
                swap.swapper(arrival_time, 1, 2);
                swap.swapper(burst_time, 1, 2);
            }
            
            if(arrival_time[1]<arrival_time[0])
            {
                swap.swapper_string(p_name, 1, 0);
                swap.swapper(arrival_time, 1, 0);
                swap.swapper(burst_time, 1, 0);
            }
        }
        
      //case 2 if arrival times of process 0 and 1 are same
        
        if(arrival_time[0] == arrival_time[1])
        {
            if(burst_time[1]<burst_time[0])
            {
                swap.swapper(burst_time, 0, 1);
                swap.swapper_string(p_name, 0, 1);
            } 
            
            if(arrival_time[2]<arrival_time[0] && arrival_time[2]<arrival_time[1])
            {
                swap.swapper_string(p_name, 1, 2);
                swap.swapper(arrival_time, 1, 2);
                swap.swapper(burst_time, 1, 2);
                
                swap.swapper_string(p_name, 0, 1);
                swap.swapper(arrival_time, 0, 1);
                swap.swapper(burst_time, 0, 1);
            }
            
           
        }
        
        //case3 if arrival times of process 1 and 2 are same
        
        if(arrival_time[1] == arrival_time[2])
        {
            
            if(burst_time[2]<burst_time[1])
            {
                 
                swap.swapper(burst_time, 1, 2);
                swap.swapper_string(p_name, 1, 2);
            } 
            
            if(arrival_time[0]>arrival_time[1] && arrival_time[0]>arrival_time[2])
            {
                swap.swapper_string(p_name, 0, 1);
                swap.swapper(arrival_time, 0, 1);
                swap.swapper(burst_time, 0, 1);
                
                swap.swapper_string(p_name, 1, 2);
                swap.swapper(arrival_time, 1, 2);
                swap.swapper(burst_time, 1, 2);
            }
        }
            
        //case 4 if all the arrival times are same
        if(arrival_time[0] == arrival_time[1] && arrival_time[1] == arrival_time[2])
        {
            //max
            if(burst_time[0]>burst_time[1] && burst_time[0]>burst_time[2])
            {
                swap.swapper_string(p_name, 0, 1);
                swap.swapper(arrival_time, 0, 1);
                swap.swapper(burst_time, 0, 1);
                
                swap.swapper_string(p_name, 1, 2);
                swap.swapper(arrival_time, 1, 2);
                swap.swapper(burst_time, 1, 2);
            } 
            
             if(burst_time[1]>burst_time[0] && burst_time[1]>burst_time[2])
            {
                swap.swapper_string(p_name, 1, 2);
                swap.swapper(arrival_time, 1, 2);
                swap.swapper(burst_time, 1, 2);
            }
             
             
             //min
             
              if(burst_time[1]<burst_time[0] && burst_time[1]<burst_time[2])
            {
                swap.swapper_string(p_name, 0, 1);
                swap.swapper(arrival_time, 0, 1);
                swap.swapper(burst_time, 0, 1);
              
            } 
            
             if(burst_time[2]<burst_time[1] && burst_time[2]>burst_time[0])
            {
                swap.swapper_string(p_name, 1, 2);
                swap.swapper(arrival_time, 1, 2);
                swap.swapper(burst_time, 1, 2);
                
                swap.swapper_string(p_name, 0, 1);
                swap.swapper(arrival_time, 0, 1);
                swap.swapper(burst_time, 0, 1);
                
                
            }
        }
        
        
        //case 5 if all the arrival times are different
        
        if(arrival_time[0] != arrival_time[1] && arrival_time[0] != arrival_time[2] && arrival_time[1] != arrival_time[2])
        {
             System.out.println("All different");
             
             if(arrival_time[0]>arrival_time[1] && arrival_time[0]>arrival_time[2])
            {
                swap.swapper_string(p_name, 0, 1);
                swap.swapper(arrival_time, 0, 1);
                swap.swapper(burst_time, 0, 1);
                
                swap.swapper_string(p_name, 1, 2);
                swap.swapper(arrival_time, 1, 2);
                swap.swapper(burst_time, 1, 2);
            } 
            
             if(arrival_time[1]>arrival_time[0] && arrival_time[1]>arrival_time[2])
            {
                swap.swapper_string(p_name, 1, 2);
                swap.swapper(arrival_time, 1, 2);
                swap.swapper(burst_time, 1, 2);
            }
             
             
             //min
             
              if(arrival_time[1]<arrival_time[0] && arrival_time[1]<arrival_time[2])
            {
                swap.swapper_string(p_name, 0, 1);
                swap.swapper(arrival_time, 0, 1);
                swap.swapper(burst_time, 0, 1);
              
            } 
            
             if(arrival_time[2]<arrival_time[1] && arrival_time[2]>arrival_time[0])
            {
                swap.swapper_string(p_name, 1, 2);
                swap.swapper(arrival_time, 1, 2);
                swap.swapper(burst_time, 1, 2);
                
                swap.swapper_string(p_name, 0, 1);
                swap.swapper(arrival_time, 0, 1);
                swap.swapper(burst_time, 0, 1);
         
            }
        }
	}
	
	public String[] getProcessSeq()
	{
		return p_name;
	}
	
	public float[] getArrivalSeq()
	{
		return arrival_time;
	}
	
	
	public float[] getBurstSeq()
	{
		return burst_time;
	}
}
        
