package org.workflow.definition.behaviour;

import org.workflow.definition.FlowNode;
import org.workflow.definition.Transition;
import org.workflow.executor.WorkFlowInstance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserTaskBehaviour extends NodeBehaviour {

	public UserTaskBehaviour(FlowNode node) {
		super(node);
	}
	
	@Override
	protected void process(WorkFlowInstance instance) {
		log.debug(" User task started  and waiting for response");
	}

	@Override
	public Transition getTrasition() {
		if( instance == null ) {
			throw new RuntimeException(" Execute never called");
		} else if ( instance.getCurrentNodeId() == null ) {
			return node.getTransitions().get(0);
		} else if ( instance.getCurrentNodeId() != null 
				&& node.getId().equals(instance.getCurrentNodeId()) ) {
			return null;
		} else {
			throw new RuntimeException(" Invalid usage ");
		}
	}

	@Override
	public void notify(WorkFlowInstance instance) {
		log.info(" Notified" );
		super.notify(instance);
		markCompleted(instance);
	}
	
}
