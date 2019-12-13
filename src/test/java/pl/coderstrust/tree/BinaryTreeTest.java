package pl.coderstrust.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {

    @Test
    @DisplayName("Adding some elements to tree and finding them there.")
    public void shouldAddSomeElementsToTreeAndFindThemThere() {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        assertTrue(tree.find(5));
        assertTrue(tree.find(3));
        assertTrue(tree.find(7));
    }

    @Test
    @DisplayName("Finding elements in empty tree, should return false")
    public void shouldReturnFalseForFindOnEmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertFalse(tree.find(0));
        assertFalse(tree.find(10));
    }

    @Test
    @DisplayName("Adding some elements to tree, and deleting some of them")
    public void shouldRemoveSomeElementsFromTree() {
        BinaryTree tree = new BinaryTree();
        tree.add(3);
        tree.add(5);
        tree.add(8);
        tree.add(10);
        tree.delete(5);
        tree.delete(8);
        assertFalse(tree.find(5));
        assertFalse(tree.find(8));
    }

    @Test
    @DisplayName("Adding some elements to tree and getting all elements in in-order")
    public void shouldReturnTreeElementsInOrder() {
        BinaryTree tree = new BinaryTree();
        tree.add(3);
        tree.add(5);
        tree.add(8);
        tree.add(10);
        tree.add(7);
        assertEquals(new ArrayList<>(Arrays.asList(3, 5, 7, 8, 10)), tree.getInOrder());
    }

    @Test
    @DisplayName("Adding some elements to tree and getting all elements in pre-order")
    public void shouldReturnTreeElementsPreOrder() {
        BinaryTree tree = new BinaryTree();
        tree.add(3);
        tree.add(5);
        tree.add(8);
        tree.add(10);
        tree.add(7);
        assertEquals(new ArrayList<>(Arrays.asList(3, 5, 8, 7, 10)), tree.getPreOrder());
    }

    @Test
    @DisplayName("Adding some elements to tree and getting all elements in post-order")
    public void shouldReturnTreeElementsPostOrder() {
        BinaryTree tree = new BinaryTree();
        tree.add(3);
        tree.add(5);
        tree.add(8);
        tree.add(10);
        tree.add(7);
        assertEquals(new ArrayList<>(Arrays.asList(7, 10, 8, 5, 3)), tree.getPostOrder());
    }
}
