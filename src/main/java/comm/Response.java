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
public class Response implements Serializable{
    private Object result;
    private Exception exception;
    private Operation operation;

    public Response() {
        
    }
    
    public Response(Object result, Exception exception, Operation operation) {
        this.result = result;
        this.exception = exception;
        this.operation = operation;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
    
}
