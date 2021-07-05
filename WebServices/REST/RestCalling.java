            if (validationFlag == "Y") {
                JSONObject obj = new JSONObject();
                obj.put("amount", amount.toString());
                obj.put("currencyCode", currencyCode.toString());
                obj.put("glDate", receiptDate.toString());
                if (chequeEffectiveDate != null) {
                    obj.put("maturityDate", chequeEffectiveDate.toString());
                } else {
                    obj.put("maturityDate", receiptDate.toString());
                }
                obj.put("orgId", orgId.toString());
                obj.put("customerId", customerId.toString());
                obj.put("receiptDate", receiptDate.toString());
                obj.put("receiptMethodId", receiptMethodId.toString());
                 if (chequeNo != null) {
                    obj.put("chequeNo", chequeNo.toString());
                } 
                obj.put("receiptNumber", receiptNumber.toString());
                obj.put("leaseNumber", leaseNumber.toString());
                obj.put("bookingNumber", bookingNumber.toString());
                obj.put("building", building);
                obj.put("unit", unit);
                obj.put("environment", environment.toString());

                JSFUtils.addFacesInformationMessage("Receipt Create JSON Payload" + obj.toString());
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, obj.toJSONString());
                Request request =
                    new Request.Builder().url("http://00.00.00.00/Al-Integrations/webresources/receipt/create/v1").post(body).addHeader("Content-Type",
                    "application/json").addHeader("Cache-Control",
                    "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                  "493ffe37-eaac-45fc-9962-8c6883aff73e").build();

                Response response = client.newCall(request).execute();
                JSFUtils.addFacesInformationMessage("Receipt Create JSON Payload Response" + response);
                InputStream isr = response.body().byteStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
                StringBuilder out = new StringBuilder();
                String resultsXml;

                while ((resultsXml = reader.readLine()) != null) {
                    out.append(resultsXml);
                }
                JSFUtils.addFacesInformationMessage("Receipt Response" + out);

                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject)parser.parse(out.toString());
                JSFUtils.addFacesInformationMessage("Invoice Response as JSON" + jsonObject);
                Object receiptId = jsonObject.get("cash_reciept_id");
                JSFUtils.addFacesInformationMessage("Invoice Response in  receiptId" + jsonObject);
                receiptVO.getCurrentRow().setAttribute("Attribute1", receiptId);
                this.attributResponse.setValue(receiptId);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAttributResponse());
                ADFUtils.findOperation("Commit").execute();
            }
