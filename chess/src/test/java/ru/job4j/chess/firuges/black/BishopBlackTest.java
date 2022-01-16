package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenCorrectPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertEquals(Cell.C8, bishopBlack.position());
    }

    @Test
    public void whenCorrectCopyWhenCorrectPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure figure = bishopBlack.copy(Cell.D7);
        assertEquals(Cell.D7, figure.position());
    }

    @Test
    public void whenRightUpDiagonalWhenCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, cells);
    }

    @Test
    public void whenLeftUpDiagonalWhenCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] cells = bishopBlack.way(Cell.A7);
        Cell[] expected = {Cell.C5, Cell.B6, Cell.A7};
        assertArrayEquals(expected, cells);
    }

    @Test
    public void whenLeftDownDiagonalWhenCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] cells = bishopBlack.way(Cell.A1);
        Cell[] expected = {Cell.C3, Cell.B2, Cell.A1};
        assertArrayEquals(expected, cells);
    }

    @Test
    public void whenRightDownDiagonalWhenCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] cells = bishopBlack.way(Cell.G1);
        Cell[] expected = {Cell.E3, Cell.F2, Cell.G1};
        assertArrayEquals(expected, cells);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenIsNotDiagonalThenFail() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack.way(Cell.A2);
    }
}