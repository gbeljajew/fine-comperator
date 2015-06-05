/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin.comperator;

import java.util.Map;

/**
 * 
 * @author gbeljajew
 */
public class FineComperator 
{
    public static int fineCompare(FineComperable fc1, FineComperable fc2)
    {
        int sum = 0;
        int num = 0;
        
        Map<String, FineComperablePart> fc1m = fc1.getComperableParts();
        Map<String, FineComperablePart> fc2m = fc2.getComperableParts();
        
        try {
            for(String s:fc1m.keySet())
            {
                FineComperablePart fcp1 = fc1m.get(s);
                FineComperablePart fcp2 = fc2m.get(s);

                if(fcp2 != null)
                {

                    num++;
                    sum += fcp1.fineCompare(fcp2);

                }

            }
        } catch (IncompatibilityException ex) {
            return 0;
        }
        num = fc1m.size() + fc2m.size()-num;
        
        if(num == 0)
            return 0;
        
        return sum/num;
        
    }
    
    public static int fineCompare(FineComperable fc1, FineComperable fc2, Map<String, Integer> weight)
    {
        int sum = 0;
        int num = 0;
        
        Map<String, FineComperablePart> fc1m = fc1.getComperableParts();
        Map<String, FineComperablePart> fc2m = fc2.getComperableParts();
        
        try {
            for(String s:fc1m.keySet())
            {
                FineComperablePart fcp1 = fc1m.get(s);
                FineComperablePart fcp2 = fc2m.get(s);

                if(fcp2 != null)
                {
                    Integer i = weight.get(s);
                    int w=1;
                    if(i != null)
                    {
                        w = i;
                    }

                    num+=w;
                    sum += fcp1.fineCompare(fcp2)*w;
                }

            }
        } catch (IncompatibilityException ex) {
            return 0;
        }
        num = weight(fc1m, weight) + weight(fc2m, weight) - num;
        
        if(num == 0)
            return 0;
        
        return sum/num;
    }
    
    private static int weight(Map<String, FineComperablePart> map, Map<String,Integer> weight)
    {
        int sum = 0;
        for(String s: map.keySet())
        {
            Integer i = weight.get(s);
            
            if(i != null)
                sum +=i;
            else
                sum++;
        }
        return sum;
    }
}
