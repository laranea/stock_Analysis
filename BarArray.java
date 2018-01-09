//Design a class BarArray as wrapper to java class Vector that has the following characteristics:
//1- a private member Vector of Bar (objects from class Bar already designed)
//2- A set of methods that make the use of the class easier (all of them should call the native methods from class Vector; they are merely calls)
//- boolean isEmpty()
//-boolean isFull()
//-int size()
//-boolean insertHead(Bar b);
//-boolean insertTail(Bar b);
//-boolean insert(Bar b, int index); //to insert at specific index
//-Bar remove(int index); //removes the Bar at index and returns it 
//-Bar removeHead(); //removes the Bar at the head and returns it
//-Bar removeTail();//removes the Bar at the tail and returns it.
//-Bar At(int ind); //returns the Bar at index ind without removing it from the Vector. 

import java.util.Vector;

public class BarArray{
	private Vector<Bar> bar;
	public BarArray(){
		this.bar = new Vector<Bar>(100);
	}
	public boolean isEmpty(){
		if(this.bar.isEmpty())
			return true;
		return false;
	}
	public boolean isFull(){
		if(this.bar.size() == this.bar.capacity())
			return true;
		return false;
	}
	public int size(){
		return this.bar.size();
	}
	public boolean insertHead(Bar b){
		if(this.bar.size() == this.bar.capacity()){
			return false;
		}
		this.bar.insertElementAt(b, 0);
		return true;
	}
	public boolean insertTail(Bar b){
		this.bar.insertElementAt(b, this.bar.size()-1);
		return true;
	}
	public boolean insert(Bar b, int index){
		this.bar.insertElementAt(b, index);
		return true;
	}
	public Bar remove(int index){
		Bar b = this.bar.get(index);
		this.bar.remove(index);
		return b;
	}
	public Bar removeHead(){
		Bar b = this.bar.elementAt(0);
		this.bar.remove(0);
		return b;
	}
	public Bar removeTail(){
		Bar b = this.bar.lastElement();
		this.bar.remove((this.bar.size()-1));
		return b;
	}
	public Bar at(int ind){
		return this.bar.elementAt(ind);
	}
}
