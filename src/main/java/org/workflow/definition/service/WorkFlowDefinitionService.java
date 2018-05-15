package org.workflow.definition.service;

import org.springframework.stereotype.Service;
import org.workflow.definition.WorkflowDefinition;

@Service
public class WorkFlowDefinitionService {

	private WorkFlowRepository repository;

	public WorkFlowDefinitionService(WorkFlowRepository repository) {
		super();
		this.repository = repository;
	}
	
	public void saveWorkFlow(WorkflowDefinition definition) {
		repository.saveWorkFlowDefinition(definition);
	}
	
	public WorkflowDefinition getWorkFlow(String definitionId) {
		return repository.getWorkFlowDefinition(definitionId);
	}
	
}
