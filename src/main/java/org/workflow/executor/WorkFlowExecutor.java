package org.workflow.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.workflow.definition.FlowNode;
import org.workflow.definition.Transition;
import org.workflow.definition.WorkflowDefinition;
import org.workflow.definition.behaviour.NodeBehaviour;
import org.workflow.definition.behaviour.NodeBehaviourFactory;
import org.workflow.executor.WorkFlowInstance.Status;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WorkFlowExecutor {
	
	@Autowired
	NodeBehaviourFactory behaviourFactory;
	@Autowired
	WorkFlowInstanceRepository instanceRepository;
	
	//TODO interface has to change later
	private void execute( WorkFlowInstance instance, WorkflowDefinition definition, String nodeId ) {
		
		while( nodeId != null ) {
			log.debug("Current Node Id {} ", nodeId);
			FlowNode node = definition.getNodeById(nodeId);
			NodeBehaviour behaviour = behaviourFactory.getBehaviourByType(node);
			behaviour.execute(instance);
			Transition next = behaviour.getTrasition();
			nodeId = ( next != null ) ? next.getToNode() : null;
		}
		
	}
	
	public WorkFlowInstance startWorkFlow(WorkflowDefinition definition ) {
		
		log.debug("starting instance");
		WorkFlowInstance instance = new WorkFlowInstance();
		instance.setName(definition.getName());
		instance.setWorkFlowDefinitionId(definition.getId());
		instance.setStatus(Status.IN_PROGRESS);
		
		execute(instance, definition,definition.getStartNodeId() );
		
		log.debug("save Instance ");
		instanceRepository.saveWorkFlowInstance(instance);
		
		log.debug("instance started {} ",instance);
		
		return instance;
	}
	
	public WorkFlowInstance notify( WorkflowDefinition definition, WorkFlowInstance instance ) {
		// Add some logic for validation
		log.debug("Notify instance : {} ", instance);
		
		String nodeId = instance.getCurrentNodeId();
		FlowNode node = definition.getNodeById(nodeId);
		NodeBehaviour behaviour = behaviourFactory.getBehaviourByType(node);
		behaviour.notify(instance);
		Transition next = behaviour.getTrasition();
		nodeId = ( next != null ) ? next.getToNode() : null;
		
		if( nodeId != null ) {
			execute( instance, definition, nodeId);
		}
		
		log.debug("save Instance ");
		instanceRepository.saveWorkFlowInstance(instance);
		
		log.debug("instance started {} ",instance);
		
		return instance;
	}
	
	
}
