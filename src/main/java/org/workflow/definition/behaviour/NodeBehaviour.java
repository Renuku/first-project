package org.workflow.definition.behaviour;

import org.workflow.definition.FlowNode;
import org.workflow.definition.Transition;
import org.workflow.executor.WorkFlowInstance;

public abstract class NodeBehaviour {
	
	protected FlowNode node;
	
	public NodeBehaviour(FlowNode node ) {
		this.node = node;
	}
	protected WorkFlowInstance instance = null;
	
	protected abstract void process(WorkFlowInstance instance);
	
	// TODO - simplistic - We will change interface or correct the behaviour class
	public WorkFlowInstance execute(WorkFlowInstance instance) {
		this.instance = instance;
		instance.setCurrentNodeId(node.getId());
		process(instance);
		return instance;
	}
	
	protected void markCompleted(WorkFlowInstance instance) {
		instance.setCurrentNodeId(null);
	}
	
	public void notify(WorkFlowInstance instance) {
		this.instance = instance;
	}
	
	//TODO - Supporting single flow. May have to support multiple
	public abstract Transition getTrasition() ;
}
