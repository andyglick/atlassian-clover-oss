package com.atlassian.clover.ant.types;

import com.atlassian.clover.api.optimization.Optimizable;
import org.apache.tools.ant.types.Resource;

class TestResource implements Optimizable {
    private final Resource resource;

    TestResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String getName() {
        return BaseCloverOptimizedType.normalizePath(resource.getName());
    }

    Resource getResource() {
        return resource;
    }
}
