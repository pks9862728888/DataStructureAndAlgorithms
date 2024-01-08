package com.lld.designpatterns.creational.builder;

class BuilderDemo {

    public static void main(String[] args) {
        User user = new User.Builder("UserName")
                .age(12)
                .build();
        System.out.println(user);

        User2 user2 = User2.builder()
                .name("Other user")
//                .age(12)
                .build();
        System.out.println(user2);
    }
}
