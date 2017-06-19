package com.lftechnology.boilerplate.entity;

import java.io.Serializable;

/**
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
// @Entity
// @Cacheable
// @Table(name = "users")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 596132053500384579L;

    // @Size(max = 255)
    // @NotNull(message = "name cannot be blank")
    private String name;

    // @Size(max = 255)
    // @NotNull(message = "address cannot be blank")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
