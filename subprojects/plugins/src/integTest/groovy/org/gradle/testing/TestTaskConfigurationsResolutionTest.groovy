/*
 * Copyright 2013 the original author or authors.
 *
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
 */

package org.gradle.testing;

import org.gradle.integtests.fixtures.AbstractIntegrationSpec;

/**
 * By Szczepan Faber on 6/17/13
 */
public class TestTaskConfigurationsResolutionTest extends AbstractIntegrationSpec {

    def "should not resolve configurations when there are no tests"() {
        buildFile << """
            apply plugin: 'java'

            configure([configurations.testRuntime, configurations.testCompile]) {
                incoming.beforeResolve { assert false : "should not be resolved" }
            }
        """

        when:
        run("build")

        then:
        noExceptionThrown()
    }
}
