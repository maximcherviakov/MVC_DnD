package com.example.mvc_dnd.DnD.Visitor;

import java.util.TreeMap;

public interface Element {
    TreeMap accept(Visitor visitor);
}
