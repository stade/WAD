
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SampleIntegrationTest {

    static String osoite = "http://t-avihavai.users.cs.helsinki.fi/lets/Chat";
    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new HtmlUnitDriver();
    }

    @Test
    public void testLogin() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull("There Should be element tunnus", element);

        // asetetaan kenttään arvo
        element.sendKeys("Arvo");

        // lähetetään lomake
        element.submit();

        // haetaan kenttä nimeltä "viesti"

        element = null;

        try {

            element = webDriver.findElement(By.name("viesti"));

        } catch (NoSuchElementException e) {
            Assert.assertNotNull("There Should be element viesti", element);
        }
    }

    @Test
    public void testUnvalidValueSending() {

        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull(element);

        // asetetaan kenttään arvo jonka ei pitäisi olla validi
        element.sendKeys("Jee");

        // lähetetään lomake
        element.submit();

        element = null;

        try {

            element = webDriver.findElement(By.name("viesti"));

        } catch (NoSuchElementException e) {
            Assert.assertNull("Element should be null because tunnus is too short", element);

        }
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull(element);

        // asetetaan kenttään arvo jona ei pitäisi olla validi
        element.sendKeys("JeeJeeJee");

        // lähetetään lomake
        element.submit();

        element = null;

        // haetaan kenttä nimeltä "viesti"
        try {

            element = webDriver.findElement(By.name("viesti"));

        } catch (NoSuchElementException e) {
            Assert.assertNull("Element should be null because tunnus is too long", element);
        }
    }

    @Test
    public void testMsgSending() {

        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull(element);

        // asetetaan kenttään arvo jonka ei pitäisi olla validi
        element.sendKeys("Arvo");

        // lähetetään lomake
        element.submit();


        element = null;

        try {
            // haetaan kenttä nimeltä "viesti"
            element = webDriver.findElement(By.name("viesti"));
        } catch (NoSuchElementException e) {
            Assert.assertNotNull("Element should not be null because tunnus is valid", element);
        }
        // asetetaan kenttään arvo jona ei pitäisi olla validi
        element.sendKeys("äääööäääöööääö<-->");

        // lähetetään lomake
        element.submit();


        String source = webDriver.getPageSource();
        boolean bool = source.contains("äääööäääöööääö<-->");

        Assert.assertFalse("Page Should not contain invalid message", bool);

    }
}