package com.ram.huxley.fitch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageQueue {

    private Message[] queueArray;
    private int queueSize;

    // Sets stack as empty

    private int front, numberOfItems, rear = 0;

    MessageQueue(int size) {

        queueSize = size;

        queueArray = new Message[size];

        // Assigns the value of -1 to every value in the array
        // so I control what gets printed to screen

        Arrays.fill(queueArray, null);

    }

    public void insert(Message input) {

        if (numberOfItems + 1 <= queueSize) {

            queueArray[rear] = input;

            rear++;

            numberOfItems++;

            System.out.println("INSERT " + input + " Was Added to the Stack\n");

        } else {

            System.out.println("Sorry But the Queue is Full");

        }

    }

    // This priority insert will add items in order from high to low

    public void priorityInsert(Message input) {

        int i;

        if (numberOfItems == 0) {

            insert(input);

        } else {

            for (i = numberOfItems - 1; i >= 0; i--) {

                if (input.compareTo(queueArray[i]) == 1) {

                    queueArray[i + 1] = queueArray[i];

                } else break; // Done shifting items in queue

            }

            queueArray[i + 1] = input;

            rear++;

            numberOfItems++;

        }

    }

    public Message remove() {
        if (numberOfItems > 0) {
            System.out.println("Message " + queueArray[front] + " Was Removed From the Queue\n");
            // takes the message and return it to the caller and sets it to null in the array
            Message msg = queueArray[front] ;
            queueArray[front] = null;
            front++;
            numberOfItems--;
            return msg;
        } else {
            System.out.println("Sorry But the Queue is Empty");
            return null;
        }
    }

    public void peek() {

        System.out.println("The First Element is " + queueArray[front]);

    }

    public void displayTheQueue() {

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < queueSize; n++) {

            System.out.format("| %2s " + " ", n);

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < queueSize; n++) {


            if (queueArray[n] == null) System.out.print("|     ");

            else System.out.print(String.format("| %2s " + " ", queueArray[n]));

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        // Number of spaces to put before the F

        int spacesBeforeFront = 3 * (2 * (front + 1) - 1);

        for (int k = 1; k < spacesBeforeFront; k++) System.out.print(" ");

        System.out.print("F");

        // Number of spaces to put before the R

        int spacesBeforeRear = (2 * (3 * rear) - 1) - (spacesBeforeFront);

        for (int l = 0; l < spacesBeforeRear; l++) System.out.print(" ");

        System.out.print("R");

        System.out.println("\n");

    }

    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue(6);

        messageQueue.priorityInsert(MessageBuilderFactory.getMessage("RED"));

        messageQueue.priorityInsert(MessageBuilderFactory.getMessage("YELLOW"));

        messageQueue.priorityInsert(MessageBuilderFactory.getMessage("BLUE"));

        messageQueue.priorityInsert(MessageBuilderFactory.getMessage("RED"));

        messageQueue.priorityInsert(MessageBuilderFactory.getMessage("YELLOW"));

        messageQueue.priorityInsert(MessageBuilderFactory.getMessage("BLUE"));

        messageQueue.displayTheQueue();

        Message message = messageQueue.remove();
        System.out.println(message);


        message = messageQueue.remove();
        System.out.println(message);

        messageQueue.peek();
    }
}
