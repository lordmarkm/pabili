package com.pabili.commons.web;

import java.security.Principal;

public abstract class GenericController {

    public String name(Principal principal) {
        return null == principal ? "Anonymous" : principal.getName();
    }

}
