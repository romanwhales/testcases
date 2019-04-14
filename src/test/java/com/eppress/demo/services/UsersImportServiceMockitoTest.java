package com.eppress.demo.services;

import com.eppress.demo.exceptions.UserImportServiceCommunicationFailure;
import com.eppress.demo.model.UsersImportResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersImportServiceMockitoTest {
    @MockBean
    private UserImporter userImporter;

    @Autowired
    private UserImportService userImportService;

    @Test
    public void should_import_users(){
        UsersImportResponse response = userImportService.importUsers();
        assertThat(response.getRetryCount()).isEqualTo(0);
        assertThat(response.getStatus()).isEqualTo("SUCCESS");
    }

    @Test
    public void should_retry_3times_when_UserImportServiceCommunicationFailure_Occured(){
        given(userImporter.importUsers()).willThrow(new UserImportServiceCommunicationFailure());

        UsersImportResponse response = userImportService.importUsers();

        assertThat(response.getRetryCount()).isEqualTo(3);
        assertThat(response.getStatus()).isEqualTo("FAILURE");
    }
}
