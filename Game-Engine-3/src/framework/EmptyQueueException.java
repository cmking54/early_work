package framework;

/**
   A class of runtime exceptions thrown by methods to
   indicate that a queue is empty.
*/
public class EmptyQueueException extends RuntimeException {
  
   public EmptyQueueException() { this(null); }
   
   public EmptyQueueException(String message) {
      super(message);
   } 
} 
