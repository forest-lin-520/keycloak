/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.keycloak.storage.federated;

import org.keycloak.models.RealmModel;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public interface UserRequiredActionsFederatedStorage {

    /**
     * @deprecated Use {@link #getRequiredActionsStream(RealmModel, String) getRequiredActionsStream} instead.
     */
    @Deprecated
    default Set<String> getRequiredActions(RealmModel realm, String userId) {
        return this.getRequiredActionsStream(realm, userId).collect(Collectors.toSet());
    }
    /**
     * Obtains the names of required actions associated with the federated user identified by {@code userId}.
     *
     * @param realm a reference to the realm.
     * @param userId the user identifier.
     * @return a non-null {@code Stream} of required action names.
     */
    Stream<String> getRequiredActionsStream(RealmModel realm, String userId);

    void addRequiredAction(RealmModel realm, String userId, String action);
    void removeRequiredAction(RealmModel realm, String userId, String action);
}
