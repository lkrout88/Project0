package org.example.Exception;

/**
 * Throws exception when the user makes a mistake in the CLI
 */

    public class CLIException extends Exception {
        public CLIException(String message){
            super(message);
        }
    }

