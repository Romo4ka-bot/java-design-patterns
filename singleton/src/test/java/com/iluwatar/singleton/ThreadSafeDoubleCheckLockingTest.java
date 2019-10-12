/**
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Date: 12/29/15 - 19:26 PM
 *
 * @author Jeroen Meulemeester
 */
public class ThreadSafeDoubleCheckLockingTest extends SingletonTest<ThreadSafeDoubleCheckLocking> {

  /**
   * Create a new singleton test instance using the given 'getInstance' method
   */
  public ThreadSafeDoubleCheckLockingTest() {
    super(ThreadSafeDoubleCheckLocking::getInstance);
  }

  /**
   * Test creating new instance by refection
   */
  @Test(expected = InvocationTargetException.class)
  public void testCreatingNewInstanceByRefection() throws Exception {
    ThreadSafeDoubleCheckLocking instance1 = ThreadSafeDoubleCheckLocking.getInstance();
    Constructor constructor = ThreadSafeDoubleCheckLocking.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    ThreadSafeDoubleCheckLocking instance2 = (ThreadSafeDoubleCheckLocking) constructor.newInstance(null);
  }

}