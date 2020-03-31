package com.foucstech.java.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import static java.lang.System.out;

/**
 * @author wuandong
 * @classname Book
 * @date 2020/3/30 16:25
 */
enum Tweedle { DEE, DUM }

public class Book {
    public int chapters = 0;
    public String[] characters = { "Alice", "White Rabbit" };
    public Tweedle twin = Tweedle.DEE;

    public static void main(String... args) {
        Book book = new Book();
        String fmt = "%6S:  %-12s = %s%n";

        try {
            Class<?> c = book.getClass();

            Field chap = c.getDeclaredField("chapters");
            out.format(fmt, "before", "chapters", book.chapters);
            chap.setInt(book, 12);
            out.format(fmt, "after", "chapters", chap.getInt(book));

            Field chars = c.getDeclaredField("characters");
            out.format(fmt, "before", "characters",
                    Arrays.asList(book.characters));
            String[] newChars = { "Queen", "King" };
            chars.set(book, newChars);
            out.format(fmt, "after", "characters",
                    Arrays.asList(book.characters));

            Field t = c.getDeclaredField("twin");
            out.format(fmt, "before", "twin", book.twin);
            t.set(book, Tweedle.DUM);
            out.format(fmt, "after", "twin", t.get(book));

            // production code should handle these exceptions more gracefully
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }
    }
}
