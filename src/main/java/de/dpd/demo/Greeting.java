package de.dpd.demo;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

/**
 * Created by sven on 16.10.17.
 */
public class Greeting {

    @Size(min = 2)
    private String content;

    public Greeting(String content) {
        this.content = content;
    }

    public Greeting() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @AssertTrue(message = "Sven darf man nicht grüßen")
    public boolean isValid() {
        return !"Sven".equalsIgnoreCase(content);
    }
}
