import AxiosClient from "./AxiosClient";

class PrdApi {
  constructor(){
    this.client = new AxiosClient('/api/prd')
  }

}

const instance = new PrdApi();

export default instance;
