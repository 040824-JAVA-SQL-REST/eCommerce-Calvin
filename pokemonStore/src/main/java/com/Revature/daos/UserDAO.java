package com.Revature.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.models.User;

public class UserDAO extends AbstractFileHandler implements CrudDAO<User>{

    public UserDAO() {
        super("db/user.txt", "pokemonStore/src/main/resources/db/user.txt");
    }

    @Override
    public User save(User obj) {
        try (BufferedWriter bw = getWriter()) {
            bw.write(obj.convertToData());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            }
        return obj;
    }

    @Override
    public User update(User obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public User delete(String ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try(BufferedReader reader = getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                String [] data = line.split("/");
                users.add(new User(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByID(String ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }
}
