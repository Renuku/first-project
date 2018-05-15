package org.workflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.workflow.executor.WorkFlowInstance;
import org.workflow.executor.WorkFlowService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path="/")
@Slf4j
public class ExecutorController {
	
	@Autowired
	WorkFlowService workflowService;

	@RequestMapping(path="workflow/{workflowId}/execute" , method = { RequestMethod.POST } )
	public WorkFlowInstance saveWorkFlow( @PathVariable String workflowId) {
		long startTime = System.currentTimeMillis();
		WorkFlowInstance instance = workflowService.startWorkFlow(workflowId);
		long endTime = System.currentTimeMillis();
		log.info(" Time taken : {} ", ( endTime- startTime) );
		return instance;
	}
	
	@RequestMapping(path="instane/{instanceId}/processNext" , method = { RequestMethod.POST } )
	public WorkFlowInstance notifyWorkFlow( @PathVariable String instanceId) {
		long startTime = System.currentTimeMillis();
		WorkFlowInstance instance = workflowService.notifyWorkFlowInstance(instanceId);
		long endTime = System.currentTimeMillis();
		log.info(" Time taken : {} ", ( endTime- startTime) );
		return instance;
	}
	
}
