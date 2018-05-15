package org.workflow.executor;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude( JsonInclude.Include.NON_NULL )
public class WorkFlowInstance {
	private String id;
	private String name;
	private String workFlowDefinitionId;
	private String currentNodeId;
	private Status status;
	private Variables data = new Variables();
	
	public static enum Status {
		IN_PROGRESS,
		COMPLETED
	}
	
	public static class Variables extends HashMap<String,Object> {
		
	}
}
