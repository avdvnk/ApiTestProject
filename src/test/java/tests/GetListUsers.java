package tests;

import models.ListUsersResTO;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import services.ReqresService;

import static org.assertj.core.api.Assertions.assertThat;

public class GetListUsers extends BaseTest {

    @Test(description = "Get list users with GET method")
    void test() {
        int page = 2;

        ReqresService service = new ReqresService();
        ListUsersResTO response = service.getListUsers(page, HttpStatus.SC_OK);

        assertThat(response)
                .extracting(ListUsersResTO::getData)
                .isNotNull();
        assertThat(response)
                .extracting(ListUsersResTO::getSupport)
                .isNotNull();
    }
}
