package com.ford.xapi.provider

interface XApiDataModelAdapter {

    /**
     * Retruns Single<XApiDataModel> that is the previously updated XApiModel or returns
     * an empty XApiDataModel if there is no model stored or there is an error reading the model
     */
    fun getModel(): Single<XApiDataModel>

    /**
     * Replace the previous XApiDataModel with the supplied parameter
     *
     * @param xApiDataModel is saved to persistent storage replacing the previous stored model
     */
    fun updateModel(xApiDataModel: XApiDataModel)

    /**
     * Deletes the persistent XApiDataModel
     */
    fun deleteModel()
}