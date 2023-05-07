package org.example.customType;

import io.cucumber.java.DataTableType;
import org.example.domainObject.BillingDetails;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingDetails billingDetailsEntry (Map<String, String> entry) {
        return new BillingDetails(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email")
        );
    }
}
