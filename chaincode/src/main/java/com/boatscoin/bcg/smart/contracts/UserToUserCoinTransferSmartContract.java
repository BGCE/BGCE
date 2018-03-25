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

package com.boatscoin.bcg.smart.contracts;

import com.boatscoin.bcg.domain.CoinUserToUserTransferEvent;
import com.boatscoin.bcg.utils.ChaincodeUtils;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.shim.ChaincodeBase;
import org.hyperledger.fabric.shim.ChaincodeStub;

public class UserToUserCoinTransferSmartContract extends ChaincodeBase {

    private static Log LOG = LogFactory.getLog(CoinEmissionSmartContract.class);

    private Gson gson = new Gson();

    @Override
    public Response init(ChaincodeStub chaincodeStub) {
        return newSuccessResponse();
    }

    @Override
    public Response invoke(ChaincodeStub chaincodeStub) {
        CoinUserToUserTransferEvent transferEvent =
                ChaincodeUtils.firstArgumentToObject(chaincodeStub.getStringArgs(), CoinUserToUserTransferEvent.class);
        //TODO validation
        //TODO Check access
        //TODO rewards


       // chaincodeStub.putStringState(ChaincodeUtils.createUUID(), gson.toJson(coinEmissionEvent));
        return newSuccessResponse();

    }
}
