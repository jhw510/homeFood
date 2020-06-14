package com.food.web.proxy;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

@Component("pxy") @Lazy
public class Proxy {
    public  String string(Object o){
        Function<Object,String> f= String :: valueOf;
        return f.apply(o);
    }
    public int integer(String s ){
        Function<String,Integer> f=Integer::parseInt;
        return  f.apply(s);
    }
    public Boolean equals(String t,String u){
        BiPredicate<String,String> f =String ::equals;
        return f.test(t,u);
    }
    public void println(String a){
        Consumer<String> f =System.out::println;
        f.accept(a);
    }



}
