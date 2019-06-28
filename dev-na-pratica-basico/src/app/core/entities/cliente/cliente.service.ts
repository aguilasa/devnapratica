import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ClienteDto } from './cliente-dto';
import { EntityService } from '../entity-service';


@Injectable()
export class ClienteService extends EntityService<ClienteDto> {

    constructor(protected http: HttpClient) {
        super(http, 'cliente');
    }
}
