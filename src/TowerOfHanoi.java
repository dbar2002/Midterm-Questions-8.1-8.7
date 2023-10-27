//8.6 Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
//different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
//of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following
//constraints:
//(1) Only one disk can be moved at a time.
//(2) A disk is slid off the top of one tower onto another tower.
//(3) A disk cannot be placed on top of a smaller disk.
//Write a program to move the disks from the first tower to the last using stacks.

import java.util.Stack;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3; // Change the number of disks as needed
        Tower source = new Tower("Source");
        Tower auxiliary = new Tower("Auxiliary");
        Tower destination = new Tower("Destination");

        // Initialize the source tower with n disks
        for (int i = n; i > 0; i--) {
            source.pushDisk(i);
        }

        moveDisks(n, source, destination, auxiliary);
    }

    public static void moveDisks(int n, Tower source, Tower destination, Tower auxiliary) {
        if (n == 1) {
            // Move the top disk from the source tower to the destination tower
            int disk = source.popDisk();
            destination.pushDisk(disk);
            System.out.println("Move disk " + disk + " from " + source.name + " to " + destination.name);
        } else {
            // Move n-1 disks from source to auxiliary, using destination as auxiliary
            moveDisks(n - 1, source, auxiliary, destination);
            // Move the remaining 1 disk from source to destination
            moveDisks(1, source, destination, auxiliary);
            // Move the n-1 disks from auxiliary to destination, using source as auxiliary
            moveDisks(n - 1, auxiliary, destination, source);
        }
    }

    static class Tower {
        private String name;
        private Stack<Integer> disks;

        public Tower(String name) {
            this.name = name;
            this.disks = new Stack<>();
        }

        public void pushDisk(int disk) {
            disks.push(disk);
        }

        public int popDisk() {
            return disks.pop();
        }
    }
}
