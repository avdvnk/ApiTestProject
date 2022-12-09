package tests;

import models.UserReqTO;
import models.UserResTO;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import services.ReqresService;

import static org.assertj.core.api.Assertions.assertThat;

public class PutUpdateUserTest extends BaseTest {

    @Test(description = "Update user with PUT method")
    void test() {
        int userId = 2;
        String name = "morpheus";
        String job = "zion resident";
        UserReqTO body = new UserReqTO(name, job);

        ReqresService service = new ReqresService();
        UserResTO response = service.putUpdateUser(2, body, HttpStatus.SC_OK);

        assertThat(response)
                .extracting(UserResTO::getName)
                .isEqualTo(name);
        assertThat(response)
                .extracting(UserResTO::getJob)
                .isEqualTo(job);
        assertThat(response)
                .extracting(UserResTO::getId)
                .isNull();
        assertThat(response)
                .extracting(UserResTO::getCreatedAt)
                .isNull();
    }
}
