package genericListClass;

import java.util.Arrays;

public class GenericList<T> {

    private int capacity;
    private int constCapacity;
    private T [] list;
    private int index = 0;


    public GenericList(int capacity) {
        this.capacity = capacity;
        this.constCapacity= capacity;
        this.list =(T[]) new Object[capacity];
    }
    public GenericList() {
        this.capacity = 10;
        this.constCapacity= 10;
        this.list =(T[]) new Object[capacity];
    }

    public void add(T t){
        if(index<this.capacity){
            list[index++]= t;
        }
        else {

            this.capacity = capacity*2;
            T[] temp =(T[]) this.getList().clone();
            this.list =  (T[]) new Object[capacity];
            for (int i = 0; i < temp.length; i++)
                this.list[i] = temp[i];
            this.add(t);
        }

    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }

    public T get(int index){
        if(index>=this.getCapacity()){
            return null;
        }
        return (T) this.getList()[index];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int size(){
        int size= 0;
        for(int i = 0;i<this.getCapacity();i++){
            if(this.getList()[i]==null){
                continue;
            }
            else size++;
        }
        return size;
    }
    public Object set(int index,T value){
        if(index<0 || index>=this.size()){
            return null;
        }
        else {
            this.list[index] =value;
            return this.getList();
        }
    }
    public String toString(){
        Object [] temp = new Object[this.size()];
        for(int i = 0; i<temp.length;i++){
            temp[i]=this.getList()[i];
        }
        return Arrays.toString(temp);
    }
    public T[] remove(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        } else {

            for (int i = index; i < this.size(); i++) {
                this.list[i] = this.getList()[i + 1];

            }
            this.index--;
            return this.getList();
        }
    }

    public int indexOf(T t){
        for(int  i = 0;i<this.size();i++){
            if(this.getList()[i]==t){

                return i;
            }
            else {
                continue;
            }
        }
        return -1;
    }
    public int lastIndexOf(T t){
        for(int i = this.size()-1;i<this.size();i--){
            if(this.getList()[i]==t && this.indexOf(t)!=i){
                return i;
            }
            else{
                continue;
            }

        }
        return -1;
    }
    public boolean isEmpty(){
        if(this.size()==0){
            return true;
        }
        return false;
    }
    public Object [] toArray(){
        Object [] o = new Object[this.size()];
        o = this.getList();
        return o;
    }
    public void clear(){
        for(int i = 0; i<this.size();i++){
           this.remove(i--);
        }
        this.setCapacity(this.constCapacity);
    }
    public GenericList<T> subList(int start,int finish){
        GenericList<T> subList = new GenericList<>(finish-start);
        int startIndex = start;
        for(int i = 0; i<=finish-start;i++){

            subList.add(this.get(startIndex++));
        }

        return  subList;
    }

    boolean isContain(T value){
        for (T val :this.getList()
             ) {
            if(value==val){
                return true;
            }
        }
        return false;
    }


}
