package org.workflow.definition.behaviour;

import org.springframework.stereotype.Component;
import org.workflow.definition.FlowNode;

@Component
public class NodeBehaviourFactory {
	
	public NodeBehaviour getBehaviourByType(FlowNode node) {
		if("start".equals(node.getType()) ) {
			return new StartNodeBehaviour(node);
		} else if("end".equals(node.getType()) ) {
			return new EndNodeBehaviour(node);
		} else if("userTask".equals(node.getType()) ) {
			return new UserTaskBehaviour(node);
		} else {
			throw new RuntimeException("Type not supported");
		}
		
	}
}
