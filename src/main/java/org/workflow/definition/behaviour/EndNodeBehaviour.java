package org.workflow.definition.behaviour;

import org.workflow.definition.FlowNode;
import org.workflow.definition.Transition;
import org.workflow.executor.WorkFlowInstance;
import org.workflow.executor.WorkFlowInstance.Status;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EndNodeBehaviour extends NodeBehaviour {

	public EndNodeBehaviour(FlowNode node) {
		super(node);
	}

	@Override
	protected void process(WorkFlowInstance instance) {
		instance.setStatus(Status.COMPLETED);
		//log.info(" End Node Executed");
		markCompleted(instance);
	}

	@Override
	public Transition getTrasition() {
		return null;
	}
	
}
