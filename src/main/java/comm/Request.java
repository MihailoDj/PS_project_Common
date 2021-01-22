/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comm;

import java.io.Serializable;

/**
 *
 * @author Mihailo
 */
public class Request implements Serializable{
    private Operation operation;
    private Object argument;

    public Request() {
    }

    public Request(Operation operation, Object parametar) {
        this.operation = operation;
        this.argument = parametar;
    }

    
    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
