package com.kevinnh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Few happy path tests for each options of the menu.
 */
class ViewTest {
    private View view;
    private ArrayList<Ticket> ticketList;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        view = new View();
        System.setOut(new PrintStream(out));
    }

    @Test
    void happyPathDisplayAllTicketOpionTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\n3\n3\n".getBytes());
        System.setIn(in);
        App.main(null);
        System.setIn(System.in);
    }

    @Test
    void happyPathDisplaySingleTicketOpionTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n1\n3\n3\n".getBytes());
        System.setIn(in);
        App.main(null);
        System.setIn(System.in);
    }

    @Test
    void displayPageOptionsTest() {
        view.displayPageOptions();

        assertEquals("[3]Main Menu", out.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}