/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ninglz.bamboo.common.feign;

import org.springframework.cloud.context.named.NamedContextFactory;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Dave Syer
 * @author Gregor Zurowski
 */
 public class FeignClientSpecification implements NamedContextFactory.Specification {

	private String name;

	private Class<?>[] configuration;

	FeignClientSpecification() {
	}

	FeignClientSpecification(String name, Class<?>[] configuration) {
		this.name = name;
		this.configuration = configuration;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Class<?>[] getConfiguration() {
		return this.configuration;
	}

	public void setConfiguration(Class<?>[] configuration) {
		this.configuration = configuration;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FeignClientSpecification that = (FeignClientSpecification) o;
		return Objects.equals(this.name, that.name) && Arrays.equals(this.configuration, that.configuration);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.configuration);
	}

	@Override
	public String toString() {
		return new StringBuilder("FeignClientSpecification{").append("name='").append(this.name).append("', ")
				.append("configuration=").append(Arrays.toString(this.configuration)).append("}").toString();
	}

}
