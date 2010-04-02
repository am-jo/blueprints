package com.tinkerpop.blueprints.pgm.pipes;

import java.util.Iterator;

/**
 * @author: Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OrderedMergePipe<S> extends AbstractPipe<Iterator<S>, S> {

    protected Iterator<S> currentEnds;

    protected void setNext() {
        if (null != this.currentEnds && this.currentEnds.hasNext()) {
            this.nextEnd = this.currentEnds.next();
        } else {
            if ((null == this.currentEnds || !this.currentEnds.hasNext()) && this.starts.hasNext()) {
                this.currentEnds = this.starts.next();
                this.setNext();
            } else {
                this.done = true;
            }
        }
    }
}
