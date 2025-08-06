public class AppiumTestRunner {

    public static void main(String[] args) {
        System.out.println("Starting Samsung Calculator App Test...");
        System.out.println("Make sure your Samsung device is connected and Appium server is running on port 4723");

        AndroidCalculatorTest test = new AndroidCalculatorTest();

        try {
            // Set up the test
            test.setUp();

            // Run the test
            test.testCalculatorLaunch();

            // Clean up
            test.tearDown();

            System.out.println("Test completed successfully!");

        } catch (Exception e) {
            System.err.println("Test failed with error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

