class Set {
    private int[] elements;
    private int capacity;
    public Set() {
    }

    public Set(int[] elements) {
        this.elements = elements;
    }


    public Set(int capacity) {
        this.elements = new int[capacity];
        this.capacity = capacity;
    }

    public Set(int[] elements, int capacity) {
        this.elements = elements;
        this.capacity = capacity;
    }

    public int[] getElements() {
        return elements;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean contain(int value){
        for(int element : elements){
            if (element == value){
                return true;
            }
        }
        return false;
    }

    public void add(int element){

        if(!this.contain(element)){
            for (int i = 0; i < this.capacity; i++) {
                if(elements[i] == 0){
                    elements[i] = element;
                    break;
                }
            }

        }
    }

    public void remove(int element){

        if(this.contain(element)){
            for (int i = 0; i < this.capacity; i++) {
                if(elements[i] == element){
                    elements[i] = 0;
                    break;
                }
            }
        }
    }

    static public Set union(Set firstSet, Set secondSet) {
        Set result = new Set(firstSet.getCapacity() + secondSet.getCapacity());

        for (int i = 0; i < firstSet.capacity; i++) {
            result.add(firstSet.elements[i]);
        }
        for (int i = 0; i < secondSet.capacity; i++) {
            result.add(secondSet.elements[i]);
        }
        return result;
    }

    public void printElements() {
        System.out.print("Elements: ");
        for (int i = 0; i < this.capacity; i++) {
            System.out.print(this.elements[i] + " ");
        }
        System.out.println();
    }

    public boolean equals(Set set) {
        if (this.capacity != set.getCapacity()){
            return false;
        } else {
            for (int element: elements){
                if(!set.contain(element)){
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int element: elements){
            stringBuilder.append(element);
            stringBuilder.append(' ');
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

}

public class Zad1 {
    public static void main(String[] args) {
        Set set1 = new Set(5);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set set4 = new Set(5);
        set4.add(1);
        set4.add(2);
        set4.add(3);
        Set set2 = new Set(5);
        set2.add(4);
        set2.add(5);
        set2.add(3);
        set1.printElements();
        set2.printElements();
        set4.printElements();
        Set set3 = Set.union(set1,set2);
        set3.printElements();
        set3.remove(5);
        String string = set3.toString();
        System.out.println(string);
        System.out.println( set1.equals(set4));
        System.out.println( set1.equals(set1));
        System.out.println( set1.equals(set2));
    }
}

