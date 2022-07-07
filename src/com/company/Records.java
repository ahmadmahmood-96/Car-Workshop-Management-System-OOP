package com.company;

import java.io.IOException;

public abstract class Records {
    abstract void addRecords() throws IOException;
    abstract void viewRecords() throws IOException, ClassNotFoundException;
    abstract void deleteRecords() throws IOException, ClassNotFoundException;
    abstract void editRecords() throws IOException, ClassNotFoundException;
    abstract void searchRecords() throws IOException, ClassNotFoundException;
    abstract void clearRecords() throws IOException, ClassNotFoundException;

}
