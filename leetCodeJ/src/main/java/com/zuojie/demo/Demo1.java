package com.zuojie.demo;

/**
 * Created by jay on 17/2/15.
 */
@MyAnnotation(color = "blue")
public class Demo1 {
    public static void main(String[] args){
        //检查类AnnotationTest是否含有@MyAnnotation注解
        if(Demo1.class.isAnnotationPresent(MyAnnotation.class)) {
            //若存在就获取注解, 此处应用了反射
            MyAnnotation annotation = Demo1.class.getAnnotation(MyAnnotation.class);
            System.out.println(annotation);
            //获取注解属性
            System.out.println(annotation.color());
            System.out.println(annotation.value());
            //数组
            int[] arrs = annotation.array();
            for (int arr : arrs) {
                System.out.println(arr);
            }
            //枚举
            Gender gender = annotation.gender();
            System.out.println("性别为：" + gender);
            //获取注解属性
            MetaAnnotation meta = annotation.metaAnnotation();
            System.out.println(meta.birthday());
        }
    }
}
