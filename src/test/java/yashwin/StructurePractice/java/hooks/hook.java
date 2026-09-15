package yashwin.StructurePractice.java.hooks;

import yashwin.StructurePractice.java.context.TestContext;
import io.cucumber.java.After;

public class hook {

    private TestContext testContext;

    public hook(TestContext testContext) {
        this.testContext = testContext;
    }

    @After
    public void closeBrowser() {
        testContext.quitDriver();
    }
}