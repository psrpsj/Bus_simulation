//ArrayList was from Project 3 written by park1564, imxxx074
//written by : park1564, imxxx074

public class ArrayList<T extends Comparable<T>> implements List<T>{

  //Initailize variable
  private T[] list;
  private int num_entered;

  public ArrayList(){
    list = (T[]) new Comparable[2];
    num_entered = 0;
  }

  public boolean add(T element){
    if(element == null){
      return false;
    }

    else{
      if(num_entered == list.length){
        growAndcopy();
        list[num_entered] = element;
        num_entered += 1;
      }

      else{
        list[num_entered] = element;
        num_entered += 1;
      }
      return true;
    }
  }

  public boolean add(int index, T element){
    //Check input index is valid number or not
    if(index < 0 || index >= list.length){
      return false;
    }

    else{
      if(list[index] == null){
        list[index] = element;
        num_entered += 1;
      }

      else{
        //if arraylist is full, increase the size by 2
        if(num_entered == list.length){
          growAndcopy();
        }
        T[] temp_list = (T[]) new Comparable[list.length];
        //copy the data from existed arraylist and put element in given index
        for(int i = 0; i < index; i++){
          temp_list[i] = list[i];
        }
        temp_list[index] = element;

        for(int j = index + 1; j < list.length; j++){
          temp_list[j] = list[j-1];
        }

        list = temp_list;
        num_entered += 1;
      }

      return true;
    }
  }

  public void clear(){
    list = (T[]) new Comparable[2];
    num_entered = 0;
  }

  public boolean contains(T element){
    for(int i = 0; i < this.size(); i++){
      if(list[i].equals(element)){
        return true;
      }
    }
    return false;
  }

  public T get(int index){
    //check if input index is valid number
    if(index < 0 || index >= list.length){
      return null;
    }
    return list[index];
  }

  public int indexOf(T element){
    for(int i = 0; i < this.size(); i++){
      if(list[i].equals(element)){
        return i;
      }
    }
    return -1;
  }

  public boolean isEmpty(){
    if (this.size() == 0)
    return true;
    else
    return false;
  }

  public int lastIndexOf(T element){
    //element_index keep the index value found
    int element_index = -1;
    //iterate through the array and if element and array data equal,
    //save index into element_index
    for(int i = 0; i < this.size(); i++){
      if(list[i].equals(element)){
        element_index = i;
      }
    }
    return element_index;
  }

  public T set(int index, T element){

    T previous = null;
    //check any cases that set function would not work and return null
    if(index < 0 || index >= list.length || list[index] == null){
      return null;
    }
    else{
      previous = list[index];
      list[index] = element;
    }
    return previous;
  }

  public int size(){
    return num_entered;
  }

  public void sort(boolean order){
    if(order == true){
      for(int i = 0; i < num_entered; i++){
        for(int j = 0; j < num_entered; j++){
          if(list[i].compareTo(list[j]) < 0){
            T temp = list[i];
            list[i] = list[j];
            list[j] = temp;
          }
        }
      }
    }

    if(order == false){
      for(int i = 0; i < num_entered; i++){
        for(int j = 0; j < num_entered; j++){
          if(list[i].compareTo(list[j]) > 0){
            T temp = list[j];
            list[j] = list[i];
            list[i] = temp;
          }
        }
      }
    }
  }

  public boolean remove(T element){
    int temp_index = 0;
    boolean result = false;
    for(int i = 0; i < num_entered; i++){
      if(list[i].equals(element)){
        list[i] = null;
        temp_index = i;
        result = true;
        num_entered -= 1;
      }
    }
    //move items in the right one to left
    if(result == true){
      removeReorder(temp_index);
    }
    return result;
  }

  public T remove(int index){
    if(index < 0 || index >= list.length){
      return null;
    }
    T removed = list[index];
    list[index] = null;
    num_entered -= 1;
    removeReorder(index);
    return removed;
  }

  //helper function
  //increase the array by 2 with before array data
  public void growAndcopy(){
    T[] modified_list = (T[]) new Comparable[list.length * 2];
    for(int i = 0; i < list.length; i++){
      modified_list[i] = list[i];
    }
    list = modified_list;
  }
  //remove and reorder exist data
  public void removeReorder(int index){
    for(int i = index; i < list.length - 1; i++){
      T temp = list[i+1];
      list[i] = temp;
    }
  }  
}
