package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateFiles {

	public static void main(String[] args) {
		String[] paths = {
					"root/a 1.txt(abcd) 2.txt(efsfgh)", 
					"root/c 3.txt(abcd)",
					"root/c 3.txt(abdfcd)",
					"root/c/d 4.txt(efggdfh)"
				};
		
		List<List<String>> duplicatePathGroups = getDuplicateFilesPath(paths);
		System.out.println(duplicatePathGroups);
		
		duplicatePathGroups = findDuplicate(paths);
		System.out.println(duplicatePathGroups);
		
	}
	
	// better 
	public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String path: paths) {
            String[] parts = path.split(" ");
            for(int i = 1; i < parts.length; i++) {
                String[] fileContent = parts[i].split("\\(");
                List<String> list = map.getOrDefault(fileContent[1], new ArrayList<>());
                list.add(parts[0] + "/" + fileContent[0]);
                map.put(fileContent[1], list);
            }
        }
        
        for(List<String> list: map.values()) {
            if(list.size() > 1)
                result.add(list);
        }
        return result;
    }

	private static List<List<String>> getDuplicateFilesPath(String[] paths) {

		List<List<String>> list = new ArrayList<>();
		Map<String, List<TestFile>> map = new HashMap<>();
		List<TestFile> testFiles = new ArrayList<>();
		
		for(String s: paths) {
			String[] content = s.split(" ");
			String location = content[0];
			
			for(int i=1; i< content.length; i++) {
				TestFile file = new TestFile();
				file.location = location;
				file.name = content[i].substring(0, content[i].indexOf("("));
				file.content = getContent(content[i]);
				
				testFiles.add(file);
			}
		}
		
		for(TestFile file: testFiles) {
			String content = file.content;
			List<TestFile> files = new ArrayList<>();
			
			if(map.containsKey(content)) {
				files = map.get(content);
			}
			
			files.add(file);
			map.put(content, files);
		}
		
		for(List<TestFile> fileList : map.values()) {
			// "root/a/2.txt"
			if(fileList.size() > 1) {
				List<String> p = new ArrayList<>();
				for(TestFile tfile : fileList) {
					String groupFilePath = tfile.location + "/" + tfile.name;
					p.add(groupFilePath);
				}
				list.add(p);
			}
		}
		
		
		return list;
	}
	
	private static String getContent(String file) {
		Pattern pattern = Pattern.compile("\\(.*\\)");
		Matcher match = pattern.matcher(file);
		
		if(match.find()) {
			return match.group();
		}
		return null;
	}

}

class TestFile {
	String location;
	String name;
	String content;
}
