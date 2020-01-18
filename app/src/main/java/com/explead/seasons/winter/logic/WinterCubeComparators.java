package com.explead.seasons.winter.logic;

import java.util.Comparator;

public class WinterCubeComparators {

    public static Comparator<WinterMember> UP = (a, b) -> Integer.compare(a.getX(), b.getX());

    public static Comparator<WinterMember> DOWN = (a, b) -> Integer.compare(b.getX(), a.getX());

    public static Comparator<WinterMember> RIGHT = (a, b) -> Integer.compare(b.getY(), a.getY());

    public static Comparator<WinterMember> LEFT = (a, b) -> Integer.compare(a.getY(), b.getY());
}