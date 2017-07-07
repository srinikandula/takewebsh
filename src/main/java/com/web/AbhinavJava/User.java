package com.web.AbhinavJava;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by surap on 4/27/2017.
 */
public class User implements Externalizable {
    private int id;
    private String username;
    private String email;
    private transient long ssn;

    public User(int id, String username, String email, long ssn) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.ssn = ssn;
    }

    public User(){
    }
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public long getSsn(){
        return ssn;
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(username);
        out.writeObject(email);
        out.writeLong(ssn);
    }

    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException {
        id = in.readInt();
        username = (String) in.readObject();
        email = (String) in.readObject();
    }
}
