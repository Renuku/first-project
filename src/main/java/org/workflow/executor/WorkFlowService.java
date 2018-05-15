package org.workflow.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workflow.definition.WorkflowDefinition;
import org.workflow.definition.service.WorkFlowDefinitionService;
import org.workflow.executor.WorkFlowInstance.Variables;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WorkFlowService {
	
	@Autowired
	WorkFlowExecutor executor;
	
	@Autowired
	WorkFlowDefinitionService definitionService;
	
	@Autowired
	WorkFlowInstanceRepository  instanceRepository;

	public WorkFlowInstance startWorkFlow(String definitionId, Variables variables ) {
		WorkflowDefinition definition = definitionService.getWorkFlow(definitionId);
		log.debug(" Defintion {} ",definition);
		return executor.startWorkFlow(definition, variables);
	}
	
	public WorkFlowInstance notifyWorkFlowInstance(String instanceId , Variables variables) {
		WorkFlowInstance instance = instanceRepository.getWorkFlowInstance(instanceId);
		WorkflowDefinition definition = definitionService.getWorkFlow(instance.getWorkFlowDefinitionId());
		
		log.debug(" Instance {} ",instance);
		return executor.notify(definition, instance, variables);
	}
	
}
