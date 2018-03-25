/*
	Copyright Boat's Coin  2018 All Rights Reserved.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

			 http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/

package com.boatscoin.bcg.utils;

import com.google.gson.Gson;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

final public class ChaincodeUtils {

    private static Gson gson = new Gson();

    private ChaincodeUtils() {
    }

    public static <T> T firstArgumentToObject(List<String> args, Class<T> clazz){
        Optional<String> dataOpt = args
                .stream()
                .findFirst();
        String data = dataOpt.orElseThrow(() -> new IllegalStateException("No args provided"));
        return gson.fromJson(data, clazz);
    }

    public static String createUUID(){
        byte[] idBytes = new byte[7];
        new SecureRandom().nextBytes(idBytes);
        return UUID.nameUUIDFromBytes(idBytes).toString();
    }
}
