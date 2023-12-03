import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Реализовать простейшую картотеку в виде консольного приложения. Программа должна включать:" +
                "\n1.Класс, описывающий узел списка - элемент картотеки (студент). Содержит атрибуты, описывающие элемент " +
                "\n(имя, возраст, фамилия, отчество, курс) и 2 функции, позволяющие:" +
                "\n\t1.считавать атрибуты объекта с консоли ;" +
                "\n\t2.вывод атрибутов на экран ;" +
                "\n2.Список (группа), содержащий:" +
                "\n\t1.контейнер (список) ссылок на класс-элемент;" +
                "\n\t2.Функцию создания пустого списка;" +
                "\n\t3.функцию добавления элемента (узла)  списка;" +
                "\n\t4.Функцию удаления элемента из списка;" +
                "\n\t5.функцию вывода элемента (узла) списка на экран;" +
                "\n\t6.функцию очистки списка;" +
                "\n\t7.Функцию проверки списка на пустоту (isEmpty);" +
                "\n3.Класс Тестер, который содержит функцию  main,выводится меню, которое позволяет воспользоваться всеми функциями, " +
                "экспортируемыми списком.");
        menu();
    }

    public static void menu() {
        LinkedList a = new LinkedList();
        while (true) {
            System.out.println("Добрый день! Введите цифру функции, которую вы желаете:" +
                    "\n1.Считать атрибуты объекта с консоли и добавить их в список" +
                    "\n2.Вывод атрибутов на экран" +
                    "\n3.Создать пустой список" +
                    "\n4.Удалить элемент из списка по индексу" +
                    "\n5.Вывести элемент из списка на экран по индексу" +
                    "\n6.Очистить список" +
                    "\n7.Проверить не пусто ли список" +
                    "\n8.Выход");
            Scanner console = new Scanner(System.in);
            System.out.println("Введите число: ");
            while ((!console.hasNextInt())) {
                System.out.println("Это не число!");
                console.next();
            }
            int numberOfMenu = console.nextInt();
            if (numberOfMenu > 8) {
                System.out.println("Вы ввели не то число");
            }
            if (numberOfMenu == 1) {
                System.out.println("Сколько вы хотите ввести элементов? Если вы не желаете вводить элементы напишите <<0>>");
                while ((!console.hasNextInt())) {
                    System.out.println("Это не число!");
                    console.next();
                }
                int value = console.nextInt();
                int counter = 0;
                if (value > 0) {
                    while (counter != value) {
                        LinkedList.Node b = new LinkedList.Node("", " ", " ", 0, 0);
                        b.input();
                        a.addLast(b.getName(), b.getSurname(), b.getSecond_name(),b.getAge(), b.getCourse());
                        counter++;
                    }
                }
            }
            if (numberOfMenu == 2) {
               a.printList();
            }
            if (numberOfMenu == 3) {
                a = a.doClearList();
            }
            if (numberOfMenu == 4) {
                System.out.println("Какой элемент вы хотите удалить? Если вы не желаете удалять элементы напишите <<0>>");
                while ((!console.hasNextInt())) {
                    System.out.println("Это не число!");
                    console.next();
                }
                int value = console.nextInt();
                a.checkIndex(value);
                a.remove(value);
                a.printList();
            }
            if (numberOfMenu == 5) {
                System.out.println("Какой элемент вы хотите вывести в консоль? Если вы не желаете выводить элементы напишите <<0>>");
                while ((!console.hasNextInt())) {
                    System.out.println("Это не число!");
                    console.next();
                }
                int value = console.nextInt();
                a.checkIndex(value);
                System.out.println(a.search(value));
            }
            if (numberOfMenu == 6) {
                a.clear();
                a.printList();
            }
            if (numberOfMenu == 7) {
                if (a.isEmpty()) {
                    System.out.println("Список пустой");
                } else {
                    System.out.println("Список не пустой");
                }
                a.printList();
            }
            if (numberOfMenu == 8) {
                break;
            }
        }
    }
}