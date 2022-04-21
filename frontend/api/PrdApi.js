import AxiosClient from "./AxiosClient";

class PrdApi {
  constructor(){
    this.client = new AxiosClient('/api/prd')
  }

  async getDispPrdDtl(prdId){
    const response = (await this.client.get({prdId : prdId})).data;
    return response;
  }
}

const instance = new PrdApi();

export default instance;
