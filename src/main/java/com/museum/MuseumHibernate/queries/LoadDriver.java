package com.museum.MuseumHibernate.queries;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

public class LoadDriver {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver") /*.newInstance()*/ ;
        } catch (Exception ex) {
            // handle the error9?
        }
    }
}