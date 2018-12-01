package org.itstep.msk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The main idea of the project:
 * This interface represents by the repository pattern a collection of contacts
 * Such an interface gives us a possibility to store data anywhere we want
 * The concrete store strategy (Relational DB, NoSqlDB or Files) is an implementation
 *
 * @author Марк Михайлович
 * @version 1.0
 * */
public interface SimpleContactBook {
    ExtendContact create(String name, String phoneNumber);
    SimpleContactBook delete(ExtendContact c);
    Iterable<ExtendContact> read();
    SimpleContactBook commit();
}

/**
 *
 * ContactBookSet - private HashSet collection store all Contacts.
 * Constructor ContactBook(Collection<Contact> cont) fills ContactBookSet
 * from external collection.
 *
 *
 **/

class ContactBook implements SimpleContactBook {

    private HashSet<ExtendContact> ContactBookSet = null;

    ContactBook(){
        ContactBookSet = new HashSet<>();
    }

    ContactBook(Collection<ExtendContact> cont){
        ContactBookSet = new HashSet<>(cont);
    }


    public ExtendContact create(String name, String phoneNumber) {
        ExtendContact newContact = new ExtendContact(new Contact(name, phoneNumber));
        if(ContactBookSet.contains(newContact))
            return null;
        else
            ContactBookSet.add(newContact);
        return newContact;
    }


    public Iterable<ExtendContact> read() {
        Iterator<ExtendContact> it = ContactBookSet.iterator();

        while(it.hasNext()) {
            ExtendContact tmp = it.next();
            //тут должен использоваться метод print для вывода getName() и т.п. объекта tmp.
        }
        return null;
    }

    public ContactBook delete(ExtendContact c){
        if(ContactBookSet.contains(c))
            ContactBookSet.remove(c);
        return this;
    }

    public Iterable<ExtendContact> FindName(String SearchName){
        ArrayList<ExtendContact> resultSearch = new ArrayList<>();
        Iterator<ExtendContact> it = ContactBookSet.iterator();

        while(it.hasNext()) {
            ExtendContact CurrentContact = it.next();
            if(CurrentContact.getFirstName().substring(0, SearchName.length()).equalsIgnoreCase(SearchName)){
                resultSearch.add(CurrentContact);
            }
        }
        return resultSearch;
    }

    public ContactBook commit(){

        return this;
    }



}