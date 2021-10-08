package com.leaderli.li_runner.internal;

import javassist.*;
import javassist.bytecode.ClassFilePrinter;
import javassist.bytecode.InstructionPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderSetTest {


    @Test
    void now() {

        assert  OrderSet.now().length() == 8;
        assert  OrderSet.now("yyyy-MM-dd").length() == 10;

    }

    @Test
    void scan() throws IOException, CannotCompileException, InvocationTargetException, IllegalAccessException {
        ClassPool classPool = ClassPool.getDefault();
        String classname = "com.leaderli.li_runner.$110";
        CtClass ct = classPool.makeClass(classname);//Create class



        CtMethod helloM = CtNewMethod.make("public static String now(){ return com.leaderli.li_runner.internal.OrderSet.now();}", ct);
        ct.addMethod(helloM);
        helloM = CtNewMethod.make("public static String now1(){ System.out.println(\"now1: \"+now());return com.leaderli.li_runner.internal.OrderSet.now(now());}", ct);
        ct.addMethod(helloM);
        ClassFilePrinter.print(ct.getClassFile());
        InstructionPrinter.print(helloM,System.out);
        Class kls = ct.toClass();
        String invoke = (String) kls.getDeclaredMethods()[0].invoke(null);
        System.out.println(invoke);
        invoke = (String) kls.getDeclaredMethods()[1].invoke(null);
        System.out.println(invoke);
        System.out.println("test:"+OrderSet.now("12345"));
    }

}