package Parallelstreams;

import static learnjava.util.CommonUtil.delay;

import java.util.List;
import java.util.stream.Collectors;

import learnjava.util.CommonUtil;
import learnjava.util.DataSet;
import learnjava.util.LoggerUtil;

public class Parallelstreamexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> stringlist = DataSet.namesList();
		Parallelstreamexample parallelstream  = new Parallelstreamexample();
		parallelstream.stringTransform(stringlist);;
		parallelstream.Tolowercase(stringlist);

	}
	public void Tolowercase(List <String> strlist){
		List<String> lowcase =strlist.parallelStream().map(name->name.toUpperCase()).collect(Collectors.toList());
		lowcase.stream().forEach(System.out::println);
		
	}
	public List<String>  stringTransform(List<String> stringlist){
		CommonUtil.startTimer();
		List<String> strlist = stringlist.parallelStream().map(this::addNameLengthTransform).collect(Collectors.toList());
		//LoggerUtil.log("log result" +strlist);
		CommonUtil.timeTaken();
	
	return strlist;
		
	}
	
    private  String addNameLengthTransform(String name) {
        delay(500);
        return name.length()+" - "+name ;
    } 

}
