package com.qs.cola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

public class MyBean {
	 @Autowired
     private TaskExecutor executor;

     public void runTasks () {
    	 GeneratePDF doc = new GeneratePDF();
         for (int i = 0; i < 150; i++) {
             executor.execute(doc.writePDF(i));
         }
         System.out.println("se enviaron todos los archivos	");
     }
//     private Runnable getTask (int i) {
//         new GeneratePDF().writePDF(i);
//
//         return () -> {
//            System.out.printf("running task %d. Thread: %s%n",
//                              i,
//                              Thread.currentThread().getName());
//        };
//    }
}
