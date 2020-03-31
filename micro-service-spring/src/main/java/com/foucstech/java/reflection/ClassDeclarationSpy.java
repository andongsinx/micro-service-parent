package com.foucstech.java.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * @author wuandong
 * @classname ClassDeclarationSpy
 * @date 2020/3/27 16:42
 */
public class ClassDeclarationSpy {
    public static void main(String... args) throws NoSuchMethodException {
        try {
            Class<?> c = Class.forName("java.util.concurrent.ConcurrentNavigableMap");
            out.format("Class:%n  %s%n%n", c.getCanonicalName());
            out.format("Modifiers:%n  %s%n%n",
                    Modifier.toString(c.getModifiers()));
            out.format("Type Parameters:%n");
            TypeVariable[] tv = c.getTypeParameters();
            Constructor<?> constructor = c.getConstructor();
            Object o = constructor.newInstance();
            if (tv.length != 0) {
                out.format("  ");
                for (TypeVariable t : tv) {
                    out.format("%s ", t.getName());
                    out.format("%s", t.getClass());
                }

                out.format("%n%n");
            } else {
                out.format("  -- No Type Parameters --%n%n");
            }

            out.format("Implemented Interfaces:%n");
            Type[] intfs = c.getGenericInterfaces();
            if (intfs.length != 0) {
                for (Type intf : intfs) {
                    out.format("  %s%n", intf.toString());
                    out.format("  %s%n",intf.getTypeName());
                }
                out.format("%n");
            } else {
                out.format("  -- No Implemented Interfaces --%n%n");
            }

            out.format("Inheritance Path:%n");
            List<Class> l = new ArrayList<Class>();
            printAncestor(c, l);
            if (l.size() != 0) {
                for (Class<?> cl : l)
                    out.format("  %s%n", cl.getCanonicalName());
                out.format("%n");
            } else {
                out.format("  -- No Super Classes --%n%n");
            }

            out.format("Annotations:%n");
            Annotation[] ann = c.getAnnotations();
            if (ann.length != 0) {
                for (Annotation a : ann)
                    out.format("  %s%n", a.toString());
                out.format("%n");
            } else {
                out.format("  -- No Annotations --%n%n");
            }

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException x) {
            x.printStackTrace();
        }
    }

    private static void printAncestor(Class<?> c, List<Class> l) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null) {
            l.add(ancestor);
            printAncestor(ancestor, l);
        }
    }
}
