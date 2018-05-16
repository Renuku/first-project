package org.workflow.executor.tasks;

import org.workflow.definition.behaviour.JavaDelegate;
import org.workflow.executor.WorkFlowInstance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendEmail implements JavaDelegate {

	//static boolean sendError = true;
	
	@Override
	public void execute(WorkFlowInstance instance) {
		log.info(" Send Email Service Task Called");
		
	}

}
