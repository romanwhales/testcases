package com.eppress.demo.services;

import com.eppress.demo.entities.User;
import com.eppress.demo.exceptions.UserImportServiceCommunicationFailure;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImporter {
    public List<User> importUsers() throws UserImportServiceCommunicationFailure{
        List<User> users = new ArrayList<>();

        //get users by Invoking some web service
        //if any exception occurs throw UserImportService CommunicationFailure

        //dummy data
        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }
}
