package PractiveJava;
//Java@#4321 -passwd ti git 
//https://medium.com/javarevisited/tricky-java-interview-questions-for-7-years-of-experience-c2d2bf37d746
import java.io.File;

public class FileSearchUsingThread {
	public static void main(String args[]) {
		String filename ="ab.txt";
		for (char drive='C'; drive<='D';drive++){
			String rootpath=drive+":\\";
			File[] directories = new File(rootpath).listFiles(File::isDirectory);
			if(directories != null ) {
				for (File directory : directories)
					new FilesearchThread(filename,directory).start();;
			}
		}
				
	}

}

class FilesearchThread extends Thread{
	private  String filename = "";
	private  File directory = null;
	
	public FilesearchThread(String fileName, File directory) {
		 this.filename = fileName;
		 this.directory = directory;
	}
	public void run() {
		boolean result = searchfile(filename,directory);
		System.out.println("retruning back");
		if(result == true) {
			System.out.println("the file found"+ filename);
			return ;
		}	
	}
	private boolean searchfile(String filename2, File directory2) {
		// TODO Auto-generated method stub
		File[] files=directory2.listFiles();
		if(files !=null)
		for (File f :files) {
			if(f.isDirectory()) {
				searchfile(filename2,f);
			}
			else {
				if(f.getName().equalsIgnoreCase(filename2)) {
					System.out.println("File found");
				}
					return true;
					
			}
		}
		//this.currentThread().dumpStack();
		return false;
	}
		 
}