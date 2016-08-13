package com.calc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Process{
	private int id;
	private int arrivalTime ;
	private int executionTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}
}
class RRQueue<T>{
	private Object [] array;
	private int head;
	private int tail;
	public RRQueue() {
		head = 0;
		tail = 0;
		array = new Object[100]; 
		
	}
	public  T deQueue(){
		Object p = null;
		
		if(tail < 0){
			System.out.println("Queue is over flowed");
		}
		else{
			p=array[tail];
			tail++;
		}
		return (T)p;
	}
	public void enQueue(T p){
		if(head == 100){
			System.out.println("Queue is over flowed");
		}else{
			array[head] = p;
			head++;
		}	
	}
	
}
public class RoundRobin {
	
	public static int  timeSlice =0;
    public static Process  findMinArrivalTimeProcess(Process[] arrayOfProcess){
		/*Process p = null;*/
    	
    	int min = arrayOfProcess[0].getArrivalTime();
    	Process p = arrayOfProcess[0];
		for(int x=1 ;x<=arrayOfProcess.length-1 ; x++){
			if(arrayOfProcess[x].getArrivalTime() < min){
				min = arrayOfProcess[x].getArrivalTime();
				p = arrayOfProcess[x];
			}
		}
		return p;
		
		
	}
    public static List<Process>  execTimeLessTimeSlice(Process []list,int timeSlice){
    	/*Process [] arr= null;*/
    	
    	List<Process> l = new ArrayList<Process>();
    	for(Process p:list){
    		if(p.getArrivalTime() <=timeSlice){
    			l.add(p);
    		}
    		
    	}
    	return l;
    }
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("Enter the no of process");
		Scanner sc = new Scanner(System.in);
		int noOfProcess = sc.nextInt();
		Process [] arrayOfProcess = new Process[noOfProcess];
		int i =1;
		timeSlice = 2;
		for(int x =1;x<=noOfProcess;x++ ){
			Process p = new Process();
			try{
			p.setId(x);
			System.out.println("Enter the Arrival time of "+i+"process");
			p.setArrivalTime(sc.nextInt());
			System.out.println("Enter the Execution of "+i+"process");
			p.setExecutionTime(sc.nextInt());
			}catch (NumberFormatException e) {
				throw new Exception("Number format exception");
			}
			arrayOfProcess[x-1]=p;
		}
		int pass = 1;
		for(Process p:arrayOfProcess){
			Process proc = findMinArrivalTimeProcess(arrayOfProcess);
			RRQueue<Process> rrQueue = new RRQueue<Process>();
			if(proc.getArrivalTime() == 0){
				rrQueue.enQueue(proc);
			}
			List<Process> arr = execTimeLessTimeSlice(arrayOfProcess,timeSlice);
			putProcessInReadyQueue(rrQueue,arr);
			
			
			
		}
	}
	private static void putProcessInReadyQueue(RRQueue<Process> rrQueue, List<Process> arr) {
		for(Process p: arr){
			rrQueue.enQueue(p);
		}
		
	}
	
	
}
