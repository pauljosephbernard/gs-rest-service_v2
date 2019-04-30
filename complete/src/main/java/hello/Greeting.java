package hello;

import lombok.Data;

@Data
public class Greeting {

    private final long id;
    private final String content;
    private final String foo;
    private final String bar;
}
