package cz.cvut.fit.zum.gui;

import cz.cvut.fit.zum.data.NodeImpl;

/**
 *
 * @author Tomas Barton
 */
public class HighlightEdge extends HighlightTask {

    protected NodeImpl start;
    protected NodeImpl end;
    private SearchLayer layer;

    HighlightEdge(SearchLayer layer, NodeImpl start, NodeImpl end) {
        this.layer = layer;
        this.start = start;
        this.end = end;
    }

    @Override
    public void process() {
        layer.higlightEdge(start, end);
    }
}