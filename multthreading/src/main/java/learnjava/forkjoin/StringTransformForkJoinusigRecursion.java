package learnjava.forkjoin;

import learnjava.util.DataSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static learnjava.util.CommonUtil.delay;
import static learnjava.util.CommonUtil.stopWatch;
import static learnjava.util.LoggerUtil.log;

public class StringTransformForkJoinusigRecursion extends  RecursiveTask <List <String>>{

	
	private List<String> inputlist ;
    public StringTransformForkJoinusigRecursion(List<String> inputlist) {
		super();
		this.inputlist = inputlist;
	}


	public static void main(String[] args) {

        stopWatch.start();
        List<String> forjoinresult = new ArrayList<>();
        List<String> names = DataSet.namesList();
        ForkJoinPool forkjoinpool = new ForkJoinPool();
       
        StringTransformForkJoinusigRecursion forkjoinusingrecursion = new StringTransformForkJoinusigRecursion(names);
         forjoinresult =forkjoinpool.invoke(forkjoinusingrecursion);//As soon as we invoke the actual inour get added to the shared queue,then worker thread take task see compute
        stopWatch.stop();
        log("Final Result : "+ forjoinresult);
        log("Total Time Taken : "+ stopWatch.getTime());
    }


    private static String addNameLengthTransform(String name) {
        delay(500);
        return name.length()+" - "+name ;
    }


	@Override
	protected List<String> compute() {
		// TODO Auto-generated method stub-this perform work for you
		if(inputlist.size() <=1) {//continue the recursion until it become 1
			List<String> resultlist = new ArrayList<>();
			inputlist.forEach(name->resultlist.add(addNameLengthTransform(name)));//transformation happens
			return resultlist;
		}
		int midpoint  = inputlist.size()/2;
		ForkJoinTask<List<String>>leftlist = new StringTransformForkJoinusigRecursion(inputlist.subList(0, midpoint)).fork();// this fork placces the task in the workqueue and all thread run async
	//	ForkJoinTask<List<String>>rightlist = new StringTransformForkJoinusigRecursion(inputlist.subList(midpoint, inputlist.size())).fork();
		inputlist = inputlist.subList(midpoint, inputlist.size());
		List<String> rightresult = compute();//recursion happens - update the list
		List<String> leftresult = leftlist.join();//this is where it again join all the result
		leftresult.addAll(rightresult);
				return leftresult;
	}
}
