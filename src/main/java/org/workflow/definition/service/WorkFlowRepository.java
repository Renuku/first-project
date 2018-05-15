package org.workflow.definition.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.workflow.definition.WorkflowDefinition;

@Repository
class WorkFlowRepository {
	
	private static String COLLECTION_NAME = "workflowDefinition";
	private MongoTemplate mongoTemplate;

	public WorkFlowRepository(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}
	
	public void saveWorkFlowDefinition(WorkflowDefinition definition) {
		mongoTemplate.save(definition, COLLECTION_NAME);
	}
	
	public WorkflowDefinition getWorkFlowDefinition(String definitionId) {
		return mongoTemplate.findOne( getIdQuery(definitionId) , WorkflowDefinition.class, COLLECTION_NAME);
	}
	
	Query getIdQuery(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		return query;
	}
}
