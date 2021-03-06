package cz.cvut.fit.zum.api;

/**
 *
 * @author Tomas Barton
 */
import cz.cvut.fit.zum.data.Edge;
import java.awt.geom.Point2D;
import java.util.List;

public abstract interface Node {

    /**
     *
     * @return unique ID of Node
     */
    public int getId();

    /**
     * X coordinate on a map in range <0;1>
     *
     * @return x coordinate
     */
    public abstract double getX();

    /**
     * Y coordinate on a map in range <0;1>
     *
     * @return y coordinate
     */
    public abstract double getY();

    /**
     * Return List of directly connected Nodes to this node
     *
     * @return List of neighbor Nodes
     */
    public abstract List<Node> expand();

    /**
     * Return true when final target is reached, otherwise false
     *
     * @return
     */
    public abstract boolean isTarget();

    /**
     * Return true when other is the same as this, otherwise false
     *
     * @param other
     * @return true when other is same as this object
     */
    @Override
    public abstract boolean equals(Object other);

    @Override
    public int hashCode();

    /**
     *
     * @return coordinate of a point
     */
    public abstract Point2D getPoint();
    
    /**
     * 
     * @return List of Node's edges
     */
    public List<Edge> getEdges();
}