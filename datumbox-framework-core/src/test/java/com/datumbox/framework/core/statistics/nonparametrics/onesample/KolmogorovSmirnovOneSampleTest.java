/**
 * Copyright (C) 2013-2018 Vasilis Vryniotis <bbriniotis@datumbox.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datumbox.framework.core.statistics.nonparametrics.onesample;

import com.datumbox.framework.common.dataobjects.AssociativeArray;
import com.datumbox.framework.common.dataobjects.FlatDataCollection;
import com.datumbox.framework.tests.abstracts.AbstractTest;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for KolmogorovSmirnovOneSample.
 *
 * @author Vasilis Vryniotis <bbriniotis@datumbox.com>
 */
public class KolmogorovSmirnovOneSampleTest extends AbstractTest {
    
    /**
     * Test of test method, of class KolmogorovSmirnovOneSample.
     */
    @Test
    public void testTest() {
        logger.info("test");
        //Example from Dimaki's Non-parametrics notes. It should reject the null hypothesis and return True.
        FlatDataCollection flatDataCollection =  new FlatDataCollection(Arrays.asList(new Object[]{33.4, 33.3, 31.0, 31.4, 33.5, 34.4, 33.7, 36.2, 34.9, 37.0}));
        String cdfMethod = "normalDistribution";
        AssociativeArray params = new AssociativeArray();
        params.put("mean", 32.0);
        params.put("variance", 3.24);
        
        boolean is_twoTailed = true;
        double aLevel = 0.05;
        boolean expResult = true;
        boolean result = KolmogorovSmirnovOneSample.test(flatDataCollection, cdfMethod, params, is_twoTailed, aLevel);
        assertEquals(expResult, result);
    }
    
}
