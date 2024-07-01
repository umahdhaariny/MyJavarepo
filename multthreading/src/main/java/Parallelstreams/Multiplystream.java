package Parallelstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import learnjava.domain.checkout.Cart;
import learnjava.util.CommonUtil;

public class Multiplystream {
	
	public static void main (String args[]) {
		
		List<Integer> inlist = List.of(1,3,5,6);
		
		multiplyusigstrema(inlist);
		
	}
	
	public static List<Integer> multiplyusigstrema(List<Integer> inlist) {
		// TODO Auto-generated method stub
		CommonUtil.startTimer();
		List <Integer> modlist =inlist.stream().map(n->n*2).collect(Collectors.toList());
		CommonUtil.timeTaken();
		CommonUtil.stopWatchReset();
		
	//	modlist.stream().forEach(System.out::println);
		return modlist;
	}
	


	

}
