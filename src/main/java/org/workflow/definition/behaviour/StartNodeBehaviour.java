package org.workflow.definition.behaviour;

import org.workflow.definition.FlowNode;
import org.workflow.definition.Transition;
import org.workflow.executor.WorkFlowInstance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StartNodeBehaviour extends NodeBehaviour {

	
	public StartNodeBehaviour(FlowNode node) {
		super(node);
	}

	@Override
	public void process(WorkFlowInstance instance) {
		//log.info(" Start Node Executed");
		markCompleted(instance);
	}
	
	@Override
	public Transition getTrasition() {
		return node.getTransitions().get(0);
	}
	
}
