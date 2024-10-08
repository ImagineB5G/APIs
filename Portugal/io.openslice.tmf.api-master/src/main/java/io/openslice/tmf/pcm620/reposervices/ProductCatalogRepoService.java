/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.pcm620.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.pcm620.model.Catalog;
import io.openslice.tmf.pcm620.model.CatalogCreate;
import io.openslice.tmf.pcm620.model.CatalogUpdate;
import io.openslice.tmf.pcm620.model.Category;
import io.openslice.tmf.pcm620.model.CategoryRef;
import io.openslice.tmf.pcm620.repo.ProductCatalogRepository;
import jakarta.validation.Valid;

@Service
public class ProductCatalogRepoService {


	@Autowired
	ProductCatalogRepository catalogRepo;

	@Autowired
	ProductCategoryRepoService categRepoService;
	
	
	public Catalog addCatalog(Catalog c) {

		return this.catalogRepo.save(c);
	}

	public Catalog addCatalog(@Valid CatalogCreate serviceCat) {

		Catalog sc = new Catalog();

		sc = updateCatalogDataFromAPICall(sc, serviceCat);
		return this.catalogRepo.save(sc);
	}
	
	public List<Catalog> findAll() {
		return (List<Catalog>) this.catalogRepo.findByOrderByName();
	}
	
	public Catalog findById(String id) {
		Optional<Catalog> optionalCat = this.catalogRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}
	

	public Catalog findByName(String aName) {
		Optional<Catalog> optionalCat = this.catalogRepo.findByName( aName );
		return optionalCat.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<Catalog> optionalCat = this.catalogRepo.findByUuid(id);
		this.catalogRepo.delete(optionalCat.get());
		return null;

	}

	public Catalog updateCatalog(String id, CatalogUpdate Catalog) {

		Optional<Catalog> optSC = catalogRepo.findByUuid(id);
		if (optSC == null) {
			return null;
		}
		Catalog sc = optSC.get();
		sc = updateCatalogDataFromAPICall(sc, Catalog);
		return this.catalogRepo.save(sc);
	}

	public Catalog updateCatalogDataFromAPICall(Catalog sc, CatalogUpdate Catalog) {
		
		if (Catalog.getName()!=null){
			sc.setName(Catalog.getName());			
		}
		if (Catalog.getDescription()!=null){
			sc.setDescription(Catalog.getDescription());			
		}
		if (Catalog.getLifecycleStatus() != null) {
			sc.setLifecycleStatusEnum(ELifecycle.getEnum(Catalog.getLifecycleStatus()));
		}
		if (Catalog.getVersion() != null) {
			sc.setVersion(Catalog.getVersion());
		}
		sc.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));
		TimePeriod tp = new TimePeriod();
		if (Catalog.getValidFor() != null) {
			tp.setStartDateTime(Catalog.getValidFor().getStartDateTime());
			tp.setEndDateTime(Catalog.getValidFor().getEndDateTime());
			sc.setValidFor(tp);
		}

		// add any new category
		if (Catalog.getCategory() != null) {

			sc.getCategoryObj().clear();
			for (CategoryRef scref : Catalog.getCategory()) {
				Category servcat = this.categRepoService.findByUuid(scref.getId());
				sc.addCategory(servcat);
			}
		}

		return sc;

	}

	public Catalog updateCatalog(Catalog scatalog) {
		return this.catalogRepo.save(scatalog);
	}

}
