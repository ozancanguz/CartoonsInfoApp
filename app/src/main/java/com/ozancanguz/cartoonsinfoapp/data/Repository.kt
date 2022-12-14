package com.ozancanguz.cartoonsinfoapp.data

import com.ozancanguz.cartoonsinfoapp.data.localdatasource.LocalDataSource
import com.ozancanguz.cartoonsinfoapp.data.remote.RemoteDataSource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@ViewModelScoped
class Repository@Inject constructor(remoteDataSource: RemoteDataSource,
                        localDataSource: LocalDataSource
                                    ){

    var remote=remoteDataSource
    var local=localDataSource


}