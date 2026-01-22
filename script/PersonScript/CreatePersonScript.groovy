

import org.moqui.context.ExecutionContext

ExecutionContext ec = context.ec

// Validate input

if( !partyId || !firstName || !lastName)
{
    (
            ec.message.addError("Required Parameters missing : partyId,firstName and lastName are mandatory")
    )
    return
}

// Check if  Party exists

def partyExist = ec.entity.find("Party")
        .condition("partyId", partyId)


if (!partyExist) {
    ec.message.addError("Party not found with partyId: ${partyId}")
    return
}

// Create Person

def personData = ec.entity.makeValue("Person")
personData.setAll(context)
personData.create()

responseMessage = "Person ${firstName} ${lastName} created successfully"