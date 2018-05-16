package org.workflow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.workflow.executor.WorkFlowInstance;
import org.workflow.executor.WorkFlowInstance.Variables;
import org.workflow.executor.WorkFlowService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class WorkflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
	}
	
	//@Bean
	 public CommandLineRunner loadTest(WorkFlowService service) {
		 return ( args ) -> {
			 Variables variables = new Variables();
			 variables.put("test","testValue");
			 Variables notifyVariables = new Variables();
			 variables.put("testNotify","testNotifyValue");
			 
			 long totalTimeTillUser = 0;
			 long totalTimeTillEnd = 0;
			 for ( int i= 0 ; i < 1000 ; i++ ) {
				 long startTime = System.currentTimeMillis();
				 WorkFlowInstance instance = service.startWorkFlow("renu1", variables);
				 long endTime = System.currentTimeMillis();
				 long timeTaken = ( endTime - startTime );
				
				 totalTimeTillUser += timeTaken;
				// log.info("Time Taken till User task : {} ", timeTaken );
				 
				 startTime = System.currentTimeMillis();
				 service.notifyWorkFlowInstance(instance.getId(), notifyVariables);
				 endTime = System.currentTimeMillis();
				 
				 timeTaken = ( endTime - startTime );
				 totalTimeTillEnd += timeTaken;
				 //log.info("Time Taken till end: {} ", timeTaken );
			 }
			 log.info("Total Time Taken : {} , {} , {} ",totalTimeTillUser, totalTimeTillEnd,  (totalTimeTillEnd+totalTimeTillUser)  );
		 };
	 }
	
}
