package org.workflow.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.workflow.definition.WorkflowDefinition;
import org.workflow.definition.service.WorkFlowDefinitionService;

@RestController
@RequestMapping(path="/")
public class DefinitionController {

	private WorkFlowDefinitionService service;
	
	public DefinitionController(WorkFlowDefinitionService service) {
		super();
		this.service = service;
	}

	@RequestMapping(path="workflow" , method = { RequestMethod.POST } )
	public void saveWorkFlow( @RequestBody WorkflowDefinition definition) {
		service.saveWorkFlow(definition);
	}
	
}
