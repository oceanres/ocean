package oceanMerge;
//!get time of load 

//get size of file
//get strings of load

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
public static	String dirName = "/usr/system/lab/ocean/data/src";
static int countOfStringsInAllFiles = 0;
static int countOfAllFiles = 0;

	public static void main(String args[]) throws IOException {
		LocalDateTime timeStart = LocalDateTime.now();

		//String dirName = args[0];
		System.out.println(dirName);

		List<File> filesInFolder = Files.walk(Paths.get(dirName)).filter(Files::isRegularFile).map(Path::toFile)
				.collect(Collectors.toList());


		
		for (File file : filesInFolder) {
			if (file.isFile()&&file.getName().contains("peno_")) {
				loadFile(file.getAbsolutePath());
				countOfAllFiles++;
			}
		}
		//loadFile("/usr/system/lab/ocean/data/src/15112015/");

		LocalDateTime timeLoadDone = LocalDateTime.now();

		LocalDateTime timeViewDone = LocalDateTime.now();
		Duration durationLoad = Duration.between(timeStart, timeLoadDone);
		Duration durationView = Duration.between(timeLoadDone, timeViewDone);

		System.out.println("countOfAllFiles:" + countOfAllFiles);
		System.out.println("listLoadedCount:" + countOfStringsInAllFiles);
		System.out.println("durationLoad:" + durationLoad);
//		System.out.println("durationView:" + durationView);

	}
	public static void loadFile(String fileName){
		List<String> list = new ArrayList<>();
		System.out.println(countOfAllFiles+":"+fileName);


		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			//stream.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("e"+e);
			e.printStackTrace();
		}
		
	}

}