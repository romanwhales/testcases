package com.eppress.demo.services;

import com.eppress.demo.entities.User;
import com.eppress.demo.exceptions.UserImportServiceCommunicationFailure;
import com.eppress.demo.model.UsersImportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserImportService {
    @Autowired
    private UserImporter userImporter;

    public UsersImportResponse importUsers(){
        int retryCount = 0;
        int maxRetryCount = 3;

        for(int i=0;i < maxRetryCount; i++){
            try{
                List<User> importUsers = userImporter.importUsers();
                System.out.println("Import Users: "+importUsers);
                break;
            }catch(UserImportServiceCommunicationFailure e){
                retryCount++;
                System.err.println(" Error "+e.getMessage());
            }
        }
        if(retryCount >= maxRetryCount)
            return new UsersImportResponse(retryCount,"FAILURE");
        else
            return new UsersImportResponse(0,"SUCCESS");
    }
}
