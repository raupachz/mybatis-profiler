/*
 * Copyright 2017 Björn Raupach <raupach@me.com>
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
package org.raupach.plugin.profiler;

public class SessionManager {

    private static final ThreadLocal<Session> INSTANCE = new ThreadLocal<Session>() {

        @Override
        protected Session initialValue() {
            return null;
        }
    };
    
    public static Session newSession(String name) {
        Session session = new Session(name);
        INSTANCE.set(session);
        return session;
    }

    public static Session currentSession() {
        return INSTANCE.get();
    }

    public static void destroySession() {
        INSTANCE.remove();
    }

}
