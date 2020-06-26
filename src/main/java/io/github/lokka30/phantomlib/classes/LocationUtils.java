package io.github.lokka30.phantomlib.classes;

import org.bukkit.Location;
import org.bukkit.block.Block;

@SuppressWarnings("unused")
public class LocationUtils {

    public LocationUtils() {
    }

    /**
     * Get the distance between block1 and block2
     *
     * @param block1 the first block
     * @param block2 the second block
     * @return the distance between the two blocks as a double
     */
    public double getDoubleDistanceBetween(Block block1, Block block2) {
        Location location1 = block1.getLocation();
        Location location2 = block2.getLocation();
        return location1.distance(location2);
    }

    /**
     * Get the distance between block1 and block2
     *
     * @param block1 the first block
     * @param block2 the second block
     * @return the distance between the two blocks as an integer
     */
    public int getIntDistanceBetween(Block block1, Block block2) {
        return (int) getDoubleDistanceBetween(block1, block2);
    }
}
