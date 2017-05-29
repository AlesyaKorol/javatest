package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Created by Alesia on 29.05.17.
 */
public class Users extends ForwardingSet<UserData> {
private Set<UserData> delegate;

public Users(Users users) {
        this.delegate = new HashSet<UserData>(users.delegate);

        }

public Users() {
        this.delegate = new HashSet<UserData>();
        }

public Users(Collection<UserData> groups) {
        this.delegate = new HashSet<UserData>(groups);
        }

@Override
protected Set<UserData> delegate() {
        return delegate;
        }

public Users withAdded(UserData group) {
        Users users = new Users(this);
        users.add(group);
        return users;
        }

public Users without(UserData group) {
        Users users = new Users(this);
        users.remove(group);
        return users;
        }
}
