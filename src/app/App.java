package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class App {
	public static void main(String[] args) {
		Map<String, Integer> votes = new HashMap<String, Integer>();
		String path = "C:\\Users\\User\\eclipse-workspace\\urn_counter\\src\\repository\\in.txt";
		
		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
			String line = bf.readLine();
			while(line!=null) {
				String[] splitedLine = line.split(",");
				String cadidate = splitedLine[0];
				int vote = Integer.parseInt(splitedLine[1]);
				if(votes.containsKey(cadidate)) {
					vote += votes.get(cadidate);
				}
				votes.put(cadidate, vote);
				line=bf.readLine();
			}
			for(String key: votes.keySet()) {
				System.out.println(key+": "+votes.get(key));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
