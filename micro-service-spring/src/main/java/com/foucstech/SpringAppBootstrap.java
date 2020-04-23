package com.foucstech;

import org.springframework.core.env.Profiles;

/**
 * Hello world!
 *
 */

public class SpringAppBootstrap
{
    public static void main( String[] args )
    {
        Profiles of = Profiles.of("(spring & framework) | (spring & java)");
        System.out.println(of.matches(s->{System.out.println(s);return s.equals("spring");}));
        System.out.println( "Hello World!" );
    }
}
