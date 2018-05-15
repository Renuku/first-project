package org.workflow.controller;

import org.workflow.executor.WorkFlowInstance.Variables;

import lombok.Data;

@Data
public class WorkflowRequest {
	private Variables businessVariables ;
}
