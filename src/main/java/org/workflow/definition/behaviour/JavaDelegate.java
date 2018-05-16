package org.workflow.definition.behaviour;

import org.workflow.executor.WorkFlowInstance;

public interface JavaDelegate {
	void execute(WorkFlowInstance instance);
}
