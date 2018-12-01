package org.itstep.msk;

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
    Contact create(String name, String phoneNumber);
    SimpleContactBook delete(Contact c);
    Iterable<Contact> read();
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

    private HashSet<Contact> ContactBookSet = null;

    ContactBook(){
        ContactBookSet = new HashSet<>();
    }

    ContactBook(Collection<Contact> cont){
        ContactBookSet = new HashSet<>(cont);
    }


    public Contact create(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        if(ContactBookSet.contains(newContact))
            return null;
        else
            ContactBookSet.add(newContact);
        return newContact;
    }


    public Iterable<Contact> read() {
        Iterator<Contact> it = ContactBookSet.iterator();

        while(it.hasNext()) {
            Contact tmp = it.next();
            //тут должен использоваться метод print для вывода getName() и т.п. объекта tmp.
        }
        return null;
    }

    public ContactBook delete(Contact c){
        if(ContactBookSet.contains(c))
            ContactBookSet.remove(c);
        return this;
    }

    public ContactBook commit(){

        return this;
    }


/*
    Для класса Contact надо переопредлить hashCode() и equals например так:

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Contact))
            return false;
        Contact entry = (Contact)obj;
        return Name.equals(entry.Name) && phoneNumber.equals(entry.phoneNumber);
    }

    @Override
    public int hashCode(){
        int hash = 37;
        hash = hash*17 + Name.hashCode();
        hash = hash*17 + phoneNumber.hashCode();
        return hash;
    }


 */
}