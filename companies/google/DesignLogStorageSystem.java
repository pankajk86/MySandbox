package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignLogStorageSystem {

	public static void main(String[] args) {
		LogSystem ls = new LogSystem();
		ls.put(1, "2017:01:01:23:59:59");
		ls.put(2, "2017:01:01:22:59:59");
		ls.put(3, "2016:01:01:00:00:00");
		
		List<Integer> result = ls.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
		System.out.println(result);
		result = ls.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
		System.out.println(result);
	}

}


class LogSystem {
	
	private TreeMap<Long, List<Integer>> yearMap = null; 
	private TreeMap<Long, List<Integer>> monthMap = null;
	private TreeMap<Long, List<Integer>> dayMap = null;
	private TreeMap<Long, List<Integer>> hourMap = null;
	private TreeMap<Long, List<Integer>> minuteMap = null;
	private TreeMap<Long, List<Integer>> secondMap = null;

    public LogSystem() {
        yearMap = new TreeMap<>();
        monthMap = new TreeMap<>();
        dayMap = new TreeMap<>();
        hourMap = new TreeMap<>();
        minuteMap = new TreeMap<>();
        secondMap = new TreeMap<>();
    }
    
    public void put(int id, String t) {
        String[] tParts = t.split(":");
        long year = Long.parseLong(tParts[0]);
        long month = Long.parseLong(tParts[0] + tParts[1]);
        long day = Long.parseLong(tParts[0] + tParts[1] + tParts[2]);
        long hour = Long.parseLong(tParts[0] + tParts[1] + tParts[2] + tParts[3]);
        long minute = Long.parseLong(tParts[0] + tParts[1] + tParts[2] + tParts[3] + tParts[4]);
        long second = Long.parseLong(tParts[0] + tParts[1] + tParts[2] + tParts[3] + tParts[4] + tParts[5]);
        
        List<Integer> yList = yearMap.getOrDefault(year, new ArrayList<>());
        List<Integer> moList = monthMap.getOrDefault(month, new ArrayList<>());
        List<Integer> dList = dayMap.getOrDefault(day, new ArrayList<>());
        List<Integer> hList = hourMap.getOrDefault(hour, new ArrayList<>());
        List<Integer> miList = minuteMap.getOrDefault(minute, new ArrayList<>());
        List<Integer> sList = secondMap.getOrDefault(second, new ArrayList<>());
        
        yList.add(id); moList.add(id); dList.add(id); hList.add(id); miList.add(id); sList.add(id);
        
        yearMap.put(year, yList);
        monthMap.put(month, moList);
        dayMap.put(day, dList);
        hourMap.put(hour, hList);
        minuteMap.put(minute, miList);
        secondMap.put(second, sList);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
    	
    	List<Integer> result = new ArrayList<>();
    	long start = parseTimestamp(s, gra);
    	long end = parseTimestamp(e, gra);
    	Map<Long, List<Integer>> subMap = null;
    	
    	if("Year".equals(gra)) 
    		subMap = yearMap.subMap(start, end + 1);
    	else if("Month".equals(gra))
    		subMap = monthMap.subMap(start, end + 1);
    	else if("Day".equals(gra))
    		subMap = dayMap.subMap(start, end + 1);
    	else if("Hour".equals(gra))
    		subMap = hourMap.subMap(start, end + 1);
    	else if("Minute".equals(gra))
    		subMap = minuteMap.subMap(start, end + 1);
    	else if("Second".equals(gra))
    		subMap = secondMap.subMap(start, end + 1);
    	
    	for(Map.Entry<Long, List<Integer>> entry: subMap.entrySet())
    		result.addAll(entry.getValue());
    	
		return result;
        
    }
    
    private long parseTimestamp(String t, String gra) {
    	
    	String[] tParts = t.split(":");
    	StringBuilder sb = new StringBuilder();
    	
    	if("Year".equals(gra))
    		sb.append(tParts[0]);
    	else if("Month".equals(gra))
    		sb.append(tParts[0] + tParts[1]);
    	else if("Day".equals(gra))
    		sb.append(tParts[0] + tParts[1] + tParts[2]);
    	else if("Hour".equals(gra))
    		sb.append(tParts[0] + tParts[1] + tParts[2] + tParts[3]);
    	else if("Minute".equals(gra))
    		sb.append(tParts[0] + tParts[1] + tParts[2] + tParts[3] + tParts[4]);
    	else if("Second".equals(gra))
    		sb.append(tParts[0] + tParts[1] + tParts[2] + tParts[3] + tParts[4] + tParts[5]);
    	
    	return Long.parseLong(sb.toString());
    }
  
}