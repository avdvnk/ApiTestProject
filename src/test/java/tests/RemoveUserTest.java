package tests;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import services.ReqresService;

public class RemoveUserTest extends BaseTest {

    @Test(description = "Remove user with DELETE method")
    void test() {
        int userId = 2;
        ReqresService service = new ReqresService();

        service.deleteUser(userId, HttpStatus.SC_NO_CONTENT);
    }
}
