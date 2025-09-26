import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tasks.second.*;
import tasks.third.*;

public class Main {

    // Дополните объявление поля friendsContactBook, которое будет хранить в себе список номеров телефонов друзей
    private static final ContactBook<Contact> friendsContactBook = new ContactBook<>();
    private static final ContactBook<Email> colleaguesContactBook = new ContactBook<>();
    private static final ContactBook<SocialNetworkContact> classmatesContactBook = new ContactBook<>();
    private static final ContactBook<Address> relativesContactBook = new ContactBook<>();

    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();
    }

    private static void firstTask() {
        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(1.0);
        list1.add(2.0);
        list1.add(3.0);

        System.out.println("В первом списке " + size(list1) + " элементов");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("uno");
        list2.add("dos");
        list2.add("tres");
        list2.add("cuatro");
        list2.add("cinco");

        System.out.println("Во втором списке " + size(list2) + " элементов");
    }

    private static void secondTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Заполните данные для ипотечной заявки и узнайте статус одобрения");
        System.out.println("Введите ФИО:");
        String name = scanner.nextLine();

        System.out.println("Ваш возраст:");
        byte age = scanner.nextByte();

        System.out.println("Планируемая сумма ипотеки:");
        int mortgageAmount = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Трудоустроены ли вы сейчас? (д/н)");
        String employedString = scanner.nextLine();
        boolean employed = employedString.equalsIgnoreCase("д");

        MortgageRequest mortgageRequest = new MortgageRequest(name, age, mortgageAmount, employed);
        mortgageRequest.validate();
    }

    private static void thirdTask() {
        fillBooks();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Сегодня Новый Год! 1 - Отправить поздравление, 0 - Напомнить позднее");
            int mainCommand = scanner.nextInt();
            if (mainCommand == 1) {
                System.out.println("Какую книгу контактов открыть?");
                System.out.println("1 - Друзья, 2 - Коллеги, 3 - Одногруппники, 4 - Родственники");

                int bookIndex = scanner.nextInt();
                if (bookIndex == 1) {
                    friendsContactBook.printList();
                } else if (bookIndex == 2) {
                    colleaguesContactBook.printList();
                } else if (bookIndex == 3) {
                    classmatesContactBook.printList();
                } else if (bookIndex == 4) {
                    relativesContactBook.printList();
                }

                System.out.println("Кого вы хотите поздравить? Введите имя:");
                String name = scanner.next();
                if (bookIndex == 1) {
                    friendsContactBook.congratulate(name);
                } else if (bookIndex == 2) {
                    colleaguesContactBook.congratulate(name);
                } else if (bookIndex == 3) {
                    classmatesContactBook.congratulate(name);
                } else if (bookIndex == 4) {
                    relativesContactBook.congratulate(name);
                }
            } else if (mainCommand == 0) {
                break;
            }
        }
    }

    private static void fillBooks() {
        friendsContactBook.addContact(new Phone("Иван", "+7-909-000-11-22"));
        friendsContactBook.addContact(new Phone("Маша", "+7-999-555-11-22"));
        friendsContactBook.addContact(new Phone("Кирилл", "+7-979-698-00-22"));

        colleaguesContactBook.addContact(new Email("Александр", "sasha@sasha.ru"));
        colleaguesContactBook.addContact(new Email("Павел", "pasha@pasha.ru"));
        colleaguesContactBook.addContact(new Email("Олег", "oleg@oleg.ru"));

        classmatesContactBook.addContact(new SocialNetworkContact("Оля", "НаСвязи", "olya"));
        classmatesContactBook.addContact(new SocialNetworkContact("Женя", "Фотопризма", "zhenya"));

        relativesContactBook.addContact(new Address("Бабуля", "Москва", "Тверская, д.8"));
        relativesContactBook.addContact(new Address("Дедуля", "Воронеж", "Ленина, д.10"));
    }

    private static <T> int size(List<T> list) {
        return list.size();
    }
}