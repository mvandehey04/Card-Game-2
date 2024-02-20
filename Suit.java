package edu.cs2430.assignment5;

public enum Suit{
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
