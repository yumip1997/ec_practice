import AxiosClient from "./AxiosClient";

class PrdApi {
  constructor(){
    this.client = new AxiosClient('/api/prd')
  }

  async getPrdListByCate(cateId){
    const prdList = await this.client.get(this.client.baseURL + "/list", {cateId : cateId});
    return prdList.data;
  }

}

const instance = new PrdApi();

export default instance;
