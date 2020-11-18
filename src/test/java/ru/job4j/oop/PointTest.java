package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance3d() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distance3d(b);
        assertThat(dist, closeTo(2, 0.01));
    }
}