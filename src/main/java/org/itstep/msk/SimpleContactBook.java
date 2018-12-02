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
    Contact create(String name, String phoneNumber);
    SimpleContactBook delete(Contact c);
    Iterable<Contact> read();
    SimpleContactBook commit();
}

