import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedList {
    public Node first;//первый узел двусвязного циклического списка
    public Node last;//последний узел двусвязного циклического списка
    public int size;

    public LinkedList doClearList() {//Функцию создания пустого списка
        LinkedList clear = new LinkedList();
        clear.first = new Node("", "", "", 0, 0);
        clear.last = clear.first;
        clear.size = 0;
        return clear;
    }

    public void addLast(String name, String surname, String second_name, int age, int course) {//функцию добавления элемента (узла)  списка
        if ((name != null) && (surname != null) && (second_name != null)) {
            if (this.first == null) {
                this.first = new Node(name, surname, second_name, course, age);
                this.first.next = this.first;
                this.last = this.first;
            } else {
                Node node = new Node(this.first, name, surname, second_name, course, age);
                this.last.next = node;
                this.last = node;
            }
            this.size++;
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index > this.size + 1) {
            throw new IndexOutOfBoundsException("Неправильный ввод индекса!");
        }
    }

    public boolean isEmpty() {//Функцию проверки списка на пустоту
        return this.size == 0;
    }

    public Node search(int index) {//Функцию нахождения элемента из списка
        checkIndex(index);
        index=index-1;
        System.out.println(index);
        System.out.println(this.size);
        boolean ans = false;
        Node result = this.first;
        int counter = 0;
        if (index == 0) {
            ans = true;
        }
        if (index == this.size) {
            result = this.last;
            ans = true;
        }
        while (counter != index) {
            counter++;
            result = result.next;
            ans = true;
        }
        if (index < 0 || index > this.size) {
            ans = false;
        }
        if (ans == true) {
            System.out.println("В списке нашелся элемент\n");
            return result;
        } else {
            System.out.println("В списке не нашелся элемент\n");
            Node node = new Node("", "", "", 0, 0);
            return node;
        }
    }

    public void removeFirst() {
        try {
            if (first.next != null) first = first.next;
            else{
                clear();
            }
            this.size--;
        } catch (NullPointerException e) {
            System.out.println("В списке нет элементов для удаления");
        }
    }
    public void removeLast() {
        Node tempNode = first;
        Node previousNode = tempNode;
        try {
            int count=0;
            while (count!=this.size) {
                previousNode = tempNode;
                tempNode = tempNode.next;
                count++;
            }
            previousNode.next = null;
            this.size--;
        } catch (NullPointerException e) {
            System.out.println("В списке нет элементов для удаления");
        }
    }
    public void remove(int index) {
        index=index-1;
        int count=0;
        if(index==0){
            this.removeFirst();
        }
        else if(index==size){
            this.removeLast();
        }else{
            Node current = first;
            int counter=0;
            while (counter!=index-1) {
                current = current.next;
                counter++;
            }
            current.next = current.next.next;
            this.size--;
        }
    }

    public void clear() {//функцию очистки списка
        this.first = new Node("","","",0,0);
        this.last = new Node("","","",0,0);
        this.size = 0;
    }

    public void input_to_list(int value) {
    }

    public void printList() {
        Node tempNode = first;
        try {
            boolean indicator=false;
            if((this.first.name=="")&&(this.first.surname=="")&&(this.first.second_name=="")&&(this.first.age==0)&&(this.first.course==0)){
                indicator=true;
            }
            if(indicator==false) {
                int count = 0;
                while (count != size) {
                    System.out.print( tempNode);
                    tempNode = tempNode.next;
                    count++;
                }
                System.out.print( tempNode + "\n");
            }
            if(indicator==true){
                System.out.println(" []");
            }
        } catch (NullPointerException e) {
            System.out.println("[]");
        }
    }

    public static class Node {//узел, хакартеристиками которого являются его значения и последюущий элементы
        public Node next;//следующий
        public String name;//имя
        public String surname;//фамилия
        public String second_name;//отчество
        public int age;//возраст
        public int course;//курс

        Node(Node next, String name, String surname, String second_name, int course, int age) {//сеттер
            this.next = next;
            this.name = name;
            this.surname = surname;
            this.second_name = second_name;
            this.age = age;
            this.course = course;
        }

        public void inputName() {//сеттер с вводом только значения
            Scanner console = new Scanner(System.in);
            System.out.println("Введите имя: ");
            while ((!console.hasNextLine())) {
                System.out.println("Это запрещенное значение!");
                console.next();
            }
            String name = console.next();
            this.name = name;
        }

        public void inputSurname() {
            Scanner console = new Scanner(System.in);
            System.out.println("Введите фамилию: ");
            while ((!console.hasNextLine())) {
                System.out.println("Это запрещенное значение!");
                console.next();
            }
            String surname = console.nextLine();
            this.surname = surname;
        }

        public void inputSecond_name() {
            Scanner console = new Scanner(System.in);
            System.out.println("Введите отчество: ");
            while ((!console.hasNextLine())) {
                System.out.println("Это не число!");
                console.next();
            }
            String second_name = console.nextLine();
            this.second_name = second_name;
        }

        public void inputAge() {
            Scanner console = new Scanner(System.in);
            System.out.println("Введите возраст");
            while ((!console.hasNextInt())) {
                System.out.println("Это не число!");
                console.next();
            }
            int age = console.nextInt();
            this.age = age;
        }

        public void inputCourse() {
            Scanner console = new Scanner(System.in);
            System.out.println("Введите курс");
            while ((!console.hasNextInt())) {
                System.out.println("Это не число!");
                console.next();
            }
            int course = console.nextInt();
            this.course = course;
        }

        @Override
        public String toString() {//вывод атрибутов на экран
            if ((this.surname != "") && (this.name != "") && (this.second_name != "") && (this.age != 0) && (this.course != 0)) {
                return String.format("Фамилия: %15s \tИмя: %15s \tОтчество: %15s \tКурс %3s \tВозраст %5s\n", this.surname, this.name, this.second_name, this.course, this.age);
            }
            return "";
        }

        public Node(String name, String surname, String second_name, int course, int age) {
            this(null,name, surname, second_name, course,age);
        }

        public void input() {//считавает атрибуты объекта с консоли
            this.inputName();
            this.inputSurname();
            this.inputSecond_name();
            this.inputCourse();
            this.inputAge();
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getSecond_name() {
            return second_name;
        }

        public int getAge() {
            return age;
        }

        public int getCourse() {
            return course;
        }
    }
}
