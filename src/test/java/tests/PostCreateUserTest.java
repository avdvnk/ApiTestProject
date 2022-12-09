package tests;

import models.UserReqTO;
import models.UserResTO;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import services.ReqresService;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class PostCreateUserTest extends BaseTest {

    @Test(description = "Create user with POST method")
    void test() {
        String name = "morpheus";
        String job = "leader";

        ReqresService service = new ReqresService();
        UserReqTO body = new UserReqTO(name, job);
        UserResTO response = service.postCreateUser(body, HttpStatus.SC_CREATED);

        assertThat(response.getId())
                .isGreaterThan(String.valueOf(BigInteger.ZERO));
        assertThat(response)
                .extracting(UserResTO::getUpdatedAt)
                .isNull();
        assertThat(response)
                .extracting(UserResTO::getCreatedAt)
                .isNotNull();
        assertThat(response)
                .extracting(UserResTO::getName)
                .isEqualTo(name);
        assertThat(response)
                .extracting(UserResTO::getJob)
                .isEqualTo(job);
    }
}
