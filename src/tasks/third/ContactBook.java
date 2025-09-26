package tasks.third;

import java.util.ArrayList;
import java.util.List;

public class ContactBook <T extends Contact>{
    private final List<T> contacts = new ArrayList<>();

    public void addContact(T contact){
        contacts.add(contact);
    }

    public void printList(){
        for(T contact : contacts){
            System.out.println("Имя: "+ contact.getName());
            contact.print();
        }
    }

    public void congratulate(String name){
        boolean contactPresented = false; //проверяем есть ли контакт в базе

        var optionalContact = contacts.stream().filter(i -> i.getName().equals(name)).findFirst(); //здесь мы берем первое совпадение с именем

        if(optionalContact.isPresent()){
            var contact = optionalContact.get();
            System.out.println("Поздравим с Новым годом ваш контакт из записной книжки: " + name);
            contact.sendMessage();
        }
        else{
            System.out.println("Не найден контакт с указанным именем.");
        }
    }
}