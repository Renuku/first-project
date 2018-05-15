package org.workflow.definition;

import java.util.List;


import lombok.Data;

@Data
//@TypeAlias("workFlowDefinition")
public class WorkflowDefinition {

	String id;
	String name;
	String startNodeId;
	List<FlowNode> nodes;
	
	
	public FlowNode getStartNode() {
		return getNodeById(startNodeId);
	}
	
	public FlowNode getNodeById( String nodeId ) {
		return nodes.parallelStream().filter( node -> nodeId.equals(node.getId()))
		.findFirst()
		//.orElseThrow( () -> new RuntimeExcepton("Node not found") );
		.get();
	}
	
}
