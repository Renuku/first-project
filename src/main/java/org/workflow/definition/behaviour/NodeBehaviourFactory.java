package org.workflow.definition.behaviour;

import org.springframework.stereotype.Component;
import org.workflow.definition.FlowNode;
import org.workflow.definition.ServiceTaskNode;

@Component
public class NodeBehaviourFactory {
	
	public NodeBehaviour getBehaviourByType(FlowNode node) {
		if("start".equals(node.getType()) ) {
			return new StartNodeBehaviour(node);
		} else if("end".equals(node.getType()) ) {
			return new EndNodeBehaviour(node);
		} else if("userTask".equals(node.getType()) ) {
			return new UserTaskBehaviour(node);
		} else if( node instanceof ServiceTaskNode ) {
			return new JavaNodeBehaviour((ServiceTaskNode) node);
		}{
			throw new RuntimeException("Type not supported");
		}
		
	}
}
