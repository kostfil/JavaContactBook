package org.itstep.msk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapContactBook implements SimpleContactBook {
    private TreeMap<String, Contact> nameKey = null;

    TreeMapContactBook(TreeMap<String, Contact> nameKey) {
        this.nameKey = nameKey;
    }

    @Override
    public Contact create(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        String[] names = name.split(" ", 3);
        for (int i = 0; i < names.length; ++i) {
            nameKey.putIfAbsent(names[i], newContact);
        }
        return newContact;
    }

    @Override
    public SimpleContactBook delete(Contact c) {
        String[] names = c.getName().split(" ", 3);
        for (int i = 0; i < names.length; ++i) {
            nameKey.remove(names[i]);
        }
        return this;
    }


    @Override
    public Iterable<Contact> read() {
        return Collections.unmodifiableCollection(nameKey.values());
    }


    @Override
    public SimpleContactBook commit() {
        return null;
    }


    public Iterable<Contact> FindByNameTreeMapSpecification(String name) {
        ArrayList<Contact> result = new ArrayList<>();

        if( nameKey.containsKey(name) ){
            result.add( nameKey.get(name) );
        }
        return result;
    }

    public Iterable<Contact> NameStartsWithTreeMapSpecification(String prefix) {
        ArrayList<Contact> result = new ArrayList<>();
        for(Map.Entry<String,Contact> curContact : nameKey.entrySet()) {
            String [] names = curContact.getValue().getName().split(" ");
            for(int i = 0 ; i < names.length; ++i){
                if(names[i].substring(0, prefix.length()).equalsIgnoreCase(prefix) ) {
                    result.add(nameKey.get(names[i]));
                    break;
                }
            }
        }
        return result;
    }


}