package ci553.happyshop.auth

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class AuthServiceTest {
    @Test
    fun login_success_customer() {
        val authService = AuthService()
        val result = authService.login("cust1", "1234")

        Assertions.assertTrue(result.isPresent())
        Assertions.assertEquals(Role.CUSTOMER, result.get().getRole())
    }

    @Test
    fun login_success_picker() {
        val authService = AuthService()
        val result = authService.login("picker1", "1234")

        Assertions.assertTrue(result.isPresent())
        Assertions.assertEquals(Role.PICKER, result.get().getRole())
    }

    @Test
    fun login_fail_wrong_password() {
        val authService = AuthService()
        val result = authService.login("cust1", "wrong")

        Assertions.assertTrue(result.isEmpty())
    }

    @Test
    fun login_fail_unknown_user() {
        val authService = AuthService()
        val result = authService.login("unknown", "1234")

        Assertions.assertTrue(result.isEmpty())
    }
}