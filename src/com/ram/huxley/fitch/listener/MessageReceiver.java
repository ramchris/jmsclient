package com.ram.huxley.fitch.listener;
import com.ram.huxley.fitch.Message;
import com.ram.huxley.fitch.MessageComparator;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;


public class MessageReceiver  {

    private SortedSet<Message> storedMessages = new TreeSet<Message>( new MessageComparator());
    BlockingQueue blockingQueue = new PriorityBlockingQueue();


    /**
     * Ideal world this should implement message listener interface and will be called once the message is received from the
     * queue
     * @param message
     */
    public void onMessage(Object message) {
        Message msg = null;
        if(message instanceof Message) {
            msg = (Message) message;
            // Stored in a list. Ideal world we would probably store it in rdbms or in nosql db or in-memory storage.
            storedMessages.add(msg);
        }
        // Add it to the queue for later processing
        blockingQueue.add(msg);
    }
}
