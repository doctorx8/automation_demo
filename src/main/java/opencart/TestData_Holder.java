package opencart;

public class TestData_Holder {
    private static String email;

    public TestData_Holder() {
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        TestData_Holder.email = email;
    }
}
