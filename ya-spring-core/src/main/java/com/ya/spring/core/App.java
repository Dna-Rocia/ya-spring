package com.ya.spring.core;

import com.daily.exception.handle.CustomException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        a();
    }


    public static void a(){
        try {
            System.out.println(1%0 == 0);
        }catch (CustomException e){
            e.printStackTrace();
        }
    }
}
