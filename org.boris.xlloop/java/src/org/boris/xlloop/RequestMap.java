/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Peter Smith
 *******************************************************************************/
package org.boris.xlloop;

import java.util.HashMap;
import java.util.Map;

import org.boris.variantcodec.VTMap;
import org.boris.variantcodec.Variant;

public class RequestMap implements RequestHandler
{
    private Map requests = new HashMap();

    public void add(String name, Request r) {
        this.requests.put(name, r);
    }

    public void remove(String name) {
        this.requests.remove(name);
    }

    public void clear() {
        this.requests.clear();
    }

    public Variant execute(String name, VTMap args) throws RequestException {
        Request r = (Request) requests.get(name);
        if (r == null) {
            throw new RequestException("Unknown request: " + name);
        }
        return r.execute(args);
    }

    public boolean hasRequest(String name) {
        return requests.containsKey(name);
    }
}
