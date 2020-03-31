package com.foucstech.java.reflection;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/5/6
 */
public class ClassTest {

    /**
     * 1、Class.GetEnclosingClass
     * <doc>获取对应类的直接外部类Class对象</doc>
     * 2、Class.GetDeclaringClass
     * <doc>获取对应类的声明类Class对象</doc>
     * 3、两者的区别
     * <p>
     * GetEnclosingClass与GetDeclaringClass很相近
     * 两者的区别在于匿名内部类、getEnclosingClass对匿名内部类也有效
     */
    public static void main(String[] args) {
        Class<?> enclosingClass = InnerClass.class.getEnclosingClass();
        System.out.println(enclosingClass.getName());

        Class<?> declaringClass = InnerClass.class.getDeclaringClass();
        System.out.println(declaringClass.getName());

        //注意：GetEnclosingClass获取的是直接定义该类的外部类Class实例、这点和getDeclaringClass一致
        Class<?> enclosingClass1 = InnerClass.InnerInnerClass.class.getEnclosingClass();
        System.out.println(enclosingClass1.getName());

        Class<?> declaringClass1 = InnerClass.InnerInnerClass.class.getDeclaringClass();
        System.out.println(declaringClass1.getName());

        //针对匿名内部类的测试
        DifferentBetweenClassGetEnclosingClassAndDeclaringClass s = new DifferentBetweenClassGetEnclosingClassAndDeclaringClass();
        HelloService inst = s.getHelloService();
        inst.sayHello();
    }

    private class InnerClass {

        private class InnerInnerClass {

        }
    }


    public interface HelloService {

        void sayHello();
    }


    public static class DifferentBetweenClassGetEnclosingClassAndDeclaringClass {

        HelloService getHelloService() {
            //匿名内部类
            return new HelloService() {

                @Override
                public void sayHello() {
                    System.out.println(this.getClass().getEnclosingClass());

                    System.out.println(this.getClass().getDeclaringClass());

                }

            };
        }

    }
}
