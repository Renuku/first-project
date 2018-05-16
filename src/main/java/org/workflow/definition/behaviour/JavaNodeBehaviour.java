package org.workflow.definition.behaviour;

import org.workflow.definition.ServiceTaskNode;
import org.workflow.definition.Transition;
import org.workflow.executor.WorkFlowInstance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaNodeBehaviour extends NodeBehaviour {

	
	public JavaNodeBehaviour(ServiceTaskNode node) {
		super(node);
	}

	@Override
	public void process(WorkFlowInstance instance) {
		JavaDelegate delegate = getDelegateInstance();
		delegate.execute(instance);
		markCompleted(instance);
	}

	private JavaDelegate getDelegateInstance() {
		String delegateClassName = ( (ServiceTaskNode) node).getAction();
		 try {
			 	
	            Class<?> clazz = Class.forName(delegateClassName);
	            if( JavaDelegate.class.isAssignableFrom(clazz))
	            {
	            	return (JavaDelegate) clazz.newInstance();
	            } else {
	            	throw new RuntimeException("Java class must extend from Java ");
	            }
	        } catch (Exception e) {
	            throw new RuntimeException("couldn't instantiate class " + delegateClassName, e);
	        }
		
	}
	
	@Override
	public Transition getTrasition() {
		return node.getTransitions().get(0);
	}
	
}
