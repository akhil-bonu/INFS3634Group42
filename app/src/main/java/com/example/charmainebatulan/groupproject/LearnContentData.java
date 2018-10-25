package com.example.charmainebatulan.groupproject;

import java.util.HashMap;

public class LearnContentData {

    // store content data for learn page
    public static HashMap<Integer, Content> content = new HashMap(){{
        put(0, new Content(0, "Superclass and Subclass", R.drawable.inheritance_diagram, "Inheritance enables you to define a general class and later extend it to more specialised classes. You use a class to model objects of the same type. " +
                "The specialised classes inherit the properties and methods from the general class. \n" +
                "\nSuperclass: different classes have some common properties and behaviours which can be generalised in a class that can be shared by other classes. \n " +
                "\nSubclass: The class which inherits the properties of other is known as subclass (derived class, child class) and the class whose properties are inherited is known as superclass (base class, parent class.\n" +
                "\nWith the use of inheritance the information is made manageable in a hierarchical order. \n" +
                "\nReusability: Inheritance supports the concept of “reusability”, i.e. when we want to create a new class and there is already a class that includes some of the code that we want, we can derive our new class from the existing class. " +
                "By doing this, we are reusing the fields and methods of the existing class." ));
        put(1, new Content(1, "Super Keyword", R.drawable.superkeyword, "The super keyword in Java is a reference variable which is used to refer immediate parent class object.\n" +
                "\nWhenever you create the instance of subclass, an instance of parent class is created implicitly which is referred by super reference variable.\n" +
                " \n\nUsage of Java super Keyword:\n" +
                " \n    1.  super can be used to refer immediate parent class instance variable.\n" +
                "   2.  super can be used to invoke immediate parent class method.\n" +
                "   3.  super() can be used to invoke immediate parent class constructor."));
        put(2, new Content(2, "Defining A Subclass", R.drawable.subclass, "To create a subclass of another class use the extends clause in your class declaration. " +
                "As a subclass, your class inherits member variables and methods from its superclass. " +
                "Your class can choose to hide variables or override methods inherited from its superclass.\n" +
                "\nExtends:  When one class extends an existing class, the extending class automatically inherits functionality that’s defined in the existing class.\n" +
                "\nYou can also:\n" +
                "\n1. Add new properties\n" +
                "\n2. Add new methods\n" +
                "\n3. Override the methods of the superclass \n"));
        put(3, new Content(3, "Overriding Methods", R.drawable.overriding, "To override a method, the method must be defined in the subclass using the same signature and the same return type as in its superclass.\n" +
                "\nA subclass inherits methods from a superclass but sometimes it is necessary for the subclass to modify the implementation of a method defined in the superclass" +
                "\n\nRules for overriding:" +
                "\n\n1. The method must have the same name as in the parent class" +
                "\n\n2. The method must have the same parameter as in the parent class." +
                "\n\n3. There must be an IS-A relationship (inheritance)." +
                "\n\nWhy can we not override a static method?" +
                "\nIt is because the static method is bound with class whereas instance method is bound with an object. " +
                "Static belongs to the class area, and an instance belongs to the heap area."));
        put(4, new Content(4, "Overriding vs. Overloading", R.drawable.overloadride, "Method Overloading:\n" +
                "\n1. Method overloading is used to increase the readability of the program." +
                "\n\n2. Method overloading is performed within class." +
                "\n\n3. In case of method overloading, parameter must be different." +
                "\n\n4. Method overloading is the example of compile time polymorphism." +
                "\n\n5. In java, method overloading can't be performed by changing return type of the method only. " +
                "Return type can be same or different in method overloading. But you must have to change the parameter.\n" +
                "\n\nMethod Overriding:\n" +
                "\n1. Method overriding is used to provide the specific implementation of the method that is already provided by its super class." +
                "\n\n2. Method overriding occurs in two classes that have IS-A (inheritance) relationship." +
                "\n\n3. In case of method overriding, parameter must be same." +
                "\n\n4. Method overriding is the example of run time polymorphism." +
                "\n\n5. Return type must be same or covariant in method overriding."));
        put(5, new Content(5, "Access Modifiers", R.drawable.visibility_modifier, "Visibility can be used on classes and class members (data and methods)." +
                "\n\n\nDefault:" +
                "\n\nDefault access modifier means we do not explicitly declare an access modifier for a class, field, method, etc.\n" +
                "\n" +
                "A variable or method declared without any access control modifier is available to any other class in the same package. " +
                "The fields in an interface are implicitly public static final and the methods in an interface are by default public." +
                "\n\nPrivate:\n\n" +
                "Methods, variables, and constructors that are declared private can only be accessed within the declared class itself." +
                "\n\nPrivate access modifier is the most restrictive access level. Class and interfaces cannot be private." +
                " Variables that are declared private can be accessed outside the class, if public getter methods are present in the class." +
                "\n\nUsing the private modifier is the main way that an object encapsulates itself and hides data from the outside world." +
                "\n\nPublic:" +
                "\n\nA class, method, constructor, interface, etc. declared public can be accessed from any other class. " +
                "Therefore, fields, methods, blocks declared inside a public class can be accessed from any class belonging to the Java Universe." +
                "\n\nHowever, if the public class we are trying to access is in a different package, then the public class still needs to be imported. " +
                "Because of class inheritance, all public methods and variables of a class are inherited by its subclasses." +
                "\n\nProtected:\n" +
                "\nVariables, methods, and constructors, which are declared protected in a superclass can be accessed only by the subclasses in other package or any class within the package of the protected members' class." +
                "\n\nThe protected access modifier cannot be applied to class and interfaces. Methods, fields can be declared protected, however methods and fields in a interface cannot be declared protected." +
                "\n\nProtected access gives the subclass a chance to use the helper method or variable, while preventing a nonrelated class from trying to use it."));

    }};

    // store content data for review - code example page
    public static HashMap<Integer, Content> examplesMap = new HashMap(){{
        put(0, new Content(0, "Inheritance Example", R.drawable.one, R.drawable.one_answer));
        put(1, new Content(1, "Constructors", R.drawable.two, R.drawable.two_answer));
        put(2, new Content(2, "Method Overriding", R.drawable.three, R.drawable.three_answer));
        put(3, new Content(3, "Single Inheritance", R.drawable.four, R.drawable.four_answer));
        put(4, new Content(4, "Multilevel Inheritance", R.drawable.five, R.drawable.five_answer));
        put(5, new Content(5, "Hierarchical Inheritance", R.drawable.six, R.drawable.six_answer));
    }};

    public static HashMap<Integer, Content> youtubeMap = new HashMap(){{
        put(0, new Content(0, "Inheritance",  "9JpNY-XAseg", "A simple explanation of the concept of Inheritance, along with a coding demonstration." +
                " This video will help you solidify your understanding of Inheritance."));
        put(1, new Content(1, "Overriding Rules", "zN9pKULyoj4", "Overriding is a key concept in Java, one that is often difficult for people to understand." +
                "This video walks through all the basic concepts of overriding, as well as the rules of overriding. Included is a demonstration of how and where overriding can be used."));
        put(2, new Content(2, "Superclass and Subclass", "0PPKccntohM", "Superclasses and subclasses are the fundamental concepts of Inheritance, demonstrating the relationship between each class. " +
                "This video defines inheritance in Java, primarily focusing on what a superclass and subclass is. It defines the 'is-a' relationship that exists."));
        put(3, new Content(3, "Constructor Chaining", "LS7BzkBzn3Y" , "In more complex relationships, the idea of constructor chaining is used." +
                "This occurs when multiple constructors are used across various classes. " +
                "This video discusses how these constructors work together, specifically the order in which each constructor is called."));
        put(4, new Content(4, "Access Modifiers",  "0JBqL99wjSE", "Depending on the modifier used, certain aspects of the project can be made accessible or inaccessible to others." +
                "Such modifiers are important to control the access to classes, fields and methods. " +
                "This video walks through the various modifiers available, as well as specific examples of how they can be used and the effect it will have."));
        put(5, new Content(5, "Super Keyword", "1ZDApgnufSI", "The super keyword is used to call methods and constructors defined in super classes. " +
                "This is an important concept in inheritance, one that can get quite confusing." +
                "This video offers a simple explanation of what the super keyword is, how it functions and how it can be used within programs."));
    }};

    // store content data for review - youtube playlist page
    // return the content id
    public static Content getContentById(int id){
        return content.get(id);
    }

    public static Content getExampleById(int id){
        return examplesMap.get(id);
    }

    public static Content getVideoById(int id){
        return youtubeMap.get(id);
    }


}





