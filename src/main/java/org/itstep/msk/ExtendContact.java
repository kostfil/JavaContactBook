package org.itstep.msk;

public class ExtendContact {
    private Contact MyContact;
    ExtendContact(Contact MyContact){
        this.MyContact = MyContact;
    }

    public String getFirstName(){
        return MyContact.getName();
    }

    public String getFirstPhone(){
        return MyContact.getPhone();
    }


    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof ExtendContact))
            return false;
        ExtendContact entry = (ExtendContact)obj;
        return getFirstName().equals(entry.getFirstName()) && getFirstPhone().equals(entry.getFirstPhone());
    }

    @Override
    public int hashCode(){
        int hash = 37;
        hash = hash*17 + getFirstName().hashCode();
        hash = hash*17 + getFirstPhone().hashCode();
        return hash;
    }


}
