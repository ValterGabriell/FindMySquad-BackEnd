package com.FindMySquad.FindMySquad.Repository;

import com.FindMySquad.FindMySquad.Model.Requisition.ModelRequisition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequisitionRepository extends JpaRepository<ModelRequisition, Integer> {
}
