// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.suggs.roo.pizzashop.domain;

import java.lang.Float;
import java.lang.String;
import java.util.Set;
import org.suggs.roo.pizzashop.domain.Base;
import org.suggs.roo.pizzashop.domain.Topping;

privileged aspect Pizza_Roo_JavaBean {
    
    public String Pizza.getName() {
        return this.name;
    }
    
    public void Pizza.setName(String name) {
        this.name = name;
    }
    
    public Float Pizza.getPrice() {
        return this.price;
    }
    
    public void Pizza.setPrice(Float price) {
        this.price = price;
    }
    
    public Set<Topping> Pizza.getToppings() {
        return this.toppings;
    }
    
    public void Pizza.setToppings(Set<Topping> toppings) {
        this.toppings = toppings;
    }
    
    public Base Pizza.getBase() {
        return this.base;
    }
    
    public void Pizza.setBase(Base base) {
        this.base = base;
    }
    
}